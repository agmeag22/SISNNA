/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "evidence")
@NamedQueries({
    @NamedQuery(name = "Evidence.findAll", query = "SELECT e FROM Evidence e"),
    @NamedQuery(name = "Evidence.findByIdEvidence", query = "SELECT e FROM Evidence e WHERE e.idEvidence = :idEvidence")})
public class Evidence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidence")
    private Integer idEvidence;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "path")
    private String path;
    @JoinTable(name = "investigation_evidence", joinColumns = {
        @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence"),
        @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence")}, inverseJoinColumns = {
        @JoinColumn(name = "id_process", referencedColumnName = "id_process"),
        @JoinColumn(name = "id_process", referencedColumnName = "id_process")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Process> processSet;
    @JoinTable(name = "complaint_evidence", joinColumns = {
        @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence"),
        @JoinColumn(name = "id_evidence", referencedColumnName = "id_evidence")}, inverseJoinColumns = {
        @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint"),
        @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Complaint> complaintSet;

    public Evidence() {
    }

    public Evidence(Integer idEvidence) {
        this.idEvidence = idEvidence;
    }

    public Integer getIdEvidence() {
        return idEvidence;
    }

    public void setIdEvidence(Integer idEvidence) {
        this.idEvidence = idEvidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<Process> getProcessSet() {
        return processSet;
    }

    public void setProcessSet(Set<Process> processSet) {
        this.processSet = processSet;
    }

    public Set<Complaint> getComplaintSet() {
        return complaintSet;
    }

    public void setComplaintSet(Set<Complaint> complaintSet) {
        this.complaintSet = complaintSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidence != null ? idEvidence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidence)) {
            return false;
        }
        Evidence other = (Evidence) object;
        if ((this.idEvidence == null && other.idEvidence != null) || (this.idEvidence != null && !this.idEvidence.equals(other.idEvidence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Evidence[ idEvidence=" + idEvidence + " ]";
    }
    
}
