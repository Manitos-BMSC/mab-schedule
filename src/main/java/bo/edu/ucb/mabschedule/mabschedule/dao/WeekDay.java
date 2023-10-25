package bo.edu.ucb.mabschedule.mabschedule.dao;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "MAB_week_day")
public class WeekDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "week_day_name")
    private String weekDayName;

    public WeekDay() {
    }

    public WeekDay(int id, String weekDayName) {
        this.id = id;
        this.weekDayName = weekDayName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeekDayName() {
        return weekDayName;
    }

    public void setWeekDayName(String weekDayName) {
        this.weekDayName = weekDayName;
    }
}

