/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_case_department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCaseDepartment.findAll", query = "SELECT t FROM TCaseDepartment t")
    , @NamedQuery(name = "TCaseDepartment.findById", query = "SELECT t FROM TCaseDepartment t WHERE t.id = :id")
    , @NamedQuery(name = "TCaseDepartment.findByCreationDate", query = "SELECT t FROM TCaseDepartment t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCaseDepartment.findByCreationUser", query = "SELECT t FROM TCaseDepartment t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCaseDepartment.findByDepShortName", query = "SELECT t FROM TCaseDepartment t WHERE t.depShortName = :depShortName")
    , @NamedQuery(name = "TCaseDepartment.findByDepcAdmDate", query = "SELECT t FROM TCaseDepartment t WHERE t.depcAdmDate = :depcAdmDate")
    , @NamedQuery(name = "TCaseDepartment.findByDepcAdmodEn", query = "SELECT t FROM TCaseDepartment t WHERE t.depcAdmodEn = :depcAdmodEn")
    , @NamedQuery(name = "TCaseDepartment.findByDepcDisDate", query = "SELECT t FROM TCaseDepartment t WHERE t.depcDisDate = :depcDisDate")
    , @NamedQuery(name = "TCaseDepartment.findByDepcHmv", query = "SELECT t FROM TCaseDepartment t WHERE t.depcHmv = :depcHmv")
    , @NamedQuery(name = "TCaseDepartment.findByDepcIsAdmissionFl", query = "SELECT t FROM TCaseDepartment t WHERE t.depcIsAdmissionFl = :depcIsAdmissionFl")
    , @NamedQuery(name = "TCaseDepartment.findByDepcIsBedIntensivFl", query = "SELECT t FROM TCaseDepartment t WHERE t.depcIsBedIntensivFl = :depcIsBedIntensivFl")
    , @NamedQuery(name = "TCaseDepartment.findByDepcIsDischargeFl", query = "SELECT t FROM TCaseDepartment t WHERE t.depcIsDischargeFl = :depcIsDischargeFl")
    , @NamedQuery(name = "TCaseDepartment.findByDepcIsTreatingFl", query = "SELECT t FROM TCaseDepartment t WHERE t.depcIsTreatingFl = :depcIsTreatingFl")
    , @NamedQuery(name = "TCaseDepartment.findByModificationDate", query = "SELECT t FROM TCaseDepartment t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCaseDepartment.findByModificationUser", query = "SELECT t FROM TCaseDepartment t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCaseDepartment.findByVersion", query = "SELECT t FROM TCaseDepartment t WHERE t.version = :version")})
public class TCaseDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dep_short_name")
    private String depShortName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_adm_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depcAdmDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "depc_admod_en")
    private String depcAdmodEn;
    @Column(name = "depc_dis_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date depcDisDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_hmv")
    private long depcHmv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_is_admission_fl")
    private long depcIsAdmissionFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_is_bed_intensiv_fl")
    private long depcIsBedIntensivFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_is_discharge_fl")
    private long depcIsDischargeFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depc_is_treating_fl")
    private long depcIsTreatingFl;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;

//tCaseIcd    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tCaseDepartmentId")
//    @Fetch(value = FetchMode.SUBSELECT)
    @IndexedEmbedded
    private Collection<TCaseIcd> tCaseIcdCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tCaseDepartmentId")
    private Collection<TCaseWard> tCaseWardCollection;

//tCaseOps    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tCaseDepartmentId")
//    @Fetch(value = FetchMode.SUBSELECT)
    @IndexedEmbedded
    private Collection<TCaseOps> tCaseOpsCollection;

//tCaseDetails    
    @JoinColumn(name = "t_case_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @ContainedIn
    private TCaseDetails tCaseDetailsId;

    public TCaseDepartment() {
    }

    public TCaseDepartment(BigDecimal id) {
        this.id = id;
    }

    public TCaseDepartment(BigDecimal id, String depShortName, Date depcAdmDate, String depcAdmodEn, long depcHmv, long depcIsAdmissionFl, long depcIsBedIntensivFl, long depcIsDischargeFl, long depcIsTreatingFl, BigDecimal version) {
        this.id = id;
        this.depShortName = depShortName;
        this.depcAdmDate = depcAdmDate;
        this.depcAdmodEn = depcAdmodEn;
        this.depcHmv = depcHmv;
        this.depcIsAdmissionFl = depcIsAdmissionFl;
        this.depcIsBedIntensivFl = depcIsBedIntensivFl;
        this.depcIsDischargeFl = depcIsDischargeFl;
        this.depcIsTreatingFl = depcIsTreatingFl;
        this.version = version;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(BigDecimal creationUser) {
        this.creationUser = creationUser;
    }

    public String getDepShortName() {
        return depShortName;
    }

    public void setDepShortName(String depShortName) {
        this.depShortName = depShortName;
    }

    public Date getDepcAdmDate() {
        return depcAdmDate;
    }

    public void setDepcAdmDate(Date depcAdmDate) {
        this.depcAdmDate = depcAdmDate;
    }

    public String getDepcAdmodEn() {
        return depcAdmodEn;
    }

    public void setDepcAdmodEn(String depcAdmodEn) {
        this.depcAdmodEn = depcAdmodEn;
    }

    public Date getDepcDisDate() {
        return depcDisDate;
    }

    public void setDepcDisDate(Date depcDisDate) {
        this.depcDisDate = depcDisDate;
    }

    public long getDepcHmv() {
        return depcHmv;
    }

    public void setDepcHmv(long depcHmv) {
        this.depcHmv = depcHmv;
    }

    public long getDepcIsAdmissionFl() {
        return depcIsAdmissionFl;
    }

    public void setDepcIsAdmissionFl(long depcIsAdmissionFl) {
        this.depcIsAdmissionFl = depcIsAdmissionFl;
    }

    public long getDepcIsBedIntensivFl() {
        return depcIsBedIntensivFl;
    }

    public void setDepcIsBedIntensivFl(long depcIsBedIntensivFl) {
        this.depcIsBedIntensivFl = depcIsBedIntensivFl;
    }

    public long getDepcIsDischargeFl() {
        return depcIsDischargeFl;
    }

    public void setDepcIsDischargeFl(long depcIsDischargeFl) {
        this.depcIsDischargeFl = depcIsDischargeFl;
    }

    public long getDepcIsTreatingFl() {
        return depcIsTreatingFl;
    }

    public void setDepcIsTreatingFl(long depcIsTreatingFl) {
        this.depcIsTreatingFl = depcIsTreatingFl;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public BigDecimal getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(BigDecimal modificationUser) {
        this.modificationUser = modificationUser;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<TCaseIcd> getTCaseIcdCollection() {
        return tCaseIcdCollection;
    }

    public void setTCaseIcdCollection(Collection<TCaseIcd> tCaseIcdCollection) {
        this.tCaseIcdCollection = tCaseIcdCollection;
    }

    @XmlTransient
    public Collection<TCaseWard> getTCaseWardCollection() {
        return tCaseWardCollection;
    }

    public void setTCaseWardCollection(Collection<TCaseWard> tCaseWardCollection) {
        this.tCaseWardCollection = tCaseWardCollection;
    }

    @XmlTransient
    public Collection<TCaseOps> getTCaseOpsCollection() {
        return tCaseOpsCollection;
    }

    public void setTCaseOpsCollection(Collection<TCaseOps> tCaseOpsCollection) {
        this.tCaseOpsCollection = tCaseOpsCollection;
    }

    public TCaseDetails getTCaseDetailsId() {
        return tCaseDetailsId;
    }

    public void setTCaseDetailsId(TCaseDetails tCaseDetailsId) {
        this.tCaseDetailsId = tCaseDetailsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCaseDepartment)) {
            return false;
        }
        TCaseDepartment other = (TCaseDepartment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TCaseDepartment[ id=" + id + " ]";
    }

}
