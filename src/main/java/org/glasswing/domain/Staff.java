/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elect
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByIdstaff", query = "SELECT s FROM Staff s WHERE s.idstaff = :idstaff")
    , @NamedQuery(name = "Staff.findByName", query = "SELECT s FROM Staff s WHERE s.name = :name")
    , @NamedQuery(name = "Staff.findByLastname", query = "SELECT s FROM Staff s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email")
    , @NamedQuery(name = "Staff.findByStatus", query = "SELECT s FROM Staff s WHERE s.status = :status")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstaff")
    private Integer idstaff;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<CommitteeStaff> committeeStaffList;
    @JoinColumn(name = "department_id", referencedColumnName = "iddepartment")
    @ManyToOne(optional = false)
    private Department departmentId;
    @JoinColumn(name = "user_id", referencedColumnName = "iduser")
    @OneToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "staffId")
    private List<Complaint> complaintList;

    public Staff() {
    }

    public Staff(Integer idstaff) {
        this.idstaff = idstaff;
    }

    public Staff(Integer idstaff, String name, String lastname, String email, String status) {
        this.idstaff = idstaff;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.status = status;
    }

    public Integer getIdstaff() {
        return idstaff;
    }

    public void setIdstaff(Integer idstaff) {
        this.idstaff = idstaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<CommitteeStaff> getCommitteeStaffList() {
        return committeeStaffList;
    }

    public void setCommitteeStaffList(List<CommitteeStaff> committeeStaffList) {
        this.committeeStaffList = committeeStaffList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstaff != null ? idstaff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.idstaff == null && other.idstaff != null) || (this.idstaff != null && !this.idstaff.equals(other.idstaff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.glasswing.domain.Staff[ idstaff=" + idstaff + " ]";
    }
    
}
