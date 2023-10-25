package bo.edu.ucb.mabschedule.mabschedule.dao;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "MAB_period")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MAB_week_day_id")
    private int weekDayId;

    @Column(name = "time_init")
    private Time timeInit;

    @Column(name = "time_end")
    private Time timeEnd;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "period", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnavailableSchedule> unavailableSchedules;

    public Period() {
    }

    public Period(int id, int weekDayId, Time timeInit, Time timeEnd, int status, List<UnavailableSchedule> unavailableSchedules) {
        this.id = id;
        this.weekDayId = weekDayId;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
        this.unavailableSchedules = unavailableSchedules;
    }

    public int getWeekDayId() {
        return weekDayId;
    }

    public void setWeekDayId(int weekDayId) {
        this.weekDayId = weekDayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(Time timeInit) {
        this.timeInit = timeInit;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UnavailableSchedule> getUnavailableSchedules() {
        return unavailableSchedules;
    }

    public void setUnavailableSchedules(List<UnavailableSchedule> unavailableSchedules) {
        this.unavailableSchedules = unavailableSchedules;
    }
}
