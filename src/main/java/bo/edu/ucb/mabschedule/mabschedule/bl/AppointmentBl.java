package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.*;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.*;
import bo.edu.ucb.mabschedule.mabschedule.dto.MedicalAppointmentDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public AppointmentBl(ScheduleRepository scheduleRepository, DoctorRepository doctorRepository, PeriodRepository periodRepository, MedicalAppointmentRepository medicalAppointmentRepository, PacientRepository pacientRepository, HospitalDoctorRepository hospitalDoctorRepository){
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
        this.periodRepository = periodRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.pacientRepository = pacientRepository;
        this.hospitalDoctorRepository = hospitalDoctorRepository;
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

    public MedicalAppointmentDto postMedicalAppointment(Long pacientId, Long hospitalDoctorId, MedicalAppointmentDto medicalAppointmentDto){
        logger.info("Initializing postMedicalAppointment");
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
        return new MedicalAppointmentDto(savedMedicalAppointment);
    }

}
