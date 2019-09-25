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
@Table(name = "type_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeUser.findAll", query = "SELECT t FROM TypeUser t")
    , @NamedQuery(name = "TypeUser.findByIdtypeUser", query = "SELECT t FROM TypeUser t WHERE t.idtypeUser = :idtypeUser")
    , @NamedQuery(name = "TypeUser.findByName", query = "SELECT t FROM TypeUser t WHERE t.name = :name")
    , @NamedQuery(name = "TypeUser.findByCreatedUp", query = "SELECT t FROM TypeUser t WHERE t.createdUp = :createdUp")
    , @NamedQuery(name = "TypeUser.findByUpdatedUp", query = "SELECT t FROM TypeUser t WHERE t.updatedUp = :updatedUp")})
public class TypeUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtype_user")
    private Integer idtypeUser;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeUserId")
    private List<User> userList;

    public TypeUser() {
    }

    public TypeUser(Integer idtypeUser) {
        this.idtypeUser = idtypeUser;
    }

    public TypeUser(Integer idtypeUser, String name, Date createdUp, Date updatedUp) {
        this.idtypeUser = idtypeUser;
        this.name = name;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
    }

    public Integer getIdtypeUser() {
        return idtypeUser;
    }

    public void setIdtypeUser(Integer idtypeUser) {
        this.idtypeUser = idtypeUser;
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
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeUser != null ? idtypeUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeUser)) {
            return false;
        }
        TypeUser other = (TypeUser) object;
        if ((this.idtypeUser == null && other.idtypeUser != null) || (this.idtypeUser != null && !this.idtypeUser.equals(other.idtypeUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.TypeUser[ idtypeUser=" + idtypeUser + " ]";
    }
    
}
