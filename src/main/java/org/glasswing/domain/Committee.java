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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "committee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Committee.findAll", query = "SELECT c FROM Committee c")
    , @NamedQuery(name = "Committee.findByIdCommittee", query = "SELECT c FROM Committee c WHERE c.idCommittee = :idCommittee")
    , @NamedQuery(name = "Committee.findByName", query = "SELECT c FROM Committee c WHERE c.name = :name")
    , @NamedQuery(name = "Committee.findByCreatedUp", query = "SELECT c FROM Committee c WHERE c.createdUp = :createdUp")
    , @NamedQuery(name = "Committee.findByUpdatedUp", query = "SELECT c FROM Committee c WHERE c.updatedUp = :updatedUp")})
public class Committee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommittee")
    private Integer idCommittee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_up")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdUp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_up")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedUp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "committeeId")
    private List<CommitteeStaff> committeeStaffList;

    public Committee() {
    }

    public Committee(Integer idCommittee) {
        this.idCommittee = idCommittee;
    }

    public Committee(Integer idCommittee, String name, Date createdUp, Date updatedUp) {
        this.idCommittee = idCommittee;
        this.name = name;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
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

    public Date getCreatedUp() {
        return createdUp;
    }

    public void setCreatedUp(Date createdUp) {
        this.createdUp = createdUp;
    }

    public Date getUpdatedUp() {
        return updatedUp;
    }

    public void setUpdatedUp(Date updatedUp) {
        this.updatedUp = updatedUp;
    }

    @XmlTransient
    public List<CommitteeStaff> getCommitteeStaffList() {
        return committeeStaffList;
    }

    public void setCommitteeStaffList(List<CommitteeStaff> committeeStaffList) {
        this.committeeStaffList = committeeStaffList;
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
