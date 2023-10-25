package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.Doctor;
import bo.edu.ucb.mabschedule.mabschedule.dao.MedicalAppointment;
import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.DoctorRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.MedicalAppointmentRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.PeriodRepository;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.ScheduleRepository;
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

    public AppointmentBl(ScheduleRepository scheduleRepository, DoctorRepository doctorRepository, PeriodRepository periodRepository, MedicalAppointmentRepository medicalAppointmentRepository){
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
        this.periodRepository = periodRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
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
}
