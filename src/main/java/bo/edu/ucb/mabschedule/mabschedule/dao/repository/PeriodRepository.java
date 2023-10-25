package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
}
