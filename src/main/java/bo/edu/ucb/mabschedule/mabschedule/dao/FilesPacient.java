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
@Table(name = "files_pacient")
@NamedQueries({
    @NamedQuery(name = "FilesPacient.findAll", query = "SELECT f FROM FilesPacient f"),
    @NamedQuery(name = "FilesPacient.findById", query = "SELECT f FROM FilesPacient f WHERE f.id = :id"),
    @NamedQuery(name = "FilesPacient.findByFileDate", query = "SELECT f FROM FilesPacient f WHERE f.fileDate = :fileDate"),
    @NamedQuery(name = "FilesPacient.findByStatus", query = "SELECT f FROM FilesPacient f WHERE f.status = :status")})
public class FilesPacient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "file_date")
    @Temporal(TemporalType.DATE)
    private Date fileDate;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "pacient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacient pacientId;
    @JoinColumn(name = "s3_object_id", referencedColumnName = "s3_object_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private S3Object s3ObjectId;

    public FilesPacient() {
    }

    public FilesPacient(Integer id) {
        this.id = id;
    }

    public FilesPacient(Integer id, Date fileDate, boolean status) {
        this.id = id;
        this.fileDate = fileDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Pacient getPacientId() {
        return pacientId;
    }

    public void setPacientId(Pacient pacientId) {
        this.pacientId = pacientId;
    }

    public S3Object getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(S3Object s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
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
        if (!(object instanceof FilesPacient)) {
            return false;
        }
        FilesPacient other = (FilesPacient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.FilesPacient[ id=" + id + " ]";
    }
    
}
