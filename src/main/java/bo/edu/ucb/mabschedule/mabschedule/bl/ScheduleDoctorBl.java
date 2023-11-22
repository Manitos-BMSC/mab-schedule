package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.*;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.*;
import bo.edu.ucb.mabschedule.mabschedule.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(actualDate);

        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        Date startOfWeek = calendar.getTime();

        calendar.add(Calendar.DAY_OF_WEEK, 6);
        Date endOfWeek = calendar.getTime();


        logger.info("Initializing getScheduleDoctorByDoctorId");

        List<UnavailableSchedule> unavailableSchedule = unavailableScheduleRepository.findUnavailableSchedulesForDoctor(doctorId, actualDate);
        logger.info("unavailableSchedule: " + unavailableSchedule);

        List<Period> unavailablePeriods = new ArrayList<>();

        List<Schedule> appointments = scheduleDoctorRepository.findSchedulesInSameWeekAsDateForDoctor(doctorId, startOfWeek, endOfWeek);
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


}
