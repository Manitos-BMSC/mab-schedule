package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;
import java.util.List;

public class SchedulePeriodsDto {
    private Date scheduleDate;
    private List<PeriodDto> periods;

    public SchedulePeriodsDto() {
    }

    public SchedulePeriodsDto(Date scheduleDate, List<PeriodDto> periods) {
        this.scheduleDate = scheduleDate;
        this.periods = periods;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public List<PeriodDto> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }
}
