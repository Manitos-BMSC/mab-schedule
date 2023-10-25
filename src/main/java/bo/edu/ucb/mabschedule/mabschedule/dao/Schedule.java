package bo.edu.ucb.mabschedule.mabschedule.dao;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAB_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;

    @Column(name = "medical_appointment_id")
    private int medicalAppointmentId;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "state")
    private String state;

    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Column(name = "status")
    private boolean status;

    public Schedule() {
    }

    public Schedule(int id, Period period, int medicalAppointmentId, int doctorId, String state, Date scheduleDate, boolean status) {
        this.id = id;
        this.period = period;
        this.medicalAppointmentId = medicalAppointmentId;
        this.doctorId = doctorId;
        this.state = state;
        this.scheduleDate = scheduleDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public int getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public void setMedicalAppointmentId(int medicalAppointmentId) {
        this.medicalAppointmentId = medicalAppointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}