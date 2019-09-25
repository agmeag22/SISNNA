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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p")
    , @NamedQuery(name = "Process.findByIdprocess", query = "SELECT p FROM Process p WHERE p.idprocess = :idprocess")
    , @NamedQuery(name = "Process.findByStatus", query = "SELECT p FROM Process p WHERE p.status = :status")
    , @NamedQuery(name = "Process.findByMailSent", query = "SELECT p FROM Process p WHERE p.mailSent = :mailSent")
    , @NamedQuery(name = "Process.findByControlPointContacted", query = "SELECT p FROM Process p WHERE p.controlPointContacted = :controlPointContacted")
    , @NamedQuery(name = "Process.findByIsThereEvidence", query = "SELECT p FROM Process p WHERE p.isThereEvidence = :isThereEvidence")
    , @NamedQuery(name = "Process.findByNotificationToSuperior", query = "SELECT p FROM Process p WHERE p.notificationToSuperior = :notificationToSuperior")
    , @NamedQuery(name = "Process.findByVerbalNotification", query = "SELECT p FROM Process p WHERE p.verbalNotification = :verbalNotification")
    , @NamedQuery(name = "Process.findByWrittenNotification", query = "SELECT p FROM Process p WHERE p.writtenNotification = :writtenNotification")
    , @NamedQuery(name = "Process.findByRecurrence", query = "SELECT p FROM Process p WHERE p.recurrence = :recurrence")
    , @NamedQuery(name = "Process.findByInterruptContact", query = "SELECT p FROM Process p WHERE p.interruptContact = :interruptContact")
    , @NamedQuery(name = "Process.findByRecurrenceReport", query = "SELECT p FROM Process p WHERE p.recurrenceReport = :recurrenceReport")
    , @NamedQuery(name = "Process.findByCommitteeEvaluation", query = "SELECT p FROM Process p WHERE p.committeeEvaluation = :committeeEvaluation")})
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprocess")
    private Integer idprocess;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mail_sent")
    private short mailSent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_point_contacted")
    private short controlPointContacted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_there_evidence")
    private short isThereEvidence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notification_to_superior")
    private short notificationToSuperior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verbal_notification")
    private short verbalNotification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "written_notification")
    private short writtenNotification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurrence")
    private short recurrence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interrupt_contact")
    private short interruptContact;
    @Size(max = 200)
    @Column(name = "recurrence_report")
    private String recurrenceReport;
    @Size(max = 200)
    @Column(name = "committee_evaluation")
    private String committeeEvaluation;
    @JoinColumn(name = "complaint_id", referencedColumnName = "idcomplaint")
    @OneToOne
    private Complaint complaintId;

    public Process() {
    }

    public Process(Integer idprocess) {
        this.idprocess = idprocess;
    }

    public Process(Integer idprocess, String status, short mailSent, short controlPointContacted, short isThereEvidence, short notificationToSuperior, short verbalNotification, short writtenNotification, short recurrence, short interruptContact) {
        this.idprocess = idprocess;
        this.status = status;
        this.mailSent = mailSent;
        this.controlPointContacted = controlPointContacted;
        this.isThereEvidence = isThereEvidence;
        this.notificationToSuperior = notificationToSuperior;
        this.verbalNotification = verbalNotification;
        this.writtenNotification = writtenNotification;
        this.recurrence = recurrence;
        this.interruptContact = interruptContact;
    }

    public Integer getIdprocess() {
        return idprocess;
    }

    public void setIdprocess(Integer idprocess) {
        this.idprocess = idprocess;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public short getMailSent() {
        return mailSent;
    }

    public void setMailSent(short mailSent) {
        this.mailSent = mailSent;
    }

    public short getControlPointContacted() {
        return controlPointContacted;
    }

    public void setControlPointContacted(short controlPointContacted) {
        this.controlPointContacted = controlPointContacted;
    }

    public short getIsThereEvidence() {
        return isThereEvidence;
    }

    public void setIsThereEvidence(short isThereEvidence) {
        this.isThereEvidence = isThereEvidence;
    }

    public short getNotificationToSuperior() {
        return notificationToSuperior;
    }

    public void setNotificationToSuperior(short notificationToSuperior) {
        this.notificationToSuperior = notificationToSuperior;
    }

    public short getVerbalNotification() {
        return verbalNotification;
    }

    public void setVerbalNotification(short verbalNotification) {
        this.verbalNotification = verbalNotification;
    }

    public short getWrittenNotification() {
        return writtenNotification;
    }

    public void setWrittenNotification(short writtenNotification) {
        this.writtenNotification = writtenNotification;
    }

    public short getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(short recurrence) {
        this.recurrence = recurrence;
    }

    public short getInterruptContact() {
        return interruptContact;
    }

    public void setInterruptContact(short interruptContact) {
        this.interruptContact = interruptContact;
    }

    public String getRecurrenceReport() {
        return recurrenceReport;
    }

    public void setRecurrenceReport(String recurrenceReport) {
        this.recurrenceReport = recurrenceReport;
    }

    public String getCommitteeEvaluation() {
        return committeeEvaluation;
    }

    public void setCommitteeEvaluation(String committeeEvaluation) {
        this.committeeEvaluation = committeeEvaluation;
    }

    public Complaint getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Complaint complaintId) {
        this.complaintId = complaintId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocess != null ? idprocess.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.idprocess == null && other.idprocess != null) || (this.idprocess != null && !this.idprocess.equals(other.idprocess))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Process[ idprocess=" + idprocess + " ]";
    }
    
}
