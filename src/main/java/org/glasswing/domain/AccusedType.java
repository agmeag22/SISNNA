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
@Table(name = "accused_type")
@NamedQueries({
    @NamedQuery(name = "AccusedType.findAll", query = "SELECT a FROM AccusedType a")})
public class AccusedType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_accused_type")
    private Integer idAccusedType;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "accusedType", fetch = FetchType.LAZY)
    private List<Complaint> complaintList;

    public AccusedType() {
    }

    public AccusedType(Integer idAccusedType) {
        this.idAccusedType = idAccusedType;
    }

    public Integer getIdAccusedType() {
        return idAccusedType;
    }

    public void setIdAccusedType(Integer idAccusedType) {
        this.idAccusedType = idAccusedType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (idAccusedType != null ? idAccusedType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccusedType)) {
            return false;
        }
        AccusedType other = (AccusedType) object;
        if ((this.idAccusedType == null && other.idAccusedType != null) || (this.idAccusedType != null && !this.idAccusedType.equals(other.idAccusedType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.AccusedType[ idAccusedType=" + idAccusedType + " ]";
    }
    
}
