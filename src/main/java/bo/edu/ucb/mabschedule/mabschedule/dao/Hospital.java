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
@Table(name = "mab_hospital")
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h"),
    @NamedQuery(name = "Hospital.findByIdHospital", query = "SELECT h FROM Hospital h WHERE h.idHospital = :idHospital"),
    @NamedQuery(name = "Hospital.findByName", query = "SELECT h FROM Hospital h WHERE h.name = :name"),
    @NamedQuery(name = "Hospital.findByDirection", query = "SELECT h FROM Hospital h WHERE h.direction = :direction"),
    @NamedQuery(name = "Hospital.findByContactNumber", query = "SELECT h FROM Hospital h WHERE h.contactNumber = :contactNumber"),
    @NamedQuery(name = "Hospital.findByStatus", query = "SELECT h FROM Hospital h WHERE h.status = :status")})
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hospital")
    private Integer idHospital;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "direction")
    private String direction;
    @Basic(optional = false)
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId", fetch = FetchType.LAZY)
    private Collection<HospitalDoctor> hospitalDoctorCollection;

    public Hospital() {
    }

    public Hospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public Hospital(Integer idHospital, String name, String direction, String contactNumber, boolean status) {
        this.idHospital = idHospital;
        this.name = name;
        this.direction = direction;
        this.contactNumber = contactNumber;
        this.status = status;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<HospitalDoctor> getHospitalDoctorCollection() {
        return hospitalDoctorCollection;
    }

    public void setHospitalDoctorCollection(Collection<HospitalDoctor> hospitalDoctorCollection) {
        this.hospitalDoctorCollection = hospitalDoctorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospital != null ? idHospital.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.idHospital == null && other.idHospital != null) || (this.idHospital != null && !this.idHospital.equals(other.idHospital))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Hospital[ idHospital=" + idHospital + " ]";
    }
    
}
