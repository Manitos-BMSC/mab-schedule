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
@Table(name = "mab_person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdKeycloack", query = "SELECT p FROM Person p WHERE p.idKeycloack = :idKeycloack"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Person.findByUserMail", query = "SELECT p FROM Person p WHERE p.userMail = :userMail"),
    @NamedQuery(name = "Person.findByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
    @NamedQuery(name = "Person.findByPhoneNumber", query = "SELECT p FROM Person p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Person.findByDocumentType", query = "SELECT p FROM Person p WHERE p.documentType = :documentType"),
    @NamedQuery(name = "Person.findByDocumentNumber", query = "SELECT p FROM Person p WHERE p.documentNumber = :documentNumber"),
    @NamedQuery(name = "Person.findByBirthDate", query = "SELECT p FROM Person p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Person.findByAddress", query = "SELECT p FROM Person p WHERE p.address = :address"),
    @NamedQuery(name = "Person.findByPersonalDocument", query = "SELECT p FROM Person p WHERE p.personalDocument = :personalDocument"),
    @NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @NamedQuery(name = "Person.findByTxUser", query = "SELECT p FROM Person p WHERE p.txUser = :txUser"),
    @NamedQuery(name = "Person.findByTxHost", query = "SELECT p FROM Person p WHERE p.txHost = :txHost"),
    @NamedQuery(name = "Person.findByTxDate", query = "SELECT p FROM Person p WHERE p.txDate = :txDate"),
    @NamedQuery(name = "Person.findByStatus", query = "SELECT p FROM Person p WHERE p.status = :status")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_keycloack")
    private String idKeycloack;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "user_mail")
    private String userMail;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "document_type")
    private boolean documentType;
    @Basic(optional = false)
    @Column(name = "document_number")
    private String documentNumber;
    @Basic(optional = false)
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "personal_document")
    private String personalDocument;
    @Basic(optional = false)
    @Column(name = "gender")
    private boolean gender;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private String txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @Basic(optional = false)
    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date txDate;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabPersonIdKeycloack", fetch = FetchType.LAZY)
    private Collection<Doctor> doctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mabPersonIdKeycloack", fetch = FetchType.LAZY)
    private Collection<Pacient> pacientCollection;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private City cityId;

    public Person() {
    }

    public Person(String idKeycloack) {
        this.idKeycloack = idKeycloack;
    }

    public Person(String idKeycloack, String name, String lastname, String userMail, String username, String phoneNumber, boolean documentType, String documentNumber, Date birthDate, String address, String personalDocument, boolean gender, String txUser, String txHost, Date txDate, boolean status) {
        this.idKeycloack = idKeycloack;
        this.name = name;
        this.lastname = lastname;
        this.userMail = userMail;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.personalDocument = personalDocument;
        this.gender = gender;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.status = status;
    }

    public String getIdKeycloack() {
        return idKeycloack;
    }

    public void setIdKeycloack(String idKeycloack) {
        this.idKeycloack = idKeycloack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getDocumentType() {
        return documentType;
    }

    public void setDocumentType(boolean documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalDocument() {
        return personalDocument;
    }

    public void setPersonalDocument(String personalDocument) {
        this.personalDocument = personalDocument;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    public Collection<Pacient> getPacientCollection() {
        return pacientCollection;
    }

    public void setPacientCollection(Collection<Pacient> pacientCollection) {
        this.pacientCollection = pacientCollection;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKeycloack != null ? idKeycloack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idKeycloack == null && other.idKeycloack != null) || (this.idKeycloack != null && !this.idKeycloack.equals(other.idKeycloack))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.manitos_bmsc.dao.Person[ idKeycloack=" + idKeycloack + " ]";
    }
    
}
