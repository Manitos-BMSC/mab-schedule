package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
