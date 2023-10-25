package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.Doctor;
import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import bo.edu.ucb.mabschedule.mabschedule.dao.UnavailableSchedule;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.DoctorRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.PeriodRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.ScheduleRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.UnavailableScheduleRepository;
import bo.edu.ucb.mabschedule.mabschedule.dto.PeriodDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDoctorDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.UnavailableScheduleDto;
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
    private final Logger logger = LoggerFactory.getLogger(ScheduleDoctorBl.class);

    public ScheduleDoctorBl (UnavailableScheduleRepository unavailableScheduleRepository, ScheduleRepository scheduleDoctorRepository, PeriodRepository periodRepository, DoctorRepository doctorRepository){
        this.unavailableScheduleRepository = unavailableScheduleRepository;
        this.scheduleDoctorRepository = scheduleDoctorRepository;
        this.periodRepository = periodRepository;
        this.doctorRepository = doctorRepository;
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

    public void postUnavailableSchedule(Long doctorId, Long periodId, UnavailableScheduleDto unavailableScheduleDto){
        logger.info("Initializing postUnavailableSchedule");
        UnavailableSchedule unavailableSchedule = new UnavailableSchedule();
        Doctor doctor =  doctorRepository.findById(doctorId).orElseThrow();
        logger.info("doctor: " + doctor);
        Period period = periodRepository.findById(periodId).orElseThrow();
        logger.info("period: " + period);
        unavailableSchedule.setDoctorId(doctor);
        unavailableSchedule.setPeriodId(period);
        unavailableSchedule.setDateFrom(unavailableScheduleDto.getDateFrom());
        unavailableSchedule.setDateTo(unavailableScheduleDto.getDateTo());
        unavailableSchedule.setStatus(unavailableScheduleDto.isStatus());
        logger.info("unavailableSchedule: " + unavailableSchedule);
        unavailableScheduleRepository.save(unavailableSchedule);
        logger.info("unavailableSchedule saved");
    }

}
