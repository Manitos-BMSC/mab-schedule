package bo.edu.ucb.mabschedule.mabschedule.dao;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MAB_unavailable_schedule")
public class UnavailableSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "period_id")
    private Period period;
    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "week_day")
    private String weekDay;

    @Column(name = "status")
    private boolean status;


    public UnavailableSchedule() {
    }

    public UnavailableSchedule(int id, Doctor doctor, Period period, Date dateFrom, Date dateTo, String weekDay, boolean status) {
        this.id = id;
        this.doctor = doctor;
        this.period = period;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.weekDay = weekDay;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
