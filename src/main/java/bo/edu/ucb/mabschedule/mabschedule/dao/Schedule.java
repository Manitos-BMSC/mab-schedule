/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_schedule")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id"),
    @NamedQuery(name = "Schedule.findByState", query = "SELECT s FROM Schedule s WHERE s.state = :state"),
    @NamedQuery(name = "Schedule.findByScheduleDate", query = "SELECT s FROM Schedule s WHERE s.scheduleDate = :scheduleDate"),
    @NamedQuery(name = "Schedule.findByStatus", query = "SELECT s FROM Schedule s WHERE s.status = :status")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "schedule_date")
    @Temporal(TemporalType.DATE)
    private Date scheduleDate;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor doctorId;
    @JoinColumn(name = "medical_appointment_id", referencedColumnName = "id_medical_appointment")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalAppointment medicalAppointmentId;
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Period periodId;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, String state, Date scheduleDate, boolean status) {
        this.id = id;
        this.state = state;
        this.scheduleDate = scheduleDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public MedicalAppointment getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public void setMedicalAppointmentId(MedicalAppointment medicalAppointmentId) {
        this.medicalAppointmentId = medicalAppointmentId;
    }

    public Period getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Period periodId) {
        this.periodId = periodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Schedule[ id=" + id + " ]";
    }
    
}
