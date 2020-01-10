/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "complaint")
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c"),
    @NamedQuery(name = "Complaint.findByIdComplaint", query = "SELECT c FROM Complaint c WHERE c.idComplaint = :idComplaint"),
    @NamedQuery(name = "Complaint.findByIdPriority", query = "SELECT c FROM Complaint c WHERE c.idPriority = :idPriority"),
    @NamedQuery(name = "Complaint.findByMisdemeanorDate", query = "SELECT c FROM Complaint c WHERE c.misdemeanorDate = :misdemeanorDate"),
    @NamedQuery(name = "Complaint.findByMisdemeanorTime", query = "SELECT c FROM Complaint c WHERE c.misdemeanorTime = :misdemeanorTime"),
    @NamedQuery(name = "Complaint.findByIsRecurrence", query = "SELECT c FROM Complaint c WHERE c.isRecurrence = :isRecurrence"),
    @NamedQuery(name = "Complaint.findByCreatedDate", query = "SELECT c FROM Complaint c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Complaint.findByUpdatedDate", query = "SELECT c FROM Complaint c WHERE c.updatedDate = :updatedDate")})
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint")
    private Integer idComplaint;
    @Column(name = "id_priority")
    private Integer idPriority;
    @Lob
    @Size(max = 65535)
    @Column(name = "grade")
    private String grade;
    @Lob
    @Size(max = 65535)
    @Column(name = "scholar_center")
    private String scholarCenter;
    @Column(name = "misdemeanor_date")
    @Temporal(TemporalType.DATE)
    private Date misdemeanorDate;
    @Column(name = "misdemeanor_time")
    @Temporal(TemporalType.TIME)
    private Date misdemeanorTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "accused _name")
    private String accusedName;
    @Lob
    @Size(max = 65535)
    @Column(name = "victim_name")
    private String victimName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "child_context")
    private String childContext;
    @Lob
    @Size(max = 65535)
    @Column(name = "action_taken")
    private String actionTaken;
    @Lob
    @Size(max = 65535)
    @Column(name = "situation_location")
    private String situationLocation;
    @Column(name = "is_recurrence")
    private Boolean isRecurrence;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @ManyToMany(mappedBy = "complaintSet", fetch = FetchType.LAZY)
    private Set<Evidence> evidenceSet;
    @OneToMany(mappedBy = "complaint", fetch = FetchType.LAZY)
    private Set<Process> processSet;
    @JoinColumns({
        @JoinColumn(name = "id_abuse", referencedColumnName = "id_abuse"),
        @JoinColumn(name = "id_abuse", referencedColumnName = "id_abuse")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Abuse abuse;
    @JoinColumns({
        @JoinColumn(name = "id_accused_type", referencedColumnName = "id_accused_type"),
        @JoinColumn(name = "id_accused_type", referencedColumnName = "id_accused_type")})
    @ManyToOne(fetch = FetchType.LAZY)
    private AccusedType accusedType;
    @JoinColumns({
        @JoinColumn(name = "id_country", referencedColumnName = "id_country"),
        @JoinColumn(name = "id_country", referencedColumnName = "id_country")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
    @JoinColumns({
        @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department"),
        @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department")})
    @ManyToOne(fetch = FetchType.LAZY)
    private CountryDepartment countryDepartment;
    @JoinColumns({
        @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality"),
        @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Municipality municipality;
    @JoinColumns({
        @JoinColumn(name = "id_program", referencedColumnName = "id_program"),
        @JoinColumn(name = "id_program", referencedColumnName = "id_program")})
    @ManyToOne(fetch = FetchType.LAZY)
    private Program program;
    @JoinColumns({
        @JoinColumn(name = "id_state", referencedColumnName = "id_state"),
        @JoinColumn(name = "id_state", referencedColumnName = "id_state")})
    @ManyToOne(fetch = FetchType.LAZY)
    private State state;
    @JoinColumns({
        @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Complaint() {
    }

    public Complaint(Integer idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Integer getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Integer idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Integer getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Integer idPriority) {
        this.idPriority = idPriority;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScholarCenter() {
        return scholarCenter;
    }

    public void setScholarCenter(String scholarCenter) {
        this.scholarCenter = scholarCenter;
    }

    public Date getMisdemeanorDate() {
        return misdemeanorDate;
    }

    public void setMisdemeanorDate(Date misdemeanorDate) {
        this.misdemeanorDate = misdemeanorDate;
    }

    public Date getMisdemeanorTime() {
        return misdemeanorTime;
    }

    public void setMisdemeanorTime(Date misdemeanorTime) {
        this.misdemeanorTime = misdemeanorTime;
    }

    public String getAccusedName() {
        return accusedName;
    }

    public void setAccusedName(String accusedName) {
        this.accusedName = accusedName;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChildContext() {
        return childContext;
    }

    public void setChildContext(String childContext) {
        this.childContext = childContext;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getSituationLocation() {
        return situationLocation;
    }

    public void setSituationLocation(String situationLocation) {
        this.situationLocation = situationLocation;
    }

    public Boolean getIsRecurrence() {
        return isRecurrence;
    }

    public void setIsRecurrence(Boolean isRecurrence) {
        this.isRecurrence = isRecurrence;
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

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    public Set<Process> getProcessSet() {
        return processSet;
    }

    public void setProcessSet(Set<Process> processSet) {
        this.processSet = processSet;
    }

    public Abuse getAbuse() {
        return abuse;
    }

    public void setAbuse(Abuse abuse) {
        this.abuse = abuse;
    }

    public AccusedType getAccusedType() {
        return accusedType;
    }

    public void setAccusedType(AccusedType accusedType) {
        this.accusedType = accusedType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CountryDepartment getCountryDepartment() {
        return countryDepartment;
    }

    public void setCountryDepartment(CountryDepartment countryDepartment) {
        this.countryDepartment = countryDepartment;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
        hash += (idComplaint != null ? idComplaint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.idComplaint == null && other.idComplaint != null) || (this.idComplaint != null && !this.idComplaint.equals(other.idComplaint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Complaint[ idComplaint=" + idComplaint + " ]";
    }
    
}
