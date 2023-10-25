/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_hospital_doctor")
@NamedQueries({
    @NamedQuery(name = "HospitalDoctor.findAll", query = "SELECT h FROM HospitalDoctor h"),
    @NamedQuery(name = "HospitalDoctor.findById", query = "SELECT h FROM HospitalDoctor h WHERE h.id = :id")})
public class HospitalDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor doctorId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id_hospital")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hospital hospitalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalDoctorId", fetch = FetchType.LAZY)
    private Collection<MedicalAppointment> medicalAppointmentCollection;

    public HospitalDoctor() {
    }

    public HospitalDoctor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Collection<MedicalAppointment> getMedicalAppointmentCollection() {
        return medicalAppointmentCollection;
    }

    public void setMedicalAppointmentCollection(Collection<MedicalAppointment> medicalAppointmentCollection) {
        this.medicalAppointmentCollection = medicalAppointmentCollection;
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
        if (!(object instanceof HospitalDoctor)) {
            return false;
        }
        HospitalDoctor other = (HospitalDoctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.HospitalDoctor[ id=" + id + " ]";
    }
    
}
