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
import javax.persistence.Table;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "complaint_modifications", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "ComplaintModifications.findAll", query = "SELECT c FROM ComplaintModifications c")})
public class ComplaintModifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint_modifications")
    private Integer idComplaintModifications;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;

    public ComplaintModifications() {
    }

    public ComplaintModifications(Integer idComplaintModifications) {
        this.idComplaintModifications = idComplaintModifications;
    }

    public Integer getIdComplaintModifications() {
        return idComplaintModifications;
    }

    public void setIdComplaintModifications(Integer idComplaintModifications) {
        this.idComplaintModifications = idComplaintModifications;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComplaintModifications != null ? idComplaintModifications.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintModifications)) {
            return false;
        }
        ComplaintModifications other = (ComplaintModifications) object;
        if ((this.idComplaintModifications == null && other.idComplaintModifications != null) || (this.idComplaintModifications != null && !this.idComplaintModifications.equals(other.idComplaintModifications))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.ComplaintModifications[ idComplaintModifications=" + idComplaintModifications + " ]";
    }
    
}
