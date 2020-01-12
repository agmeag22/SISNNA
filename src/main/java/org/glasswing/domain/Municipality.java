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
@Table(name = "municipality")
@NamedQueries({
    @NamedQuery(name = "Municipality.findAll", query = "SELECT m FROM Municipality m")})
public class Municipality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipality")
    private Integer idMunicipality;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    
        @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department")
    @ManyToOne(fetch = FetchType.LAZY)
    private CountryDepartment countryDepartment;
    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<PersonalInfo> personalInfoList;
    @OneToMany(mappedBy = "municipality", fetch = FetchType.LAZY)
    private List<Complaint> complaintList;

    public Municipality() {
    }

    public Municipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public Integer getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Integer idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDepartment getCountryDepartment() {
        return countryDepartment;
    }

    public void setCountryDepartment(CountryDepartment countryDepartment) {
        this.countryDepartment = countryDepartment;
    }

    public List<PersonalInfo> getPersonalInfoList() {
        return personalInfoList;
    }

    public void setPersonalInfoList(List<PersonalInfo> personalInfoList) {
        this.personalInfoList = personalInfoList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipality != null ? idMunicipality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipality)) {
            return false;
        }
        Municipality other = (Municipality) object;
        if ((this.idMunicipality == null && other.idMunicipality != null) || (this.idMunicipality != null && !this.idMunicipality.equals(other.idMunicipality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Municipality[ idMunicipality=" + idMunicipality + " ]";
    }
    
}
