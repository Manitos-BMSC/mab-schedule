package bo.edu.ucb.mabschedule.mabschedule.dao.repository;

import bo.edu.ucb.mabschedule.mabschedule.dao.MedicalAppointment;
import bo.edu.ucb.mabschedule.mabschedule.dao.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

    @Query("SELECT m FROM MedicalAppointment m WHERE m.hospitalDoctorId.doctorId.id = :doctorId and m.medicalAppointmentDate = :date")
    List<MedicalAppointment> findByDoctorIdAndDate(@Param("doctorId") Long doctorId, @Param("date") Date date);

    @Query("SELECT m FROM MedicalAppointment m WHERE m.pacientId = :patient and m.medicalAppointmentDate = :date")
    List<MedicalAppointment> findByPatientIdAndDate(@Param("patient") Pacient patient, @Param("date") Date date);

}
