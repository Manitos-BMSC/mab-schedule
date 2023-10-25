package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import bo.edu.ucb.mabschedule.mabschedule.dao.UnavailableSchedule;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.PeriodRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.ScheduleRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.UnavailableScheduleRepository;
import bo.edu.ucb.mabschedule.mabschedule.dto.PeriodDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDoctorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleDoctorBl {

    private final UnavailableScheduleRepository unavailableScheduleRepository;
    private final ScheduleRepository scheduleDoctorRepository;
    private final PeriodRepository periodRepository;
    private final Logger logger = LoggerFactory.getLogger(ScheduleDoctorBl.class);

    @Autowired
    public ScheduleDoctorBl (UnavailableScheduleRepository unavailableScheduleRepository, ScheduleRepository scheduleDoctorRepository, PeriodRepository periodRepository){
        this.unavailableScheduleRepository = unavailableScheduleRepository;
        this.scheduleDoctorRepository = scheduleDoctorRepository;
        this.periodRepository = periodRepository;
    }

    public ScheduleDoctorDto getScheduleDoctorByDoctorId(Integer doctorId, Date actualDate){
        logger.info("Initializing getScheduleDoctorByDoctorId");
        List<UnavailableSchedule> unavailableSchedule = unavailableScheduleRepository.findAvailableSchedulesForDoctor(doctorId, actualDate);
        List<Period> unavailablePeriods = new ArrayList<>();
        List<Schedule> appointments = scheduleDoctorRepository.findSchedulesInSameWeekAsDateForDoctor(actualDate, doctorId);
        List<Period> appointmentsPeriods = new ArrayList<>();
        for (Schedule appointment : appointments) {
            appointmentsPeriods.add(appointment.getPeriod());
        }
        for (UnavailableSchedule unavailableScheduleElement : unavailableSchedule) {
            unavailablePeriods.add(unavailableScheduleElement.getPeriod());
        }

        List<PeriodDto> unavailablePeriodsDto = PeriodDto.fromEntityList(unavailablePeriods);
        List<PeriodDto> appointmentsPeriodsDto = PeriodDto.fromEntityList(appointmentsPeriods);

        ScheduleDoctorDto scheduleDoctorDto = new ScheduleDoctorDto();
        scheduleDoctorDto.setIdDoctor(doctorId);
        scheduleDoctorDto.setUnavailableSchedules(unavailablePeriodsDto);
        scheduleDoctorDto.setAppointments(appointmentsPeriodsDto);

        return scheduleDoctorDto;
    }

}
