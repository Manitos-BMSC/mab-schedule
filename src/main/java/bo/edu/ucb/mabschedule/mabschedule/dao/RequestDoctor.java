/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_request_doctor")
@NamedQueries({
    @NamedQuery(name = "RequestDoctor.findAll", query = "SELECT r FROM RequestDoctor r"),
    @NamedQuery(name = "RequestDoctor.findById", query = "SELECT r FROM RequestDoctor r WHERE r.id = :id"),
    @NamedQuery(name = "RequestDoctor.findByDoctorType", query = "SELECT r FROM RequestDoctor r WHERE r.doctorType = :doctorType")})
public class RequestDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "doctor_type")
    private String doctorType;
    @JoinColumn(name = "mab_doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor mabDoctorId;
    @JoinColumn(name = "mab_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Request mabRequestId;

    public RequestDoctor() {
    }

    public RequestDoctor(Integer id) {
        this.id = id;
    }

    public RequestDoctor(Integer id, String doctorType) {
        this.id = id;
        this.doctorType = doctorType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public Doctor getMabDoctorId() {
        return mabDoctorId;
    }

    public void setMabDoctorId(Doctor mabDoctorId) {
        this.mabDoctorId = mabDoctorId;
    }

    public Request getMabRequestId() {
        return mabRequestId;
    }

    public void setMabRequestId(Request mabRequestId) {
        this.mabRequestId = mabRequestId;
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
        if (!(object instanceof RequestDoctor)) {
            return false;
        }
        RequestDoctor other = (RequestDoctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.RequestDoctor[ id=" + id + " ]";
    }
    
}
