package bo.edu.ucb.mabschedule.mabschedule.dto;

import bo.edu.ucb.mabschedule.mabschedule.dao.Hospital;

public class HospitalDto {

    private Integer idHospital;
    private String name;
    private String direction;
    private String contactNumber;
    private boolean status;

    public HospitalDto() {
    }

    public HospitalDto(Integer idHospital, String name, String direction, String contactNumber, boolean status) {
        this.idHospital = idHospital;
        this.name = name;
        this.direction = direction;
        this.contactNumber = contactNumber;
        this.status = status;
    }

    public HospitalDto(Hospital hospital){
        this.idHospital = hospital.getIdHospital();
        this.name = hospital.getName();
        this.direction = hospital.getDirection();
        this.contactNumber = hospital.getContactNumber();
        this.status = hospital.getStatus();
    }

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

