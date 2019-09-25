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
@Table(name = "type_abuse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeAbuse.findAll", query = "SELECT t FROM TypeAbuse t")
    , @NamedQuery(name = "TypeAbuse.findByIdtypeAbuse", query = "SELECT t FROM TypeAbuse t WHERE t.idtypeAbuse = :idtypeAbuse")
    , @NamedQuery(name = "TypeAbuse.findByName", query = "SELECT t FROM TypeAbuse t WHERE t.name = :name")
    , @NamedQuery(name = "TypeAbuse.findByCreatedUp", query = "SELECT t FROM TypeAbuse t WHERE t.createdUp = :createdUp")
    , @NamedQuery(name = "TypeAbuse.findByUpdatedUp", query = "SELECT t FROM TypeAbuse t WHERE t.updatedUp = :updatedUp")})
public class TypeAbuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtype_abuse")
    private Integer idtypeAbuse;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeAbuseId")
    private List<Complaint> complaintList;

    public TypeAbuse() {
    }

    public TypeAbuse(Integer idtypeAbuse) {
        this.idtypeAbuse = idtypeAbuse;
    }

    public TypeAbuse(Integer idtypeAbuse, String name, Date createdUp, Date updatedUp) {
        this.idtypeAbuse = idtypeAbuse;
        this.name = name;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
    }

    public Integer getIdtypeAbuse() {
        return idtypeAbuse;
    }

    public void setIdtypeAbuse(Integer idtypeAbuse) {
        this.idtypeAbuse = idtypeAbuse;
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
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeAbuse != null ? idtypeAbuse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeAbuse)) {
            return false;
        }
        TypeAbuse other = (TypeAbuse) object;
        if ((this.idtypeAbuse == null && other.idtypeAbuse != null) || (this.idtypeAbuse != null && !this.idtypeAbuse.equals(other.idtypeAbuse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.TypeAbuse[ idtypeAbuse=" + idtypeAbuse + " ]";
    }
    
}
