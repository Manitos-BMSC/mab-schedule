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
@Table(name = "mab_request")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id"),
    @NamedQuery(name = "Request.findByRequestState", query = "SELECT r FROM Request r WHERE r.requestState = :requestState"),
    @NamedQuery(name = "Request.findByRequestDate", query = "SELECT r FROM Request r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = "Request.findByConsentInformed", query = "SELECT r FROM Request r WHERE r.consentInformed = :consentInformed"),
    @NamedQuery(name = "Request.findByRequestResponse", query = "SELECT r FROM Request r WHERE r.requestResponse = :requestResponse"),
    @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "request_state")
    private String requestState;
    @Basic(optional = false)
    @Column(name = "request_date")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Basic(optional = false)
    @Column(name = "consent_informed")
    private String consentInformed;
    @Column(name = "request_response")
    private String requestResponse;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabRequestId", fetch = FetchType.LAZY)
    private Collection<RequestDoctor> requestDoctorCollection;
    @JoinColumn(name = "cycle_id", referencedColumnName = "cycle_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cycle cycleId;
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacient pacientId;

    public Request() {
    }

    public Request(Integer id) {
        this.id = id;
    }

    public Request(Integer id, String requestState, Date requestDate, String consentInformed, boolean status) {
        this.id = id;
        this.requestState = requestState;
        this.requestDate = requestDate;
        this.consentInformed = consentInformed;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestState() {
        return requestState;
    }

    public void setRequestState(String requestState) {
        this.requestState = requestState;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getConsentInformed() {
        return consentInformed;
    }

    public void setConsentInformed(String consentInformed) {
        this.consentInformed = consentInformed;
    }

    public String getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(String requestResponse) {
        this.requestResponse = requestResponse;
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

    public Cycle getCycleId() {
        return cycleId;
    }

    public void setCycleId(Cycle cycleId) {
        this.cycleId = cycleId;
    }

    public Pacient getPacientId() {
        return pacientId;
    }

    public void setPacientId(Pacient pacientId) {
        this.pacientId = pacientId;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Request[ id=" + id + " ]";
    }
    
}
