package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.*;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.*;
import bo.edu.ucb.mabschedule.mabschedule.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleDoctorBl {

    @Autowired
    private final UnavailableScheduleRepository unavailableScheduleRepository;
    @Autowired
    private final ScheduleRepository scheduleDoctorRepository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final PeriodRepository periodRepository;
    @Autowired
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final Logger logger = LoggerFactory.getLogger(ScheduleDoctorBl.class);

    public ScheduleDoctorBl (UnavailableScheduleRepository unavailableScheduleRepository, ScheduleRepository scheduleDoctorRepository, PeriodRepository periodRepository, DoctorRepository doctorRepository, MedicalAppointmentRepository medicalAppointmentRepository){
        this.unavailableScheduleRepository = unavailableScheduleRepository;
        this.scheduleDoctorRepository = scheduleDoctorRepository;
        this.periodRepository = periodRepository;
        this.doctorRepository = doctorRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
    }

    public ScheduleDoctorDto getScheduleDoctorByDoctorId(Integer doctorId, Date actualDate){
        String dateString = actualDate.getYear() + "-" + actualDate.getMonth() + "-" + actualDate.getDate();
        logger.info("Initializing getScheduleDoctorByDoctorId");
        List<UnavailableSchedule> unavailableSchedule = unavailableScheduleRepository.findAvailableSchedulesForDoctor(doctorId, actualDate);
        logger.info("unavailableSchedule: " + unavailableSchedule);
        List<Period> unavailablePeriods = new ArrayList<>();
        List<Schedule> appointments = scheduleDoctorRepository.findSchedulesInSameWeekAsDateForDoctor(dateString, doctorId);
        List<Period> appointmentsPeriods = new ArrayList<>();
        for (Schedule appointment : appointments) {
            appointmentsPeriods.add(appointment.getPeriodId());
        }
        for (UnavailableSchedule unavailableScheduleElement : unavailableSchedule) {
            unavailablePeriods.add(unavailableScheduleElement.getPeriodId());
        }

        List<PeriodDto> unavailablePeriodsDto = PeriodDto.fromEntityList(unavailablePeriods);
        List<PeriodDto> appointmentsPeriodsDto = PeriodDto.fromEntityList(appointmentsPeriods);

        ScheduleDoctorDto scheduleDoctorDto = new ScheduleDoctorDto();
        scheduleDoctorDto.setIdDoctor(doctorId);
        scheduleDoctorDto.setUnavailableSchedules(unavailablePeriodsDto);
        scheduleDoctorDto.setAppointments(appointmentsPeriodsDto);

        return scheduleDoctorDto;
    }

    public void postUnavailableSchedule(Long doctorId, UnavailableSchedulePeriodsDto unavailableSchedulePeriodsDto){
        logger.info("Initializing postUnavailableSchedule");
        Doctor doctor =  doctorRepository.findById(doctorId).orElseThrow();
        logger.info("doctor: " + doctor);

        for(PeriodDto period :  unavailableSchedulePeriodsDto.getPeriods()){
            UnavailableSchedule unavailableSchedule = new UnavailableSchedule();
            unavailableSchedule.setDoctorId(doctor);
            unavailableSchedule.setPeriodId(periodRepository.findById((long)period.getId()).orElseThrow());
            unavailableSchedule.setDateFrom(unavailableSchedulePeriodsDto.getUnavailableSchedule().getDateFrom());
            unavailableSchedule.setDateTo(unavailableSchedulePeriodsDto.getUnavailableSchedule().getDateTo());
            unavailableSchedule.setStatus(true);
            unavailableScheduleRepository.save(unavailableSchedule);
        }

        logger.info("unavailableSchedule saved");
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
            scheduleDoctorRepository.save(schedule);
        }
        logger.info("appointment saved");
    }

}
