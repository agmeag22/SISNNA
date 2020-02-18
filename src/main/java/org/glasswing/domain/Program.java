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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author elect
 */
@Entity
@Table(name = "program", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p")})
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_program")
    private Integer idProgram;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
    private List<ComplaintPrograms> complaintProgramsList;

    public Program() {
    }

    public Program(Integer idProgram) {
        this.idProgram = idProgram;
    }

    public Program(Integer idProgram, Date createdDate, Date updatedDate) {
        this.idProgram = idProgram;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(Integer idProgram) {
        this.idProgram = idProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<ComplaintPrograms> getComplaintProgramsList() {
        return complaintProgramsList;
    }

    public void setComplaintProgramsList(List<ComplaintPrograms> complaintProgramsList) {
        this.complaintProgramsList = complaintProgramsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgram != null ? idProgram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.idProgram == null && other.idProgram != null) || (this.idProgram != null && !this.idProgram.equals(other.idProgram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Program[ idProgram=" + idProgram + " ]";
    }
    
}
