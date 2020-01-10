/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "personal_info")
@NamedQueries({
    @NamedQuery(name = "PersonalInfo.findAll", query = "SELECT p FROM PersonalInfo p"),
    @NamedQuery(name = "PersonalInfo.findByIdPersonalInfo", query = "SELECT p FROM PersonalInfo p WHERE p.idPersonalInfo = :idPersonalInfo"),
    @NamedQuery(name = "PersonalInfo.findByIdGender", query = "SELECT p FROM PersonalInfo p WHERE p.idGender = :idGender"),
    @NamedQuery(name = "PersonalInfo.findByName", query = "SELECT p FROM PersonalInfo p WHERE p.name = :name"),
    @NamedQuery(name = "PersonalInfo.findByBirthDate", query = "SELECT p FROM PersonalInfo p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "PersonalInfo.findByAddress", query = "SELECT p FROM PersonalInfo p WHERE p.address = :address"),
    @NamedQuery(name = "PersonalInfo.findByGuardianName", query = "SELECT p FROM PersonalInfo p WHERE p.guardianName = :guardianName"),
    @NamedQuery(name = "PersonalInfo.findByGuardianContact", query = "SELECT p FROM PersonalInfo p WHERE p.guardianContact = :guardianContact"),
    @NamedQuery(name = "PersonalInfo.findByCreatedDate", query = "SELECT p FROM PersonalInfo p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "PersonalInfo.findByUpdateDate", query = "SELECT p FROM PersonalInfo p WHERE p.updateDate = :updateDate")})
public class PersonalInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal_info")
    private Integer idPersonalInfo;
    @Size(max = 255)
    @Column(name = "id_gender")
    private String idGender;
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
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumns({
        @JoinColumn(name = "id_country", referencedColumnName = "id_country"),
        @JoinColumn(name = "id_country", referencedColumnName = "id_country")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @JoinColumns({
        @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department"),
        @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department")})
    @ManyToOne(fetch = FetchType.LAZY)
    private CountryDepartment countryDepartment;
    @JoinColumns({
        @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality"),
        @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipality municipality;
    @OneToMany(mappedBy = "personalInfo", fetch = FetchType.LAZY)
    private Set<User> userSet;

    public PersonalInfo() {
    }

    public PersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public Integer getIdPersonalInfo() {
        return idPersonalInfo;
    }

    public void setIdPersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public String getIdGender() {
        return idGender;
    }

    public void setIdGender(String idGender) {
        this.idGender = idGender;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
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
