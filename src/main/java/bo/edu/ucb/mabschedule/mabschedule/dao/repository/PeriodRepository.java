package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {

    @Query(value = "SELECT * FROM mab_period ORDER BY mab_week_day_id", nativeQuery = true)
    List<Period> findAllOrderByMabWeekDayId();
}
