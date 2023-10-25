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
@Table(name = "mab_cycle")
@NamedQueries({
    @NamedQuery(name = "Cycle.findAll", query = "SELECT c FROM Cycle c"),
    @NamedQuery(name = "Cycle.findByCycleId", query = "SELECT c FROM Cycle c WHERE c.cycleId = :cycleId"),
    @NamedQuery(name = "Cycle.findByCycleYear", query = "SELECT c FROM Cycle c WHERE c.cycleYear = :cycleYear"),
    @NamedQuery(name = "Cycle.findByMaxPacients", query = "SELECT c FROM Cycle c WHERE c.maxPacients = :maxPacients"),
    @NamedQuery(name = "Cycle.findByMaxDoctors", query = "SELECT c FROM Cycle c WHERE c.maxDoctors = :maxDoctors"),
    @NamedQuery(name = "Cycle.findByDateEndRegistry", query = "SELECT c FROM Cycle c WHERE c.dateEndRegistry = :dateEndRegistry"),
    @NamedQuery(name = "Cycle.findByState", query = "SELECT c FROM Cycle c WHERE c.state = :state"),
    @NamedQuery(name = "Cycle.findByStatus", query = "SELECT c FROM Cycle c WHERE c.status = :status")})
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cycle_id")
    private Integer cycleId;
    @Basic(optional = false)
    @Column(name = "cycle_year")
    private int cycleYear;
    @Basic(optional = false)
    @Column(name = "max_pacients")
    private int maxPacients;
    @Basic(optional = false)
    @Column(name = "max_doctors")
    private int maxDoctors;
    @Basic(optional = false)
    @Column(name = "date_end_registry")
    @Temporal(TemporalType.DATE)
    private Date dateEndRegistry;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycleId", fetch = FetchType.LAZY)
    private Collection<Request> requestCollection;

    public Cycle() {
    }

    public Cycle(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public Cycle(Integer cycleId, int cycleYear, int maxPacients, int maxDoctors, Date dateEndRegistry, String state, int status) {
        this.cycleId = cycleId;
        this.cycleYear = cycleYear;
        this.maxPacients = maxPacients;
        this.maxDoctors = maxDoctors;
        this.dateEndRegistry = dateEndRegistry;
        this.state = state;
        this.status = status;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public int getCycleYear() {
        return cycleYear;
    }

    public void setCycleYear(int cycleYear) {
        this.cycleYear = cycleYear;
    }

    public int getMaxPacients() {
        return maxPacients;
    }

    public void setMaxPacients(int maxPacients) {
        this.maxPacients = maxPacients;
    }

    public int getMaxDoctors() {
        return maxDoctors;
    }

    public void setMaxDoctors(int maxDoctors) {
        this.maxDoctors = maxDoctors;
    }

    public Date getDateEndRegistry() {
        return dateEndRegistry;
    }

    public void setDateEndRegistry(Date dateEndRegistry) {
        this.dateEndRegistry = dateEndRegistry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        hash += (cycleId != null ? cycleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cycle)) {
            return false;
        }
        Cycle other = (Cycle) object;
        if ((this.cycleId == null && other.cycleId != null) || (this.cycleId != null && !this.cycleId.equals(other.cycleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Cycle[ cycleId=" + cycleId + " ]";
    }
    
}
