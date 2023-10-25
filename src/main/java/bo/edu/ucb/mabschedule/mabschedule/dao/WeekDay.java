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
@Table(name = "mab_week_day")
@NamedQueries({
    @NamedQuery(name = "WeekDay.findAll", query = "SELECT w FROM WeekDay w"),
    @NamedQuery(name = "WeekDay.findById", query = "SELECT w FROM WeekDay w WHERE w.id = :id"),
    @NamedQuery(name = "WeekDay.findByWeekDayName", query = "SELECT w FROM WeekDay w WHERE w.weekDayName = :weekDayName")})
public class WeekDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "week_day_name")
    private String weekDayName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabWeekDayId", fetch = FetchType.LAZY)
    private Collection<Period> periodCollection;

    public WeekDay() {
    }

    public WeekDay(Integer id) {
        this.id = id;
    }

    public WeekDay(Integer id, String weekDayName) {
        this.id = id;
        this.weekDayName = weekDayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeekDayName() {
        return weekDayName;
    }

    public void setWeekDayName(String weekDayName) {
        this.weekDayName = weekDayName;
    }

    public Collection<Period> getPeriodCollection() {
        return periodCollection;
    }

    public void setPeriodCollection(Collection<Period> periodCollection) {
        this.periodCollection = periodCollection;
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
        if (!(object instanceof WeekDay)) {
            return false;
        }
        WeekDay other = (WeekDay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
