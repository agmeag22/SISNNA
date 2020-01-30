/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "role_permissions", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePermissions.findAll", query = "SELECT r FROM RolePermissions r"),
    @NamedQuery(name = "RolePermissions.findByIdRolePermissions", query = "SELECT r FROM RolePermissions r WHERE r.idRolePermissions = :idRolePermissions"),
    })
public class RolePermissions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role_permissions")
    private Integer idRolePermissions;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    @JoinColumn(name = "id_permission", referencedColumnName = "id_permission")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Permission permission;

    public RolePermissions() {
    }

    public RolePermissions(Integer idRolePermissions) {
        this.idRolePermissions = idRolePermissions;
    }

    public Integer getIdRolePermissions() {
        return idRolePermissions;
    }

    public void setIdRolePermissions(Integer idRolePermissions) {
        this.idRolePermissions = idRolePermissions;
    }

   

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolePermissions != null ? idRolePermissions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePermissions)) {
            return false;
        }
        RolePermissions other = (RolePermissions) object;
        if ((this.idRolePermissions == null && other.idRolePermissions != null) || (this.idRolePermissions != null && !this.idRolePermissions.equals(other.idRolePermissions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.RolePermissions[ idRolePermissions=" + idRolePermissions + " ]";
    }
    
}
