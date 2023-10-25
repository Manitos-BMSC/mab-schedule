package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;

public class ScheduleDto {
    private int id;
    private DoctorDto doctor;
    private MedicalAppointmentDto medicalAppointment;
    private PeriodDto period;
    private String state;
    private Date scheduleDate;
    private boolean status;

    public ScheduleDto() {
    }

    public ScheduleDto(int id, PeriodDto period, MedicalAppointmentDto medicalAppointment, DoctorDto doctor, String state, Date scheduleDate, boolean status) {
        this.id = id;
        this.period = period;
        this.medicalAppointment = medicalAppointment;
        this.doctor = doctor;
        this.state = state;
        this.scheduleDate = scheduleDate;
        this.status = status;
    }

    public ScheduleDto(String state, Date scheduleDate, boolean status) {
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

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public MedicalAppointmentDto getMedicalAppointment() {
        return medicalAppointment;
    }

    public void setMedicalAppointment(MedicalAppointmentDto medicalAppointment) {
        this.medicalAppointment = medicalAppointment;
    }

    public PeriodDto getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDto period) {
        this.period = period;
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
