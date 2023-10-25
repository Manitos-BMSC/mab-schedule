package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "WHERE EXTRACT(WEEK FROM s.scheduleDate) = EXTRACT(WEEK FROM TO_TIMESTAMP(:searchDate, 'YYYY-MM-DD')) " +
            "AND EXTRACT(YEAR FROM s.scheduleDate) = EXTRACT(YEAR FROM TO_TIMESTAMP(:searchDate, 'YYYY-MM-DD')) " +
            "AND s.doctorId.id = :doctorId")
    List<Schedule> findSchedulesInSameWeekAsDateForDoctor(
            @Param("searchDate") String searchDate,
            @Param("doctorId") Integer doctorId
    );

}
