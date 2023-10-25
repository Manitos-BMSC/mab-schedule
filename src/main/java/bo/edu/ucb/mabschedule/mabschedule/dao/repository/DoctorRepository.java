package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
