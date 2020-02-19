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
@Table(name = "abuse", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "Abuse.findAll", query = "SELECT a FROM Abuse a")})
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
    @Basic(optional = false)
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @OneToMany(mappedBy = "abuse", fetch = FetchType.LAZY)
    private List<ComplaintAbuses> complaintAbusesList;

    public Abuse() {
    }

    public Abuse(Integer idAbuse) {
        this.idAbuse = idAbuse;
    }

    public Abuse(Integer idAbuse, Date createdDate, Date updatedDate) {
        this.idAbuse = idAbuse;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public List<ComplaintAbuses> getComplaintAbusesList() {
        return complaintAbusesList;
    }

    public void setComplaintAbusesList(List<ComplaintAbuses> complaintAbusesList) {
        this.complaintAbusesList = complaintAbusesList;
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
