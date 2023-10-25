package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;

public class UnavailableScheduleDto {

    private int id;
    private DoctorDto doctor;
    private PeriodDto period;
    private Date dateFrom;
    private Date dateTo;
    private boolean status;

    public UnavailableScheduleDto() {
    }

    public UnavailableScheduleDto(int id, DoctorDto doctor, PeriodDto period, Date dateFrom, Date dateTo, boolean status) {
        this.id = id;
        this.doctor = doctor;
        this.period = period;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.status = status;
    }

    public UnavailableScheduleDto(PeriodDto period, Date dateFrom, Date dateTo, boolean status) {
        this.period = period;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.status = status;
    }

    public UnavailableScheduleDto(Date dateFrom, Date dateTo, boolean status) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public PeriodDto getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDto period) {
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
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
