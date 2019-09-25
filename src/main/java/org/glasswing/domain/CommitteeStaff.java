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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "committee_staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommitteeStaff.findAll", query = "SELECT c FROM CommitteeStaff c")
    , @NamedQuery(name = "CommitteeStaff.findByIdcommitteeStaff", query = "SELECT c FROM CommitteeStaff c WHERE c.idcommitteeStaff = :idcommitteeStaff")
    , @NamedQuery(name = "CommitteeStaff.findByStatus", query = "SELECT c FROM CommitteeStaff c WHERE c.status = :status")
    , @NamedQuery(name = "CommitteeStaff.findByComment", query = "SELECT c FROM CommitteeStaff c WHERE c.comment = :comment")})
public class CommitteeStaff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcommittee_staff")
    private Integer idcommitteeStaff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "committee_id", referencedColumnName = "idCommittee")
    @ManyToOne(optional = false)
    private Committee committeeId;
    @JoinColumn(name = "staff_id", referencedColumnName = "idstaff")
    @ManyToOne(optional = false)
    private Staff staffId;

    public CommitteeStaff() {
    }

    public CommitteeStaff(Integer idcommitteeStaff) {
        this.idcommitteeStaff = idcommitteeStaff;
    }

    public CommitteeStaff(Integer idcommitteeStaff, String status) {
        this.idcommitteeStaff = idcommitteeStaff;
        this.status = status;
    }

    public Integer getIdcommitteeStaff() {
        return idcommitteeStaff;
    }

    public void setIdcommitteeStaff(Integer idcommitteeStaff) {
        this.idcommitteeStaff = idcommitteeStaff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Committee getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Committee committeeId) {
        this.committeeId = committeeId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommitteeStaff != null ? idcommitteeStaff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommitteeStaff)) {
            return false;
        }
        CommitteeStaff other = (CommitteeStaff) object;
        if ((this.idcommitteeStaff == null && other.idcommitteeStaff != null) || (this.idcommitteeStaff != null && !this.idcommitteeStaff.equals(other.idcommitteeStaff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.CommitteeStaff[ idcommitteeStaff=" + idcommitteeStaff + " ]";
    }
    
}
