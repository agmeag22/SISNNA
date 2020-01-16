/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "personal_info", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalInfo.findAll", query = "SELECT p FROM PersonalInfo p"),
    @NamedQuery(name = "PersonalInfo.findByIdPersonalInfo", query = "SELECT p FROM PersonalInfo p WHERE p.idPersonalInfo = :idPersonalInfo"),
    @NamedQuery(name = "PersonalInfo.findByName", query = "SELECT p FROM PersonalInfo p WHERE p.name = :name"),
    @NamedQuery(name = "PersonalInfo.findByBirthDate", query = "SELECT p FROM PersonalInfo p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "PersonalInfo.findByAddress", query = "SELECT p FROM PersonalInfo p WHERE p.address = :address"),
    @NamedQuery(name = "PersonalInfo.findByGuardianName", query = "SELECT p FROM PersonalInfo p WHERE p.guardianName = :guardianName"),
    @NamedQuery(name = "PersonalInfo.findByGuardianContact", query = "SELECT p FROM PersonalInfo p WHERE p.guardianContact = :guardianContact"),
    @NamedQuery(name = "PersonalInfo.findByCreatedDate", query = "SELECT p FROM PersonalInfo p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PersonalInfo.findByUpdatedDate", query = "SELECT p FROM PersonalInfo p WHERE p.updatedDate = :updatedDate")})
public class PersonalInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal_info")
    private Integer idPersonalInfo;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "guardian_name")
    private String guardianName;
    @Size(max = 255)
    @Column(name = "guardian_contact")
    private String guardianContact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department")
    @ManyToOne(fetch = FetchType.LAZY)
    private CountryDepartment countryDepartment;
    @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality")
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipality municipality;
    @JoinColumn(name = "id_gender", referencedColumnName = "id_gender")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gender gender;
    @OneToMany(mappedBy = "personalInfo", fetch = FetchType.LAZY)
    private List<User> userList;

    public PersonalInfo() {
    }

    public PersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public PersonalInfo(Integer idPersonalInfo, Date createdDate, Date updatedDate) {
        this.idPersonalInfo = idPersonalInfo;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdPersonalInfo() {
        return idPersonalInfo;
    }

    public void setIdPersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianContact() {
        return guardianContact;
    }

    public void setGuardianContact(String guardianContact) {
        this.guardianContact = guardianContact;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryDepartment getCountryDepartment() {
        return countryDepartment;
    }

    public void setCountryDepartment(CountryDepartment countryDepartment) {
        this.countryDepartment = countryDepartment;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalInfo != null ? idPersonalInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalInfo)) {
            return false;
        }
        PersonalInfo other = (PersonalInfo) object;
        if ((this.idPersonalInfo == null && other.idPersonalInfo != null) || (this.idPersonalInfo != null && !this.idPersonalInfo.equals(other.idPersonalInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.PersonalInfo[ idPersonalInfo=" + idPersonalInfo + " ]";
    }
    
}
