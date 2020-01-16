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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "complaint_evidence", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplaintEvidence.findAll", query = "SELECT c FROM ComplaintEvidence c"),
    @NamedQuery(name = "ComplaintEvidence.findByIdComplaintEvidence", query = "SELECT c FROM ComplaintEvidence c WHERE c.idComplaintEvidence = :idComplaintEvidence")})
public class ComplaintEvidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint_evidence")
    private Integer idComplaintEvidence;
    @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence")
    @ManyToOne(fetch = FetchType.LAZY)
    private Evidence evidence;
    @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;

    public ComplaintEvidence() {
    }

    public ComplaintEvidence(Integer idComplaintEvidence) {
        this.idComplaintEvidence = idComplaintEvidence;
    }

    public Integer getIdComplaintEvidence() {
        return idComplaintEvidence;
    }

    public void setIdComplaintEvidence(Integer idComplaintEvidence) {
        this.idComplaintEvidence = idComplaintEvidence;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
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
        hash += (idComplaintEvidence != null ? idComplaintEvidence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintEvidence)) {
            return false;
        }
        ComplaintEvidence other = (ComplaintEvidence) object;
        if ((this.idComplaintEvidence == null && other.idComplaintEvidence != null) || (this.idComplaintEvidence != null && !this.idComplaintEvidence.equals(other.idComplaintEvidence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.ComplaintEvidence[ idComplaintEvidence=" + idComplaintEvidence + " ]";
    }
    
}
