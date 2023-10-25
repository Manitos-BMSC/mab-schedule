package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;

public class ScheduleDto {
    private int id;
    private int periodId;
    private int medicalAppointmentId;
    private int doctorId;
    private String state;
    private Date scheduleDate;
    private boolean status;

    public ScheduleDto() {
    }

    public ScheduleDto(int id, int periodId, int medicalAppointmentId, int doctorId, String state, Date scheduleDate, boolean status) {
        this.id = id;
        this.periodId = periodId;
        this.medicalAppointmentId = medicalAppointmentId;
        this.doctorId = doctorId;
        this.state = state;
        this.scheduleDate = scheduleDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public int getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public void setMedicalAppointmentId(int medicalAppointmentId) {
        this.medicalAppointmentId = medicalAppointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
