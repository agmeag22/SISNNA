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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "complaint", catalog = "sisnna", schema = "")
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c")})
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_complaint")
    private Integer idComplaint;
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
    @Temporal(TemporalType.DATE)
    private Date misdemeanorTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "accused_name")
    private String accusedName;
    @Lob
    @Size(max = 65535)
    @Column(name = "victim_name")
    private String victimName;
    @Column(name = "victim_age")
    private Integer victimAge;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "clasification_comment")
    private String clasificationComment;
    @Lob
    @Size(max = 65535)
    @Column(name = "resolution")
    private String resolution;
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
    @OneToMany(mappedBy = "complaint")
    private List<ComplaintPrograms> complaintProgramsList;
    @OneToMany(mappedBy = "complaint")
    private List<ComplaintAbuses> complaintAbusesList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private User user;
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    @ManyToOne
    private Country country;
    @JoinColumn(name = "id_country_department", referencedColumnName = "id_country_department")
    @ManyToOne
    private CountryDepartment countryDepartment;
    @JoinColumn(name = "id_municipality", referencedColumnName = "id_municipality")
    @ManyToOne
    private Municipality municipality;
    @JoinColumn(name = "id_accused_type", referencedColumnName = "id_accused_type")
    @ManyToOne
    private AccusedType accusedType;
    @JoinColumn(name = "id_state", referencedColumnName = "id_state")
    @ManyToOne
    private State state;
    @JoinColumn(name = "id_gender", referencedColumnName = "id_gender")
    @ManyToOne
    private Gender gender;
    @JoinColumn(name = "id_priority", referencedColumnName = "id_priority")
    @ManyToOne
    private Priority priority;
    @OneToMany(mappedBy = "complaint")
    private List<ComplaintModifications> complaintModificationsList;

    public Complaint() {
    }

    public Complaint(Integer idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Complaint(Integer idComplaint, Date createdDate, Date updatedDate) {
        this.idComplaint = idComplaint;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Integer idComplaint) {
        this.idComplaint = idComplaint;
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

    public Integer getVictimAge() {
        return victimAge;
    }

    public void setVictimAge(Integer victimAge) {
        this.victimAge = victimAge;
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

    public String getClasificationComment() {
        return clasificationComment;
    }

    public void setClasificationComment(String clasificationComment) {
        this.clasificationComment = clasificationComment;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
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

    public List<ComplaintAbuses> getComplaintAbusesList() {
        return complaintAbusesList;
    }

    public void setComplaintAbusesList(List<ComplaintAbuses> complaintAbusesList) {
        this.complaintAbusesList = complaintAbusesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public AccusedType getAccusedType() {
        return accusedType;
    }

    public void setAccusedType(AccusedType accusedType) {
        this.accusedType = accusedType;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public List<ComplaintModifications> getComplaintModificationsList() {
        return complaintModificationsList;
    }

    public void setComplaintModificationsList(List<ComplaintModifications> complaintModificationsList) {
        this.complaintModificationsList = complaintModificationsList;
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
