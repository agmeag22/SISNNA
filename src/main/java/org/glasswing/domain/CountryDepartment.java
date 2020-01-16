/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "country_department", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryDepartment.findAll", query = "SELECT c FROM CountryDepartment c"),
    @NamedQuery(name = "CountryDepartment.findByIdCountryDepartment", query = "SELECT c FROM CountryDepartment c WHERE c.idCountryDepartment = :idCountryDepartment"),
    @NamedQuery(name = "CountryDepartment.findByName", query = "SELECT c FROM CountryDepartment c WHERE c.name = :name")})
public class CountryDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_country_department")
    private Integer idCountryDepartment;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private List<Municipality> municipalityList;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private List<PersonalInfo> personalInfoList;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private List<Complaint> complaintList;

    public CountryDepartment() {
    }

    public CountryDepartment(Integer idCountryDepartment) {
        this.idCountryDepartment = idCountryDepartment;
    }

    public Integer getIdCountryDepartment() {
        return idCountryDepartment;
    }

    public void setIdCountryDepartment(Integer idCountryDepartment) {
        this.idCountryDepartment = idCountryDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @XmlTransient
    public List<Municipality> getMunicipalityList() {
        return municipalityList;
    }

    public void setMunicipalityList(List<Municipality> municipalityList) {
        this.municipalityList = municipalityList;
    }

    @XmlTransient
    public List<PersonalInfo> getPersonalInfoList() {
        return personalInfoList;
    }

    public void setPersonalInfoList(List<PersonalInfo> personalInfoList) {
        this.personalInfoList = personalInfoList;
    }

    @XmlTransient
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCountryDepartment != null ? idCountryDepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryDepartment)) {
            return false;
        }
        CountryDepartment other = (CountryDepartment) object;
        if ((this.idCountryDepartment == null && other.idCountryDepartment != null) || (this.idCountryDepartment != null && !this.idCountryDepartment.equals(other.idCountryDepartment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.CountryDepartment[ idCountryDepartment=" + idCountryDepartment + " ]";
    }
    
}
