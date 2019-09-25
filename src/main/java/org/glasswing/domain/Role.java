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
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIdrole", query = "SELECT r FROM Role r WHERE r.idrole = :idrole")
    , @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")
    , @NamedQuery(name = "Role.findByCreatedUp", query = "SELECT r FROM Role r WHERE r.createdUp = :createdUp")
    , @NamedQuery(name = "Role.findByUpdatedUp", query = "SELECT r FROM Role r WHERE r.updatedUp = :updatedUp")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrole")
    private Integer idrole;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<UserRole> userRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<RolePrivilege> rolePrivilegeList;

    public Role() {
    }

    public Role(Integer idrole) {
        this.idrole = idrole;
    }

    public Role(Integer idrole, String name, Date createdUp, Date updatedUp) {
        this.idrole = idrole;
        this.name = name;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
    }

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
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
    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @XmlTransient
    public List<RolePrivilege> getRolePrivilegeList() {
        return rolePrivilegeList;
    }

    public void setRolePrivilegeList(List<RolePrivilege> rolePrivilegeList) {
        this.rolePrivilegeList = rolePrivilegeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Role[ idrole=" + idrole + " ]";
    }
    
}
