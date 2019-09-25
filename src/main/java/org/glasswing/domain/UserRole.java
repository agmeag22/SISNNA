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
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
    , @NamedQuery(name = "UserRole.findByIduserRole", query = "SELECT u FROM UserRole u WHERE u.iduserRole = :iduserRole")
    , @NamedQuery(name = "UserRole.findByStatus", query = "SELECT u FROM UserRole u WHERE u.status = :status")
    , @NamedQuery(name = "UserRole.findByComment", query = "SELECT u FROM UserRole u WHERE u.comment = :comment")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser_role")
    private Integer iduserRole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "role_id", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role roleId;
    @JoinColumn(name = "user_id", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User userId;

    public UserRole() {
    }

    public UserRole(Integer iduserRole) {
        this.iduserRole = iduserRole;
    }

    public UserRole(Integer iduserRole, String status) {
        this.iduserRole = iduserRole;
        this.status = status;
    }

    public Integer getIduserRole() {
        return iduserRole;
    }

    public void setIduserRole(Integer iduserRole) {
        this.iduserRole = iduserRole;
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

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserRole != null ? iduserRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.iduserRole == null && other.iduserRole != null) || (this.iduserRole != null && !this.iduserRole.equals(other.iduserRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.UserRole[ iduserRole=" + iduserRole + " ]";
    }
    
}
