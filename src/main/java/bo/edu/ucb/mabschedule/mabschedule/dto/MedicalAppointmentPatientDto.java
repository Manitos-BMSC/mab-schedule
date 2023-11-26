package bo.edu.ucb.mabschedule.mabschedule.dto;

public class MedicalAppointmentPatientDto {

    private MedicalAppointmentDto medicalAppointment;
    private PersonDto patient;

    public MedicalAppointmentPatientDto() {
    }

    public MedicalAppointmentPatientDto(MedicalAppointmentDto medicalAppointment, PersonDto patient) {
        this.medicalAppointment = medicalAppointment;
        this.patient = patient;
    }

    public MedicalAppointmentDto getMedicalAppointment() {
        return medicalAppointment;
    }

    public void setMedicalAppointment(MedicalAppointmentDto medicalAppointment) {
        this.medicalAppointment = medicalAppointment;
    }

    public PersonDto getPatient() {
        return patient;
    }

    public void setPatient(PersonDto patient) {
        this.patient = patient;
    }

    public static MedicalAppointmentPatientDto fromMedicalAppointmentDto(MedicalAppointmentDto medicalAppointment, PersonDto patient) {
        MedicalAppointmentPatientDto medicalAppointmentPatientDto = new MedicalAppointmentPatientDto();
        medicalAppointmentPatientDto.setMedicalAppointment(medicalAppointment);
        medicalAppointmentPatientDto.setPatient(patient);
        return medicalAppointmentPatientDto;
    }
}
