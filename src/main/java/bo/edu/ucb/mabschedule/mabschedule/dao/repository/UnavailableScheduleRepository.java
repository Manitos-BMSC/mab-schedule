package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.UnavailableSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UnavailableScheduleRepository extends JpaRepository<UnavailableSchedule, Long> {
    @Query("SELECT us FROM UnavailableSchedule us " +
            "WHERE us.doctorId.id = :doctorId " +
            "AND us.status = true " +
            "AND :searchDate >= us.dateFrom " +
            "AND (:searchDate <= us.dateTo OR us.dateTo IS NULL)")
    List<UnavailableSchedule> findAvailableSchedulesForDoctor(
            @Param("doctorId") Integer doctorId,
            @Param("searchDate") Date searchDate
    );

}
