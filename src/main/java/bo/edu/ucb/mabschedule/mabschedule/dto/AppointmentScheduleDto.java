package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.List;

public class AppointmentScheduleDto {
    private MedicalAppointmentDto medicalAppointment;
    private List<PeriodDto> periods;

    public AppointmentScheduleDto() {
    }
    public AppointmentScheduleDto(MedicalAppointmentDto medicalAppointment, List<PeriodDto> periods) {
        this.medicalAppointment = medicalAppointment;
        this.periods = periods;
    }

    public MedicalAppointmentDto getMedicalAppointment() {
        return medicalAppointment;
    }

    public void setMedicalAppointment(MedicalAppointmentDto medicalAppointment) {
        this.medicalAppointment = medicalAppointment;
    }

    public List<PeriodDto> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }
}

