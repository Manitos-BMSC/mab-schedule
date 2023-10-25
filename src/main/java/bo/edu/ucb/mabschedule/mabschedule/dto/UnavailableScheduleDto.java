package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;

public class UnavailableScheduleDto {

    private int id;
    private int doctorId;
    private int periodId;
    private Date dateFrom;
    private Date dateTo;
    private String weekDay;
    private boolean status;

    public UnavailableScheduleDto() {
    }

    public UnavailableScheduleDto(int id, int doctorId, int periodId, Date dateFrom, Date dateTo, String weekDay, boolean status) {
        this.id = id;
        this.doctorId = doctorId;
        this.periodId = periodId;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
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
