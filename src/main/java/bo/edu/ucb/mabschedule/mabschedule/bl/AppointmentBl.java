package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.*;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.*;
import bo.edu.ucb.mabschedule.mabschedule.dto.*;
import bo.edu.ucb.mabschedule.mabschedule.service.FileUploaderService;
import bo.edu.ucb.mabschedule.mabschedule.service.KeycloakTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentBl {

    private final Logger logger = LoggerFactory.getLogger(AppointmentBl.class);
    @Autowired
    private final ScheduleRepository scheduleRepository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final PeriodRepository periodRepository;
    @Autowired
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    @Autowired
    private final PacientRepository pacientRepository;
    @Autowired
    private final HospitalDoctorRepository hospitalDoctorRepository;
    @Autowired
    private final S3ObjectRepository s3ObjectRepository;
    @Autowired
    private final FilesMedialAppointmentRepository filesMedialAppointmentRepository;

    @Autowired
    FileUploaderService fileUploaderService;
    @Autowired
    KeycloakTokenService keycloakTokenService;

    private String bucket = "appointment-docs";

    public AppointmentBl(ScheduleRepository scheduleRepository, DoctorRepository doctorRepository, PeriodRepository periodRepository, MedicalAppointmentRepository medicalAppointmentRepository, PacientRepository pacientRepository, HospitalDoctorRepository hospitalDoctorRepository, S3ObjectRepository s3ObjectRepository, FilesMedialAppointmentRepository filesMedialAppointmentRepository){
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
        this.periodRepository = periodRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.pacientRepository = pacientRepository;
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.s3ObjectRepository = s3ObjectRepository;
        this.filesMedialAppointmentRepository = filesMedialAppointmentRepository;
    }

    public void postAppointmentForDoctor(Long doctorId, Long periodId, Long medicalAppointmentId, ScheduleDto scheduleDto){
        logger.info("Initializing postAppointmentForDoctor");
        Schedule schedule = new Schedule();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Period period = periodRepository.findById(periodId).orElseThrow();
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(medicalAppointmentId).orElseThrow();
        schedule.setDoctorId(doctor);
        schedule.setPeriodId(period);
        schedule.setMedicalAppointmentId(medicalAppointment);
        schedule.setScheduleDate(scheduleDto.getScheduleDate());
        schedule.setState(scheduleDto.getState());
        schedule.setStatus(scheduleDto.isStatus());
        scheduleRepository.save(schedule);
    }

    public MedicalAppointmentDto postMedicalAppointment(Long pacientId, Long hospitalDoctorId, AppointmentScheduleDto appointmentScheduleDto){
        logger.info("Initializing postMedicalAppointment");
        MedicalAppointmentDto medicalAppointmentDto = appointmentScheduleDto.getMedicalAppointment();
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        Pacient pacient = pacientRepository.findById(pacientId).orElseThrow();
        HospitalDoctor hospitalDoctor = hospitalDoctorRepository.findById(hospitalDoctorId).orElseThrow();
        medicalAppointment.setPacientId(pacient);
        medicalAppointment.setHospitalDoctorId(hospitalDoctor);
        medicalAppointment.setMedicalAppointmentDate(medicalAppointmentDto.getMedicalAppointmentDate());
        medicalAppointment.setComments(medicalAppointmentDto.getComments());
        medicalAppointment.setEmitedAppointmentDate(medicalAppointmentDto.getEmitedAppointmentDate());
        medicalAppointment.setReason(medicalAppointmentDto.getReason());
        medicalAppointment.setMedicalAppointmentState(medicalAppointmentDto.getMedicalAppointmentState());
        medicalAppointment.setStatus(true);
        MedicalAppointment savedMedicalAppointment = medicalAppointmentRepository.save(medicalAppointment);

        for(PeriodDto period : appointmentScheduleDto.getPeriods()){
            Schedule schedule = new Schedule();
            schedule.setDoctorId(hospitalDoctor.getDoctorId());
            schedule.setPeriodId(periodRepository.findById((long)period.getId()).orElseThrow());
            schedule.setMedicalAppointmentId(savedMedicalAppointment);
            schedule.setScheduleDate(savedMedicalAppointment.getMedicalAppointmentDate());
            schedule.setState("Pendiente");
            schedule.setStatus(true);
            scheduleRepository.save(schedule);
        }


        return new MedicalAppointmentDto(savedMedicalAppointment);
    }


    public void postAppointment(Long doctorId, Long medicalAppointmentId, SchedulePeriodsDto schedulePeriodsDto){
        logger.info("Initializing postAppointment");
        Doctor doctor =  doctorRepository.findById(doctorId).orElseThrow();
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(medicalAppointmentId).orElseThrow();
        for(PeriodDto period : schedulePeriodsDto.getPeriods()){
            Schedule schedule = new Schedule();
            schedule.setDoctorId(doctor);
            schedule.setPeriodId(periodRepository.findById((long)period.getId()).orElseThrow());
            schedule.setMedicalAppointmentId(medicalAppointment);
            schedule.setScheduleDate(schedulePeriodsDto.getScheduleDate());
            schedule.setState("Pendiente");
            schedule.setStatus(true);
            scheduleRepository.save(schedule);
        }
        logger.info("appointment saved");
    }

    public List<MedicalAppointmentDto> getAppointmentForDoctor(Long doctorId){
        logger.info("Initializing postAppointmentForDoctor");
        List<MedicalAppointment> medicalAppointments = medicalAppointmentRepository.findByDoctorId(doctorId);

        return MedicalAppointmentDto.fromList(medicalAppointments);
    }

    public void postFileForMedicalAppointment(Long medicalAppointmentId, MultipartFile file){
        logger.info("Initializing postFileForMedicalAppointment");
        logger.info("Getting token");
        Map<String, ?> response = keycloakTokenService.getToken(
                "client_credentials",
                "mab_backend",
                "mzhqeGKq8LiwBb9tQ6q1z4HONF6to3tr"
        );

        String token = "Bearer " + response.get("access_token");
        logger.info("Uploading file to bucket: " + bucket);
        FileDto fileDto = fileUploaderService.uploadFile(file, bucket, false, token);
        logger.info("Saving file on database");

        S3Object fileS3 = s3ObjectRepository.findById(fileDto.getS3ObjectId()).get() ;
        FilesMedialAppointment filesMedialAppointment = new FilesMedialAppointment();
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(medicalAppointmentId).get();
        filesMedialAppointment.setMedicalAppointmentId(medicalAppointment);
        filesMedialAppointment.setS3ObjectS3ObjectId(fileS3);
        filesMedialAppointment.setFileDate(new Date());
        filesMedialAppointment.setStatus(true);
        filesMedialAppointmentRepository.save(filesMedialAppointment);
    }

}
