package bo.edu.ucb.mabschedule.mabschedule.dto;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

public class PeriodDto {
    private int id;

    private int weekDayId;
    private Time timeInit;
    private Time timeEnd;
    private int status;

    public PeriodDto() {
    }

    public PeriodDto(int id, int weekDayId, Time timeInit, Time timeEnd, int status) {
        this.id = id;
        this.weekDayId = weekDayId;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
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

    public static PeriodDto fromEntity(Period period){
        return new PeriodDto(
                period.getId(),
                period.getWeekDayId(),
                period.getTimeInit(),
                period.getTimeEnd(),
                period.getStatus()
        );
    }

    public static List<PeriodDto> fromEntityList(List<Period> periodList){
        return periodList.stream().map(PeriodDto::fromEntity).collect(Collectors.toList());
    }
}
