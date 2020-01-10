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
@Table(name = "abuse")
@NamedQueries({
    @NamedQuery(name = "Abuse.findAll", query = "SELECT a FROM Abuse a"),
    @NamedQuery(name = "Abuse.findByIdAbuse", query = "SELECT a FROM Abuse a WHERE a.idAbuse = :idAbuse"),
    @NamedQuery(name = "Abuse.findByName", query = "SELECT a FROM Abuse a WHERE a.name = :name"),
    @NamedQuery(name = "Abuse.findByCreatedDate", query = "SELECT a FROM Abuse a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "Abuse.findByUpdatedDate", query = "SELECT a FROM Abuse a WHERE a.updatedDate = :updatedDate")})
public class Abuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_abuse")
    private Integer idAbuse;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @OneToMany(mappedBy = "abuse", fetch = FetchType.LAZY)
    private Set<Complaint> complaintSet;

    public Abuse() {
    }

    public Abuse(Integer idAbuse) {
        this.idAbuse = idAbuse;
    }

    public Integer getIdAbuse() {
        return idAbuse;
    }

    public void setIdAbuse(Integer idAbuse) {
        this.idAbuse = idAbuse;
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

    public Set<Complaint> getComplaintSet() {
        return complaintSet;
    }

    public void setComplaintSet(Set<Complaint> complaintSet) {
        this.complaintSet = complaintSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbuse != null ? idAbuse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abuse)) {
            return false;
        }
        Abuse other = (Abuse) object;
        if ((this.idAbuse == null && other.idAbuse != null) || (this.idAbuse != null && !this.idAbuse.equals(other.idAbuse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Abuse[ idAbuse=" + idAbuse + " ]";
    }
    
}
