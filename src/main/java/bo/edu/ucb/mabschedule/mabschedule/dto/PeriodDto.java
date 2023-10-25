package bo.edu.ucb.mabschedule.mabschedule.dto;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

public class PeriodDto {
    private int id;

    private WeekDayDto weekDay;
    private Time timeInit;
    private Time timeEnd;
    private int status;

    public PeriodDto() {
    }

    public PeriodDto(int id, WeekDayDto weekDay, Time timeInit, Time timeEnd, int status) {
        this.id = id;
        this.weekDay = weekDay;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WeekDayDto getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDayDto weekDay) {
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

    public static PeriodDto fromEntity(Period period) {
        PeriodDto result = new PeriodDto();
        result.setId(period.getId());
        result.setWeekDay(WeekDayDto.fromEntity(period.getWeekDay()));
        result.setTimeInit(period.getTimeInit());
        result.setTimeEnd(period.getTimeEnd());
        result.setStatus(period.getStatus());
        return result;
    }

    public static List<PeriodDto> fromEntityList(List<Period> periods) {
        return periods.stream().map(PeriodDto::fromEntity).collect(Collectors.toList());
    }
}