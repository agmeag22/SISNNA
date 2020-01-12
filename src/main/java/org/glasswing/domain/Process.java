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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "process")
@NamedQueries({
    @NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p")})
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_process")
    private Integer idProcess;
    @Lob
    @Size(max = 65535)
    @Column(name = "action_to_take")
    private String actionToTake;
    @Column(name = "recurrence")
    private Boolean recurrence;
    @Lob
    @Size(max = 65535)
    @Column(name = "evaluation_resolution")
    private String evaluationResolution;
    @Column(name = "guardian_notificated")
    private Boolean guardianNotificated;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @ManyToMany(mappedBy = "processList", fetch = FetchType.LAZY)
    private List<Evidence> evidenceList;
  
        @JoinColumn(name = "id_complaint", referencedColumnName = "id_complaint")
    @ManyToOne(fetch = FetchType.LAZY)
    private Complaint complaint;
  
        @JoinColumn(name = "id_state", referencedColumnName = "id_state")
    @ManyToOne(fetch = FetchType.LAZY)
    private State state;
   
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Process() {
    }

    public Process(Integer idProcess) {
        this.idProcess = idProcess;
    }

    public Integer getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(Integer idProcess) {
        this.idProcess = idProcess;
    }

    public String getActionToTake() {
        return actionToTake;
    }

    public void setActionToTake(String actionToTake) {
        this.actionToTake = actionToTake;
    }

    public Boolean getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Boolean recurrence) {
        this.recurrence = recurrence;
    }

    public String getEvaluationResolution() {
        return evaluationResolution;
    }

    public void setEvaluationResolution(String evaluationResolution) {
        this.evaluationResolution = evaluationResolution;
    }

    public Boolean getGuardianNotificated() {
        return guardianNotificated;
    }

    public void setGuardianNotificated(Boolean guardianNotificated) {
        this.guardianNotificated = guardianNotificated;
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

    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void setEvidenceList(List<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
        hash += (idProcess != null ? idProcess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.idProcess == null && other.idProcess != null) || (this.idProcess != null && !this.idProcess.equals(other.idProcess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Process[ idProcess=" + idProcess + " ]";
    }
    
}
