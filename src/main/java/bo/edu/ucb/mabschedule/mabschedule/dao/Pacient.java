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
@Table(name = "mab_pacient")
@NamedQueries({
    @NamedQuery(name = "Pacient.findAll", query = "SELECT p FROM Pacient p"),
    @NamedQuery(name = "Pacient.findById", query = "SELECT p FROM Pacient p WHERE p.id = :id"),
    @NamedQuery(name = "Pacient.findByEmergencyPhone", query = "SELECT p FROM Pacient p WHERE p.emergencyPhone = :emergencyPhone"),
    @NamedQuery(name = "Pacient.findByPacientStatus", query = "SELECT p FROM Pacient p WHERE p.pacientStatus = :pacientStatus"),
    @NamedQuery(name = "Pacient.findByStatus", query = "SELECT p FROM Pacient p WHERE p.status = :status")})
public class Pacient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "emergency_phone")
    private String emergencyPhone;
    @Basic(optional = false)
    @Column(name = "pacient_status")
    private String pacientStatus;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientId", fetch = FetchType.LAZY)
    private Collection<FilesPacient> filesPacientCollection;
    @JoinColumn(name = "mab_person_id_keycloack", referencedColumnName = "id_keycloack")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person mabPersonIdKeycloack;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientId", fetch = FetchType.LAZY)
    private Collection<MedicalAppointment> medicalAppointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientId", fetch = FetchType.LAZY)
    private Collection<Request> requestCollection;

    public Pacient() {
    }

    public Pacient(Integer id) {
        this.id = id;
    }

    public Pacient(Integer id, String emergencyPhone, String pacientStatus, boolean status) {
        this.id = id;
        this.emergencyPhone = emergencyPhone;
        this.pacientStatus = pacientStatus;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getPacientStatus() {
        return pacientStatus;
    }

    public void setPacientStatus(String pacientStatus) {
        this.pacientStatus = pacientStatus;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<FilesPacient> getFilesPacientCollection() {
        return filesPacientCollection;
    }

    public void setFilesPacientCollection(Collection<FilesPacient> filesPacientCollection) {
        this.filesPacientCollection = filesPacientCollection;
    }

    public Person getMabPersonIdKeycloack() {
        return mabPersonIdKeycloack;
    }

    public void setMabPersonIdKeycloack(Person mabPersonIdKeycloack) {
        this.mabPersonIdKeycloack = mabPersonIdKeycloack;
    }

    public Collection<MedicalAppointment> getMedicalAppointmentCollection() {
        return medicalAppointmentCollection;
    }

    public void setMedicalAppointmentCollection(Collection<MedicalAppointment> medicalAppointmentCollection) {
        this.medicalAppointmentCollection = medicalAppointmentCollection;
    }

    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
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
        if (!(object instanceof Pacient)) {
            return false;
        }
        Pacient other = (Pacient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Pacient[ id=" + id + " ]";
    }
    
}
