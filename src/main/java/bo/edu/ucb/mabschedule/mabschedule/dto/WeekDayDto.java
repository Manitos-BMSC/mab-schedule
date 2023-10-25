package bo.edu.ucb.mabschedule.mabschedule.dto;

import bo.edu.ucb.mabschedule.mabschedule.dao.WeekDay;

public class WeekDayDto {
    private int id;
    private String name;

    public WeekDayDto() {
    }

    public WeekDayDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static WeekDayDto fromEntity(WeekDay weekDay){
        return new WeekDayDto(weekDay.getId(), weekDay.getWeekDayName());
    }
}
