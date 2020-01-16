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
@Table(name = "investigation_evidence", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvestigationEvidence.findAll", query = "SELECT i FROM InvestigationEvidence i"),
    @NamedQuery(name = "InvestigationEvidence.findByIdInvestigationEvidence", query = "SELECT i FROM InvestigationEvidence i WHERE i.idInvestigationEvidence = :idInvestigationEvidence")})
public class InvestigationEvidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_investigation_evidence")
    private Integer idInvestigationEvidence;
    @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence")
    @ManyToOne(fetch = FetchType.LAZY)
    private Evidence evidence;
    @JoinColumn(name = "id_process", referencedColumnName = "id_process")
    @ManyToOne(fetch = FetchType.LAZY)
    private Process process;

    public InvestigationEvidence() {
    }

    public InvestigationEvidence(Integer idInvestigationEvidence) {
        this.idInvestigationEvidence = idInvestigationEvidence;
    }

    public Integer getIdInvestigationEvidence() {
        return idInvestigationEvidence;
    }

    public void setIdInvestigationEvidence(Integer idInvestigationEvidence) {
        this.idInvestigationEvidence = idInvestigationEvidence;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestigationEvidence != null ? idInvestigationEvidence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvestigationEvidence)) {
            return false;
        }
        InvestigationEvidence other = (InvestigationEvidence) object;
        if ((this.idInvestigationEvidence == null && other.idInvestigationEvidence != null) || (this.idInvestigationEvidence != null && !this.idInvestigationEvidence.equals(other.idInvestigationEvidence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.InvestigationEvidence[ idInvestigationEvidence=" + idInvestigationEvidence + " ]";
    }
    
}
