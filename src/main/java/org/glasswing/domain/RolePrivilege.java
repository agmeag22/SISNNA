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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "role_privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePrivilege.findAll", query = "SELECT r FROM RolePrivilege r")
    , @NamedQuery(name = "RolePrivilege.findByIdrolePrivilege", query = "SELECT r FROM RolePrivilege r WHERE r.idrolePrivilege = :idrolePrivilege")
    , @NamedQuery(name = "RolePrivilege.findByStatus", query = "SELECT r FROM RolePrivilege r WHERE r.status = :status")
    , @NamedQuery(name = "RolePrivilege.findByComment", query = "SELECT r FROM RolePrivilege r WHERE r.comment = :comment")})
public class RolePrivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrole_privilege")
    private Integer idrolePrivilege;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "privilege_id", referencedColumnName = "idprivilege")
    @ManyToOne(optional = false)
    private Privilege privilegeId;
    @JoinColumn(name = "role_id", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role roleId;

    public RolePrivilege() {
    }

    public RolePrivilege(Integer idrolePrivilege) {
        this.idrolePrivilege = idrolePrivilege;
    }

    public RolePrivilege(Integer idrolePrivilege, String status) {
        this.idrolePrivilege = idrolePrivilege;
        this.status = status;
    }

    public Integer getIdrolePrivilege() {
        return idrolePrivilege;
    }

    public void setIdrolePrivilege(Integer idrolePrivilege) {
        this.idrolePrivilege = idrolePrivilege;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Privilege getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Privilege privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolePrivilege != null ? idrolePrivilege.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePrivilege)) {
            return false;
        }
        RolePrivilege other = (RolePrivilege) object;
        if ((this.idrolePrivilege == null && other.idrolePrivilege != null) || (this.idrolePrivilege != null && !this.idrolePrivilege.equals(other.idrolePrivilege))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.RolePrivilege[ idrolePrivilege=" + idrolePrivilege + " ]";
    }
    
}
