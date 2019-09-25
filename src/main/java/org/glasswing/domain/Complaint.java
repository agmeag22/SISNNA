/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "complaint")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c")
    , @NamedQuery(name = "Complaint.findByIdcomplaint", query = "SELECT c FROM Complaint c WHERE c.idcomplaint = :idcomplaint")
    , @NamedQuery(name = "Complaint.findByComplaintCategory", query = "SELECT c FROM Complaint c WHERE c.complaintCategory = :complaintCategory")
    , @NamedQuery(name = "Complaint.findByComplaintType", query = "SELECT c FROM Complaint c WHERE c.complaintType = :complaintType")
    , @NamedQuery(name = "Complaint.findByComment", query = "SELECT c FROM Complaint c WHERE c.comment = :comment")
    , @NamedQuery(name = "Complaint.findByDate", query = "SELECT c FROM Complaint c WHERE c.date = :date")
    , @NamedQuery(name = "Complaint.findByTime", query = "SELECT c FROM Complaint c WHERE c.time = :time")
    , @NamedQuery(name = "Complaint.findByStatus", query = "SELECT c FROM Complaint c WHERE c.status = :status")
    , @NamedQuery(name = "Complaint.findByCreatedUp", query = "SELECT c FROM Complaint c WHERE c.createdUp = :createdUp")
    , @NamedQuery(name = "Complaint.findByUpdatedUp", query = "SELECT c FROM Complaint c WHERE c.updatedUp = :updatedUp")
    , @NamedQuery(name = "Complaint.findByAccused", query = "SELECT c FROM Complaint c WHERE c.accused = :accused")
    , @NamedQuery(name = "Complaint.findByProgram", query = "SELECT c FROM Complaint c WHERE c.program = :program")
    , @NamedQuery(name = "Complaint.findByVictimName", query = "SELECT c FROM Complaint c WHERE c.victimName = :victimName")
    , @NamedQuery(name = "Complaint.findByVictimAge", query = "SELECT c FROM Complaint c WHERE c.victimAge = :victimAge")
    , @NamedQuery(name = "Complaint.findByVictimGender", query = "SELECT c FROM Complaint c WHERE c.victimGender = :victimGender")
    , @NamedQuery(name = "Complaint.findByVictimGrade", query = "SELECT c FROM Complaint c WHERE c.victimGrade = :victimGrade")
    , @NamedQuery(name = "Complaint.findByVictimLocation", query = "SELECT c FROM Complaint c WHERE c.victimLocation = :victimLocation")
    , @NamedQuery(name = "Complaint.findByVictionGuardian", query = "SELECT c FROM Complaint c WHERE c.victionGuardian = :victionGuardian")
    , @NamedQuery(name = "Complaint.findByVictimAddress", query = "SELECT c FROM Complaint c WHERE c.victimAddress = :victimAddress")
    , @NamedQuery(name = "Complaint.findByConfidentNumber", query = "SELECT c FROM Complaint c WHERE c.confidentNumber = :confidentNumber")
    , @NamedQuery(name = "Complaint.findByNumberAbuse", query = "SELECT c FROM Complaint c WHERE c.numberAbuse = :numberAbuse")
    , @NamedQuery(name = "Complaint.findByIsNotifiedGuardian", query = "SELECT c FROM Complaint c WHERE c.isNotifiedGuardian = :isNotifiedGuardian")
    , @NamedQuery(name = "Complaint.findByVictimComment", query = "SELECT c FROM Complaint c WHERE c.victimComment = :victimComment")
    , @NamedQuery(name = "Complaint.findByIsVictimInDanger", query = "SELECT c FROM Complaint c WHERE c.isVictimInDanger = :isVictimInDanger")
    , @NamedQuery(name = "Complaint.findByProcessId", query = "SELECT c FROM Complaint c WHERE c.processId = :processId")
    , @NamedQuery(name = "Complaint.findByVeracity", query = "SELECT c FROM Complaint c WHERE c.veracity = :veracity")
    , @NamedQuery(name = "Complaint.findByRecord", query = "SELECT c FROM Complaint c WHERE c.record = :record")})
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomplaint")
    private Integer idcomplaint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "complaint_category")
    private short complaintCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "complaint_type")
    private short complaintType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accused")
    private String accused;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "program")
    private String program;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "victim_name")
    private String victimName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "victim_age")
    private int victimAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "victim_gender")
    private String victimGender;
    @Size(max = 45)
    @Column(name = "victim_grade")
    private String victimGrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "victim_location")
    private String victimLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "viction_guardian")
    private String victionGuardian;
    @Size(max = 45)
    @Column(name = "victim_address")
    private String victimAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "confident_number")
    private String confidentNumber;
    @Column(name = "number_abuse")
    private Integer numberAbuse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_notified_guardian")
    private short isNotifiedGuardian;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "victim_comment")
    private String victimComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_victim_in_danger")
    private short isVictimInDanger;
    @Column(name = "process_id")
    private Integer processId;
    @Column(name = "veracity")
    private Short veracity;
    @Size(max = 200)
    @Column(name = "record")
    private String record;
    @OneToOne(mappedBy = "complaintId")
    private Process process;
    @JoinColumn(name = "staff_id", referencedColumnName = "idstaff")
    @ManyToOne
    private Staff staffId;
    @JoinColumn(name = "type_abuse_id", referencedColumnName = "idtype_abuse")
    @ManyToOne(optional = false)
    private TypeAbuse typeAbuseId;

    public Complaint() {
    }

    public Complaint(Integer idcomplaint) {
        this.idcomplaint = idcomplaint;
    }

    public Complaint(Integer idcomplaint, short complaintCategory, short complaintType, String comment, Date date, Date time, String status, Date createdUp, Date updatedUp, String accused, String program, String victimName, int victimAge, String victimGender, String victimLocation, String victionGuardian, String confidentNumber, short isNotifiedGuardian, String victimComment, short isVictimInDanger) {
        this.idcomplaint = idcomplaint;
        this.complaintCategory = complaintCategory;
        this.complaintType = complaintType;
        this.comment = comment;
        this.date = date;
        this.time = time;
        this.status = status;
        this.createdUp = createdUp;
        this.updatedUp = updatedUp;
        this.accused = accused;
        this.program = program;
        this.victimName = victimName;
        this.victimAge = victimAge;
        this.victimGender = victimGender;
        this.victimLocation = victimLocation;
        this.victionGuardian = victionGuardian;
        this.confidentNumber = confidentNumber;
        this.isNotifiedGuardian = isNotifiedGuardian;
        this.victimComment = victimComment;
        this.isVictimInDanger = isVictimInDanger;
    }

    public Integer getIdcomplaint() {
        return idcomplaint;
    }

    public void setIdcomplaint(Integer idcomplaint) {
        this.idcomplaint = idcomplaint;
    }

    public short getComplaintCategory() {
        return complaintCategory;
    }

    public void setComplaintCategory(short complaintCategory) {
        this.complaintCategory = complaintCategory;
    }

    public short getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(short complaintType) {
        this.complaintType = complaintType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAccused() {
        return accused;
    }

    public void setAccused(String accused) {
        this.accused = accused;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public int getVictimAge() {
        return victimAge;
    }

    public void setVictimAge(int victimAge) {
        this.victimAge = victimAge;
    }

    public String getVictimGender() {
        return victimGender;
    }

    public void setVictimGender(String victimGender) {
        this.victimGender = victimGender;
    }

    public String getVictimGrade() {
        return victimGrade;
    }

    public void setVictimGrade(String victimGrade) {
        this.victimGrade = victimGrade;
    }

    public String getVictimLocation() {
        return victimLocation;
    }

    public void setVictimLocation(String victimLocation) {
        this.victimLocation = victimLocation;
    }

    public String getVictionGuardian() {
        return victionGuardian;
    }

    public void setVictionGuardian(String victionGuardian) {
        this.victionGuardian = victionGuardian;
    }

    public String getVictimAddress() {
        return victimAddress;
    }

    public void setVictimAddress(String victimAddress) {
        this.victimAddress = victimAddress;
    }

    public String getConfidentNumber() {
        return confidentNumber;
    }

    public void setConfidentNumber(String confidentNumber) {
        this.confidentNumber = confidentNumber;
    }

    public Integer getNumberAbuse() {
        return numberAbuse;
    }

    public void setNumberAbuse(Integer numberAbuse) {
        this.numberAbuse = numberAbuse;
    }

    public short getIsNotifiedGuardian() {
        return isNotifiedGuardian;
    }

    public void setIsNotifiedGuardian(short isNotifiedGuardian) {
        this.isNotifiedGuardian = isNotifiedGuardian;
    }

    public String getVictimComment() {
        return victimComment;
    }

    public void setVictimComment(String victimComment) {
        this.victimComment = victimComment;
    }

    public short getIsVictimInDanger() {
        return isVictimInDanger;
    }

    public void setIsVictimInDanger(short isVictimInDanger) {
        this.isVictimInDanger = isVictimInDanger;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public Short getVeracity() {
        return veracity;
    }

    public void setVeracity(Short veracity) {
        this.veracity = veracity;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public TypeAbuse getTypeAbuseId() {
        return typeAbuseId;
    }

    public void setTypeAbuseId(TypeAbuse typeAbuseId) {
        this.typeAbuseId = typeAbuseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomplaint != null ? idcomplaint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.idcomplaint == null && other.idcomplaint != null) || (this.idcomplaint != null && !this.idcomplaint.equals(other.idcomplaint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Complaint[ idcomplaint=" + idcomplaint + " ]";
    }
    
}
