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
    @Column(name = "id_deparment_positions")
    private Integer idDeparmentPositions;
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
    @JoinColumn(name = "id_deparment", referencedColumnName = "id_department")
    @ManyToOne
    private Department department;
    @JoinColumn(name = "id_position", referencedColumnName = "id_position")
    @ManyToOne
    private Position position;

    public DepartmentPositions() {
    }

    public DepartmentPositions(Integer idDeparmentPositions) {
        this.idDeparmentPositions = idDeparmentPositions;
    }

    public DepartmentPositions(Integer idDeparmentPositions, Date createdDate, Date updatedDate) {
        this.idDeparmentPositions = idDeparmentPositions;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdDeparmentPositions() {
        return idDeparmentPositions;
    }

    public void setIdDeparmentPositions(Integer idDeparmentPositions) {
        this.idDeparmentPositions = idDeparmentPositions;
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
        hash += (idDeparmentPositions != null ? idDeparmentPositions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentPositions)) {
            return false;
        }
        DepartmentPositions other = (DepartmentPositions) object;
        if ((this.idDeparmentPositions == null && other.idDeparmentPositions != null) || (this.idDeparmentPositions != null && !this.idDeparmentPositions.equals(other.idDeparmentPositions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.DepartmentPositions[ idDeparmentPositions=" + idDeparmentPositions + " ]";
    }
    
}
