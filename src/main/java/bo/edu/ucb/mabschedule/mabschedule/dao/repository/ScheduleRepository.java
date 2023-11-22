package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "WHERE s.doctorId.id = :doctorId " +
            "AND s.scheduleDate BETWEEN :startOfWeek AND :endOfWeek")
    List<Schedule> findSchedulesInSameWeekAsDateForDoctor(
            @Param("doctorId") Integer doctorId,
            @Param("startOfWeek") Date startOfWeek,
            @Param("endOfWeek") Date endOfWeek
    );

}
