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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "members")
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m"),
    @NamedQuery(name = "Members.findByIdMembers", query = "SELECT m FROM Members m WHERE m.idMembers = :idMembers")})
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_members")
    private Integer idMembers;
    @JoinColumns({
        @JoinColumn(name = "id_committee", referencedColumnName = "id_committee"),
        @JoinColumn(name = "id_committee", referencedColumnName = "id_committee")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Committee committee;
    @JoinColumns({
        @JoinColumn(name = "id_role", referencedColumnName = "id_role"),
        @JoinColumn(name = "id_role", referencedColumnName = "id_role")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    @JoinColumns({
        @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Members() {
    }

    public Members(Integer idMembers) {
        this.idMembers = idMembers;
    }

    public Integer getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(Integer idMembers) {
        this.idMembers = idMembers;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembers != null ? idMembers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.idMembers == null && other.idMembers != null) || (this.idMembers != null && !this.idMembers.equals(other.idMembers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Members[ idMembers=" + idMembers + " ]";
    }
    
}
