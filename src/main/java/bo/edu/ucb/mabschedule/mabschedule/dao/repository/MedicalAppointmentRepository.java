package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
}
