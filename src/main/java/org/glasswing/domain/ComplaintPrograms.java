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
@Table(name = "complaint_programs", catalog = "sisnna", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComplaintPrograms.findAll", query = "SELECT c FROM ComplaintPrograms c"),
    @NamedQuery(name = "ComplaintPrograms.findByIdComplaintPrograms", query = "SELECT c FROM ComplaintPrograms c WHERE c.idComplaintPrograms = :idComplaintPrograms")})
public class ComplaintPrograms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint_programs")
    private Integer idComplaintPrograms;
    @JoinColumn(name = "id_program", referencedColumnName = "id_program")
    @ManyToOne(fetch = FetchType.LAZY)
    private Program program;
    @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;

    public ComplaintPrograms() {
    }

    public ComplaintPrograms(Integer idComplaintPrograms) {
        this.idComplaintPrograms = idComplaintPrograms;
    }

    public Integer getIdComplaintPrograms() {
        return idComplaintPrograms;
    }

    public void setIdComplaintPrograms(Integer idComplaintPrograms) {
        this.idComplaintPrograms = idComplaintPrograms;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
        hash += (idComplaintPrograms != null ? idComplaintPrograms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComplaintPrograms)) {
            return false;
        }
        ComplaintPrograms other = (ComplaintPrograms) object;
        if ((this.idComplaintPrograms == null && other.idComplaintPrograms != null) || (this.idComplaintPrograms != null && !this.idComplaintPrograms.equals(other.idComplaintPrograms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.ComplaintPrograms[ idComplaintPrograms=" + idComplaintPrograms + " ]";
    }
    
}
