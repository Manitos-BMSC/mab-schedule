/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.mabschedule.mabschedule.dao;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author PCHOME
 */
@Entity
@Table(name = "mab_period")
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p"),
    @NamedQuery(name = "Period.findById", query = "SELECT p FROM Period p WHERE p.id = :id"),
    @NamedQuery(name = "Period.findByTimeInit", query = "SELECT p FROM Period p WHERE p.timeInit = :timeInit"),
    @NamedQuery(name = "Period.findByTimeEnd", query = "SELECT p FROM Period p WHERE p.timeEnd = :timeEnd"),
    @NamedQuery(name = "Period.findByStatus", query = "SELECT p FROM Period p WHERE p.status = :status")})
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "time_init")
    @Temporal(TemporalType.TIME)
    private Time timeInit;
    @Basic(optional = false)
    @Column(name = "time_end")
    @Temporal(TemporalType.TIME)
    private Time timeEnd;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "mab_week_day_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private WeekDay mabWeekDayId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodId", fetch = FetchType.LAZY)
    private Collection<UnavailableSchedule> unavailableScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodId", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    public Period() {
    }

    public Period(Integer id) {
        this.id = id;
    }

    public Period(Integer id, Time timeInit, Time timeEnd, int status) {
        this.id = id;
        this.timeInit = timeInit;
        this.timeEnd = timeEnd;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(Time timeInit) {
        this.timeInit = timeInit;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public WeekDay getMabWeekDayId() {
        return mabWeekDayId;
    }

    public void setMabWeekDayId(WeekDay mabWeekDayId) {
        this.mabWeekDayId = mabWeekDayId;
    }

    public Collection<UnavailableSchedule> getUnavailableScheduleCollection() {
        return unavailableScheduleCollection;
    }

    public void setUnavailableScheduleCollection(Collection<UnavailableSchedule> unavailableScheduleCollection) {
        this.unavailableScheduleCollection = unavailableScheduleCollection;
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
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
