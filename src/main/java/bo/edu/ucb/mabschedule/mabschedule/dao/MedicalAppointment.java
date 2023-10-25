package bo.edu.ucb.mabschedule.mabschedule.dao;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAB_medical_appointment")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medical_appointment")
    private int idMedicalAppointment;

    @Column(name = "pacient_id")
    private int patientId;

    @Column(name = "hospital_doctor_id")
    private int hospitalDoctorId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "emited_appointment_date")
    private Date emitedAppointmentDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "medical_appointment_state")
    private String medicalAppointmentState;

    @Column(name = "medical_appointment_date")
    private Date medicalAppointmentDate;

    @Column(name = "status")
    private boolean status;

    // Getters y Setters

    public MedicalAppointment() {
    }

    public MedicalAppointment(int idMedicalAppointment, int patientId, int hospitalDoctorId, String comments, Date emitedAppointmentDate, String reason, String medicalAppointmentState, Date medicalAppointmentDate, boolean status) {
        this.idMedicalAppointment = idMedicalAppointment;
        this.patientId = patientId;
        this.hospitalDoctorId = hospitalDoctorId;
        this.comments = comments;
        this.emitedAppointmentDate = emitedAppointmentDate;
        this.reason = reason;
        this.medicalAppointmentState = medicalAppointmentState;
        this.medicalAppointmentDate = medicalAppointmentDate;
        this.status = status;
    }

    public int getIdMedicalAppointment() {
        return idMedicalAppointment;
    }

    public void setIdMedicalAppointment(int idMedicalAppointment) {
        this.idMedicalAppointment = idMedicalAppointment;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getHospitalDoctorId() {
        return hospitalDoctorId;
    }

    public void setHospitalDoctorId(int hospitalDoctorId) {
        this.hospitalDoctorId = hospitalDoctorId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getEmitedAppointmentDate() {
        return emitedAppointmentDate;
    }

    public void setEmitedAppointmentDate(Date emitedAppointmentDate) {
        this.emitedAppointmentDate = emitedAppointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMedicalAppointmentState() {
        return medicalAppointmentState;
    }

    public void setMedicalAppointmentState(String medicalAppointmentState) {
        this.medicalAppointmentState = medicalAppointmentState;
    }

    public Date getMedicalAppointmentDate() {
        return medicalAppointmentDate;
    }

    public void setMedicalAppointmentDate(Date medicalAppointmentDate) {
        this.medicalAppointmentDate = medicalAppointmentDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

