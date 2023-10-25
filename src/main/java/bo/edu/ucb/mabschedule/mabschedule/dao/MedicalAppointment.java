/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_medical_appointment")
@NamedQueries({
    @NamedQuery(name = "MedicalAppointment.findAll", query = "SELECT m FROM MedicalAppointment m"),
    @NamedQuery(name = "MedicalAppointment.findByIdMedicalAppointment", query = "SELECT m FROM MedicalAppointment m WHERE m.idMedicalAppointment = :idMedicalAppointment"),
    @NamedQuery(name = "MedicalAppointment.findByComments", query = "SELECT m FROM MedicalAppointment m WHERE m.comments = :comments"),
    @NamedQuery(name = "MedicalAppointment.findByEmitedAppointmentDate", query = "SELECT m FROM MedicalAppointment m WHERE m.emitedAppointmentDate = :emitedAppointmentDate"),
    @NamedQuery(name = "MedicalAppointment.findByReason", query = "SELECT m FROM MedicalAppointment m WHERE m.reason = :reason"),
    @NamedQuery(name = "MedicalAppointment.findByMedicalAppointmentState", query = "SELECT m FROM MedicalAppointment m WHERE m.medicalAppointmentState = :medicalAppointmentState"),
    @NamedQuery(name = "MedicalAppointment.findByMedicalAppointmentDate", query = "SELECT m FROM MedicalAppointment m WHERE m.medicalAppointmentDate = :medicalAppointmentDate"),
    @NamedQuery(name = "MedicalAppointment.findByStatus", query = "SELECT m FROM MedicalAppointment m WHERE m.status = :status")})
public class MedicalAppointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medical_appointment")
    private Integer idMedicalAppointment;
    @Basic(optional = false)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @Column(name = "emited_appointment_date")
    @Temporal(TemporalType.DATE)
    private Date emitedAppointmentDate;
    @Basic(optional = false)
    @Column(name = "reason")
    private String reason;
    @Basic(optional = false)
    @Column(name = "medical_appointment_state")
    private String medicalAppointmentState;
    @Basic(optional = false)
    @Column(name = "medical_appointment_date")
    @Temporal(TemporalType.DATE)
    private Date medicalAppointmentDate;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalAppointmentId", fetch = FetchType.LAZY)
    private Collection<FilesMedialAppointment> filesMedialAppointmentCollection;
    @JoinColumn(name = "hospital_doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HospitalDoctor hospitalDoctorId;
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacient pacientId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalAppointmentId", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public MedicalAppointment() {
    }

    public MedicalAppointment(Integer idMedicalAppointment) {
        this.idMedicalAppointment = idMedicalAppointment;
    }

    public MedicalAppointment(Integer idMedicalAppointment, String comments, Date emitedAppointmentDate, String reason, String medicalAppointmentState, Date medicalAppointmentDate, boolean status) {
        this.idMedicalAppointment = idMedicalAppointment;
        this.comments = comments;
        this.emitedAppointmentDate = emitedAppointmentDate;
        this.reason = reason;
        this.medicalAppointmentState = medicalAppointmentState;
        this.medicalAppointmentDate = medicalAppointmentDate;
        this.status = status;
    }

    public Integer getIdMedicalAppointment() {
        return idMedicalAppointment;
    }

    public void setIdMedicalAppointment(Integer idMedicalAppointment) {
        this.idMedicalAppointment = idMedicalAppointment;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<FilesMedialAppointment> getFilesMedialAppointmentCollection() {
        return filesMedialAppointmentCollection;
    }

    public void setFilesMedialAppointmentCollection(Collection<FilesMedialAppointment> filesMedialAppointmentCollection) {
        this.filesMedialAppointmentCollection = filesMedialAppointmentCollection;
    }

    public HospitalDoctor getHospitalDoctorId() {
        return hospitalDoctorId;
    }

    public void setHospitalDoctorId(HospitalDoctor hospitalDoctorId) {
        this.hospitalDoctorId = hospitalDoctorId;
    }

    public Pacient getPacientId() {
        return pacientId;
    }

    public void setPacientId(Pacient pacientId) {
        this.pacientId = pacientId;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicalAppointment != null ? idMedicalAppointment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalAppointment)) {
            return false;
        }
        MedicalAppointment other = (MedicalAppointment) object;
        if ((this.idMedicalAppointment == null && other.idMedicalAppointment != null) || (this.idMedicalAppointment != null && !this.idMedicalAppointment.equals(other.idMedicalAppointment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.MedicalAppointment[ idMedicalAppointment=" + idMedicalAppointment + " ]";
    }
    
}
