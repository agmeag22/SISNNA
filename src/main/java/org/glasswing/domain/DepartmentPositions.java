/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "department_positions", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "DepartmentPositions.findAll", query = "SELECT d FROM DepartmentPositions d")})
public class DepartmentPositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_department_positions")
    private Integer idDepartmentPositions;
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
    @JoinColumn(name = "id_department", referencedColumnName = "id_department")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @JoinColumn(name = "id_position", referencedColumnName = "id_position")
    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    public DepartmentPositions() {
    }

    public DepartmentPositions(Integer idDepartmentPositions) {
        this.idDepartmentPositions = idDepartmentPositions;
    }

    public DepartmentPositions(Integer idDepartmentPositions, Date createdDate, Date updatedDate) {
        this.idDepartmentPositions = idDepartmentPositions;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdDepartmentPositions() {
        return idDepartmentPositions;
    }

    public void setIdDepartmentPositions(Integer idDepartmentPositions) {
        this.idDepartmentPositions = idDepartmentPositions;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartmentPositions != null ? idDepartmentPositions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentPositions)) {
            return false;
        }
        DepartmentPositions other = (DepartmentPositions) object;
        if ((this.idDepartmentPositions == null && other.idDepartmentPositions != null) || (this.idDepartmentPositions != null && !this.idDepartmentPositions.equals(other.idDepartmentPositions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.DepartmentPositions[ idDepartmentPositions=" + idDepartmentPositions + " ]";
    }
    
}
