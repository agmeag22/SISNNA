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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "Department_Positions", catalog = "sisnna", schema = "")
public class DepartmentPositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_department_positions")
    private Integer idDepartmentPositions;

    @JoinColumn(name = "id_department", referencedColumnName = "id_department")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    
    @JoinColumn(name = "id_position", referencedColumnName = "id_position")
    @OneToOne(fetch = FetchType.LAZY)
    private Position position;

    public DepartmentPositions() {
    }

    public DepartmentPositions(Integer idDepartmentPositions) {
        this.idDepartmentPositions = idDepartmentPositions;
    }

    public Integer getIdDepartmentPositions() {
        return idDepartmentPositions;
    }

    public void setIdDepartmentPositions(Integer idDepartmentPositions) {
        this.idDepartmentPositions = idDepartmentPositions;
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
