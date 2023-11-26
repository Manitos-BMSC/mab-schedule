package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.List;

public class MedicalAppointmentPlaceTimeDto {

    private MedicalAppointmentDto medicalAppointment;
    private HospitalDto hospital;
    private List<PeriodDto> periods;

    public MedicalAppointmentPlaceTimeDto() {
    }

    public MedicalAppointmentPlaceTimeDto(MedicalAppointmentDto medicalAppointment, HospitalDto hospital, List<PeriodDto> periods) {
        this.medicalAppointment = medicalAppointment;
        this.hospital = hospital;
        this.periods = periods;
    }

    public MedicalAppointmentDto getMedicalAppointment() {
        return medicalAppointment;
    }

    public void setMedicalAppointment(MedicalAppointmentDto medicalAppointment) {
        this.medicalAppointment = medicalAppointment;
    }

    public HospitalDto getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDto hospital) {
        this.hospital = hospital;
    }

    public List<PeriodDto> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }
}
