package bo.edu.ucb.mabschedule.mabschedule.dto;

import java.util.Date;

public class DoctorDto {

    private int id;
    private String personIdKeycloak;
    private int s3ObjectId;
    private String licenseCode;
    private Date licenseDueDate;
    private String licenseStatus;
    private String medicalSpeciality;
    private boolean status;

    public DoctorDto() {
    }

    public DoctorDto(int id, String personIdKeycloak, int s3ObjectId, String licenseCode, Date licenseDueDate, String licenseStatus, String medicalSpeciality, boolean status) {
        this.id = id;
        this.personIdKeycloak = personIdKeycloak;
        this.s3ObjectId = s3ObjectId;
        this.licenseCode = licenseCode;
        this.licenseDueDate = licenseDueDate;
        this.licenseStatus = licenseStatus;
        this.medicalSpeciality = medicalSpeciality;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonIdKeycloak() {
        return personIdKeycloak;
    }

    public void setPersonIdKeycloak(String personIdKeycloak) {
        this.personIdKeycloak = personIdKeycloak;
    }

    public int getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(int s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public Date getLicenseDueDate() {
        return licenseDueDate;
    }

    public void setLicenseDueDate(Date licenseDueDate) {
        this.licenseDueDate = licenseDueDate;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public String getMedicalSpeciality() {
        return medicalSpeciality;
    }

    public void setMedicalSpeciality(String medicalSpeciality) {
        this.medicalSpeciality = medicalSpeciality;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}