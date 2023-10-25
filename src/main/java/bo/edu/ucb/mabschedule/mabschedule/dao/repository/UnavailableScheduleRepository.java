package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.UnavailableSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UnavailableScheduleRepository extends JpaRepository<UnavailableSchedule, Long> {
    @Query("SELECT us FROM UnavailableSchedule us " +
            "WHERE us.doctorId = :doctorId " +
            "AND :searchDate BETWEEN us.dateFrom AND us.dateTo")
    List<UnavailableSchedule> findAvailableSchedulesForDoctor(
            @Param("doctorId") int doctorId,
            @Param("searchDate") Date searchDate
    );
}
