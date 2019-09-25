/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByIddepartment", query = "SELECT d FROM Department d WHERE d.iddepartment = :iddepartment")
    , @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")
    , @NamedQuery(name = "Department.findByCreatedUp", query = "SELECT d FROM Department d WHERE d.createdUp = :createdUp")
    , @NamedQuery(name = "Department.findByUpdatedUp", query = "SELECT d FROM Department d WHERE d.updatedUp = :updatedUp")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepartment")
    private Integer iddepartment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "created_up")
    private String createdUp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "updated_up")
    private String updatedUp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private List<Staff> staffList;

    public Department() {
    }

    public Department(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Department(Integer iddepartment, String name, String createdUp, String updatedUp) {
        this.iddepartment = iddepartment;
        this.name = name;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
    }

    public Integer getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedUp() {
        return createdUp;
    }

    public void setCreatedUp(String createdUp) {
        this.createdUp = createdUp;
    }

    public String getUpdatedUp() {
        return updatedUp;
    }

    public void setUpdatedUp(String updatedUp) {
        this.updatedUp = updatedUp;
    }

    @XmlTransient
    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartment != null ? iddepartment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.iddepartment == null && other.iddepartment != null) || (this.iddepartment != null && !this.iddepartment.equals(other.iddepartment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Department[ iddepartment=" + iddepartment + " ]";
    }
    
}
