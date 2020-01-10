/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "country_department")
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
    @JoinColumns({
        @JoinColumn(name = "id_country", referencedColumnName = "id_country"),
        @JoinColumn(name = "id_country", referencedColumnName = "id_country")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private Set<Municipality> municipalitySet;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private Set<PersonalInfo> personalInfoSet;
    @OneToMany(mappedBy = "countryDepartment", fetch = FetchType.LAZY)
    private Set<Complaint> complaintSet;

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

    public Set<Municipality> getMunicipalitySet() {
        return municipalitySet;
    }

    public void setMunicipalitySet(Set<Municipality> municipalitySet) {
        this.municipalitySet = municipalitySet;
    }

    public Set<PersonalInfo> getPersonalInfoSet() {
        return personalInfoSet;
    }

    public void setPersonalInfoSet(Set<PersonalInfo> personalInfoSet) {
        this.personalInfoSet = personalInfoSet;
    }

    public Set<Complaint> getComplaintSet() {
        return complaintSet;
    }

    public void setComplaintSet(Set<Complaint> complaintSet) {
        this.complaintSet = complaintSet;
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
