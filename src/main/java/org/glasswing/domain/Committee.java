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

/**
 *
 * @author elect
 */
@Entity
@Table(name = "committee", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "Committee.findAll", query = "SELECT c FROM Committee c")})
public class Committee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_committee")
    private Integer idCommittee;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
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
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "committee")
    private List<Members> membersList;

    public Committee() {
    }

    public Committee(Integer idCommittee) {
        this.idCommittee = idCommittee;
    }

    public Committee(Integer idCommittee, Date createdDate, Date updatedDate) {
        this.idCommittee = idCommittee;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdCommittee() {
        return idCommittee;
    }

    public void setIdCommittee(Integer idCommittee) {
        this.idCommittee = idCommittee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Members> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Members> membersList) {
        this.membersList = membersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommittee != null ? idCommittee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Committee)) {
            return false;
        }
        Committee other = (Committee) object;
        if ((this.idCommittee == null && other.idCommittee != null) || (this.idCommittee != null && !this.idCommittee.equals(other.idCommittee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Committee[ idCommittee=" + idCommittee + " ]";
    }
    
}
