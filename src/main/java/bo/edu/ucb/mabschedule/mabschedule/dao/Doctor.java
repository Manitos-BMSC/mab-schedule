/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_doctor")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findById", query = "SELECT d FROM Doctor d WHERE d.id = :id"),
    @NamedQuery(name = "Doctor.findByLicenseCode", query = "SELECT d FROM Doctor d WHERE d.licenseCode = :licenseCode"),
    @NamedQuery(name = "Doctor.findByLicenseDueDate", query = "SELECT d FROM Doctor d WHERE d.licenseDueDate = :licenseDueDate"),
    @NamedQuery(name = "Doctor.findByLicenseStatus", query = "SELECT d FROM Doctor d WHERE d.licenseStatus = :licenseStatus"),
    @NamedQuery(name = "Doctor.findByMedicalSpeciality", query = "SELECT d FROM Doctor d WHERE d.medicalSpeciality = :medicalSpeciality"),
    @NamedQuery(name = "Doctor.findByStatus", query = "SELECT d FROM Doctor d WHERE d.status = :status")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "license_code")
    private String licenseCode;
    @Basic(optional = false)
    @Column(name = "license_due_date")
    @Temporal(TemporalType.DATE)
    private Date licenseDueDate;
    @Basic(optional = false)
    @Column(name = "license_status")
    private String licenseStatus;
    @Basic(optional = false)
    @Column(name = "medical_speciality")
    private String medicalSpeciality;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabDoctorId", fetch = FetchType.LAZY)
    private Collection<RequestDoctor> requestDoctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private Collection<HospitalDoctor> hospitalDoctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private Collection<UnavailableSchedule> unavailableScheduleCollection;
    @JoinColumn(name = "mab_person_id_keycloack", referencedColumnName = "id_keycloack")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person mabPersonIdKeycloack;
    @JoinColumn(name = "s3_object_id", referencedColumnName = "s3_object_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private S3Object s3ObjectId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public Doctor() {
    }

    public Doctor(Integer id) {
        this.id = id;
    }

    public Doctor(Integer id, String licenseCode, Date licenseDueDate, String licenseStatus, String medicalSpeciality, boolean status) {
        this.id = id;
        this.licenseCode = licenseCode;
        this.licenseDueDate = licenseDueDate;
        this.licenseStatus = licenseStatus;
        this.medicalSpeciality = medicalSpeciality;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<RequestDoctor> getRequestDoctorCollection() {
        return requestDoctorCollection;
    }

    public void setRequestDoctorCollection(Collection<RequestDoctor> requestDoctorCollection) {
        this.requestDoctorCollection = requestDoctorCollection;
    }

    public Collection<HospitalDoctor> getHospitalDoctorCollection() {
        return hospitalDoctorCollection;
    }

    public void setHospitalDoctorCollection(Collection<HospitalDoctor> hospitalDoctorCollection) {
        this.hospitalDoctorCollection = hospitalDoctorCollection;
    }

    public Collection<UnavailableSchedule> getUnavailableScheduleCollection() {
        return unavailableScheduleCollection;
    }

    public void setUnavailableScheduleCollection(Collection<UnavailableSchedule> unavailableScheduleCollection) {
        this.unavailableScheduleCollection = unavailableScheduleCollection;
    }

    public Person getMabPersonIdKeycloack() {
        return mabPersonIdKeycloack;
    }

    public void setMabPersonIdKeycloack(Person mabPersonIdKeycloack) {
        this.mabPersonIdKeycloack = mabPersonIdKeycloack;
    }

    public S3Object getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(S3Object s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Doctor[ id=" + id + " ]";
    }
    
}
