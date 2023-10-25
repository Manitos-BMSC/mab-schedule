package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "WHERE EXTRACT(WEEK FROM s.scheduleDate) = EXTRACT(WEEK FROM :searchDate) " +
            "AND EXTRACT(YEAR FROM s.scheduleDate) = EXTRACT(YEAR FROM :searchDate) " +
            "AND s.doctorId = :doctorId")
    List<Schedule> findSchedulesInSameWeekAsDateForDoctor(
            @Param("searchDate") Date searchDate,
            @Param("doctorId") int doctorId
    );

}
