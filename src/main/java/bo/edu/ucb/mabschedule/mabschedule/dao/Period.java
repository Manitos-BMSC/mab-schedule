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

    @ManyToOne
    @JoinColumn(name = "week_day_id")
    private WeekDay weekDay;

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

    public Period(int id, WeekDay weekDay, Time timeInit, Time timeEnd, int status, List<UnavailableSchedule> unavailableSchedules) {
        this.id = id;
        this.weekDay = weekDay;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
        this.unavailableSchedules = unavailableSchedules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
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
