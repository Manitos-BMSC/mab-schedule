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
@Table(name = "s3_object")
@NamedQueries({
    @NamedQuery(name = "S3Object.findAll", query = "SELECT s FROM S3Object s"),
    @NamedQuery(name = "S3Object.findByS3ObjectId", query = "SELECT s FROM S3Object s WHERE s.s3ObjectId = :s3ObjectId"),
    @NamedQuery(name = "S3Object.findByContentType", query = "SELECT s FROM S3Object s WHERE s.contentType = :contentType"),
    @NamedQuery(name = "S3Object.findByBucket", query = "SELECT s FROM S3Object s WHERE s.bucket = :bucket"),
    @NamedQuery(name = "S3Object.findByFilename", query = "SELECT s FROM S3Object s WHERE s.filename = :filename"),
    @NamedQuery(name = "S3Object.findByStatus", query = "SELECT s FROM S3Object s WHERE s.status = :status")})
public class S3Object implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s3_object_id")
    private Integer s3ObjectId;
    @Basic(optional = false)
    @Column(name = "content_type")
    private String contentType;
    @Basic(optional = false)
    @Column(name = "bucket")
    private String bucket;
    @Basic(optional = false)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "s3ObjectS3ObjectId", fetch = FetchType.LAZY)
    private Collection<FilesMedialAppointment> filesMedialAppointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "s3ObjectId", fetch = FetchType.LAZY)
    private Collection<FilesPacient> filesPacientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "s3ObjectId", fetch = FetchType.LAZY)
    private Collection<Doctor> doctorCollection;

    public S3Object() {
    }

    public S3Object(Integer s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public S3Object(Integer s3ObjectId, String contentType, String bucket, String filename, boolean status) {
        this.s3ObjectId = s3ObjectId;
        this.contentType = contentType;
        this.bucket = bucket;
        this.filename = filename;
        this.status = status;
    }

    public Integer getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(Integer s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<FilesMedialAppointment> getFilesMedialAppointmentCollection() {
        return filesMedialAppointmentCollection;
    }

    public void setFilesMedialAppointmentCollection(Collection<FilesMedialAppointment> filesMedialAppointmentCollection) {
        this.filesMedialAppointmentCollection = filesMedialAppointmentCollection;
    }

    public Collection<FilesPacient> getFilesPacientCollection() {
        return filesPacientCollection;
    }

    public void setFilesPacientCollection(Collection<FilesPacient> filesPacientCollection) {
        this.filesPacientCollection = filesPacientCollection;
    }

    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (s3ObjectId != null ? s3ObjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof S3Object)) {
            return false;
        }
        S3Object other = (S3Object) object;
        if ((this.s3ObjectId == null && other.s3ObjectId != null) || (this.s3ObjectId != null && !this.s3ObjectId.equals(other.s3ObjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.S3Object[ s3ObjectId=" + s3ObjectId + " ]";
    }
    
}
