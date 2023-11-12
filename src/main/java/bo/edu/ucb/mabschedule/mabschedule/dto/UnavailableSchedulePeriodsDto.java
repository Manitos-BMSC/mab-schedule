package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.List;

public class UnavailableSchedulePeriodsDto {

    private UnavailableScheduleDto unavailableSchedule;
    private List<PeriodDto> periods;

    public UnavailableSchedulePeriodsDto() {
    }

    public UnavailableSchedulePeriodsDto(UnavailableScheduleDto unavailableSchedule, List<PeriodDto> periods) {
        this.unavailableSchedule = unavailableSchedule;
        this.periods = periods;
    }

    public UnavailableScheduleDto getUnavailableSchedule() {
        return unavailableSchedule;
    }

    public void setUnavailableSchedule(UnavailableScheduleDto unavailableSchedule) {
        this.unavailableSchedule = unavailableSchedule;
    }

    public List<PeriodDto> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }
}
