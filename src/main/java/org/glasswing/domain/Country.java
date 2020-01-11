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
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findByIdCountry", query = "SELECT c FROM Country c WHERE c.idCountry = :idCountry"),
    @NamedQuery(name = "Country.findByCode", query = "SELECT c FROM Country c WHERE c.code = :code"),
    @NamedQuery(name = "Country.findByIso3166a1", query = "SELECT c FROM Country c WHERE c.iso3166a1 = :iso3166a1"),
    @NamedQuery(name = "Country.findByIso3166a2", query = "SELECT c FROM Country c WHERE c.iso3166a2 = :iso3166a2"),
    @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_country")
    private Integer idCountry;
    @Size(max = 6)
    @Column(name = "code")
    private String code;
    @Size(max = 2)
    @Column(name = "iso3166a1")
    private String iso3166a1;
    @Size(max = 3)
    @Column(name = "iso3166a2")
    private String iso3166a2;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Committee> committeeSet;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<CountryDepartment> countryDepartmentSet;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<PersonalInfo> personalInfoSet;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Complaint> complaintSet;

    public Country() {
    }

    public Country(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIso3166a1() {
        return iso3166a1;
    }

    public void setIso3166a1(String iso3166a1) {
        this.iso3166a1 = iso3166a1;
    }

    public String getIso3166a2() {
        return iso3166a2;
    }

    public void setIso3166a2(String iso3166a2) {
        this.iso3166a2 = iso3166a2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Committee> getCommitteeSet() {
        return committeeSet;
    }

    public void setCommitteeSet(Set<Committee> committeeSet) {
        this.committeeSet = committeeSet;
    }

    public Set<CountryDepartment> getCountryDepartmentSet() {
        return countryDepartmentSet;
    }

    public void setCountryDepartmentSet(Set<CountryDepartment> countryDepartmentSet) {
        this.countryDepartmentSet = countryDepartmentSet;
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
        hash += (idCountry != null ? idCountry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.idCountry == null && other.idCountry != null) || (this.idCountry != null && !this.idCountry.equals(other.idCountry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Country[ idCountry=" + idCountry + " ]";
    }
    
}