package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.List;

public class ScheduleDoctorDto {

    private Integer idDoctor;
    private List<PeriodDto> unavailableSchedules;
    private List<PeriodDto> appointments;

    public ScheduleDoctorDto() {
    }

    public ScheduleDoctorDto(Integer idDoctor, List<PeriodDto> unavailableSchedules, List<PeriodDto> appointments) {
        this.idDoctor = idDoctor;
        this.unavailableSchedules = unavailableSchedules;
        this.appointments = appointments;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public List<PeriodDto> getUnavailableSchedules() {
        return unavailableSchedules;
    }

    public void setUnavailableSchedules(List<PeriodDto> unavailableSchedules) {
        this.unavailableSchedules = unavailableSchedules;
    }

    public List<PeriodDto> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<PeriodDto> appointments) {
        this.appointments = appointments;
    }
}
