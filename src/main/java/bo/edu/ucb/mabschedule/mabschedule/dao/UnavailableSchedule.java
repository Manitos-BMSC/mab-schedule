/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_unavailable_schedule")
@NamedQueries({
    @NamedQuery(name = "UnavailableSchedule.findAll", query = "SELECT u FROM UnavailableSchedule u"),
    @NamedQuery(name = "UnavailableSchedule.findById", query = "SELECT u FROM UnavailableSchedule u WHERE u.id = :id"),
    @NamedQuery(name = "UnavailableSchedule.findByDateFrom", query = "SELECT u FROM UnavailableSchedule u WHERE u.dateFrom = :dateFrom"),
    @NamedQuery(name = "UnavailableSchedule.findByDateTo", query = "SELECT u FROM UnavailableSchedule u WHERE u.dateTo = :dateTo"),
    @NamedQuery(name = "UnavailableSchedule.findByStatus", query = "SELECT u FROM UnavailableSchedule u WHERE u.status = :status")})
public class UnavailableSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Doctor doctorId;
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Period periodId;

    public UnavailableSchedule() {
    }

    public UnavailableSchedule(Integer id) {
        this.id = id;
    }

    public UnavailableSchedule(Integer id, Date dateFrom, boolean status) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Period getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Period periodId) {
        this.periodId = periodId;
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
        if (!(object instanceof UnavailableSchedule)) {
            return false;
        }
        UnavailableSchedule other = (UnavailableSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.UnavailableSchedule[ id=" + id + " ]";
    }
    
}
