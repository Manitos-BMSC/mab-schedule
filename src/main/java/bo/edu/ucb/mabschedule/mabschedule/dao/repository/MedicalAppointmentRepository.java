package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

    @Query("SELECT m FROM MedicalAppointment m WHERE m.hospitalDoctorId.doctorId.id = :doctorId")
    List<MedicalAppointment> findByDoctorId(@Param("doctorId") Long doctorId);


}
