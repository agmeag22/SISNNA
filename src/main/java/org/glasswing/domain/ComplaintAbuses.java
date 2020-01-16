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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "complaint_abuses", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplaintAbuses.findAll", query = "SELECT c FROM ComplaintAbuses c"),
    @NamedQuery(name = "ComplaintAbuses.findByIdComplaintAbuses", query = "SELECT c FROM ComplaintAbuses c WHERE c.idComplaintAbuses = :idComplaintAbuses")})
public class ComplaintAbuses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint_abuses")
    private Integer idComplaintAbuses;
    @JoinColumn(name = "id_abuse", referencedColumnName = "id_abuse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Abuse abuse;
    @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;

    public ComplaintAbuses() {
    }

    public ComplaintAbuses(Integer idComplaintAbuses) {
        this.idComplaintAbuses = idComplaintAbuses;
    }

    public Integer getIdComplaintAbuses() {
        return idComplaintAbuses;
    }

    public void setIdComplaintAbuses(Integer idComplaintAbuses) {
        this.idComplaintAbuses = idComplaintAbuses;
    }

    public Abuse getAbuse() {
        return abuse;
    }

    public void setAbuse(Abuse abuse) {
        this.abuse = abuse;
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
        hash += (idComplaintAbuses != null ? idComplaintAbuses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintAbuses)) {
            return false;
        }
        ComplaintAbuses other = (ComplaintAbuses) object;
        if ((this.idComplaintAbuses == null && other.idComplaintAbuses != null) || (this.idComplaintAbuses != null && !this.idComplaintAbuses.equals(other.idComplaintAbuses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.ComplaintAbuses[ idComplaintAbuses=" + idComplaintAbuses + " ]";
    }
    
}
