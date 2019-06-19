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
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_case_icd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCaseIcd.findAll", query = "SELECT t FROM TCaseIcd t")
    , @NamedQuery(name = "TCaseIcd.findById", query = "SELECT t FROM TCaseIcd t WHERE t.id = :id")
    , @NamedQuery(name = "TCaseIcd.findByCreationDate", query = "SELECT t FROM TCaseIcd t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCaseIcd.findByCreationUser", query = "SELECT t FROM TCaseIcd t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCaseIcd.findByIcdReferenceEn", query = "SELECT t FROM TCaseIcd t WHERE t.icdReferenceEn = :icdReferenceEn")
    , @NamedQuery(name = "TCaseIcd.findByIcdcLocEn", query = "SELECT t FROM TCaseIcd t WHERE t.icdcLocEn = :icdcLocEn")
    , @NamedQuery(name = "TCaseIcd.findByIcdcTypeEn", query = "SELECT t FROM TCaseIcd t WHERE t.icdcTypeEn = :icdcTypeEn")
    , @NamedQuery(name = "TCaseIcd.findByMainDiagCaseFl", query = "SELECT t FROM TCaseIcd t WHERE t.mainDiagCaseFl = :mainDiagCaseFl")
    , @NamedQuery(name = "TCaseIcd.findByMainDiagDepFl", query = "SELECT t FROM TCaseIcd t WHERE t.mainDiagDepFl = :mainDiagDepFl")
    , @NamedQuery(name = "TCaseIcd.findByModificationDate", query = "SELECT t FROM TCaseIcd t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCaseIcd.findByModificationUser", query = "SELECT t FROM TCaseIcd t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCaseIcd.findByToGroupFl", query = "SELECT t FROM TCaseIcd t WHERE t.toGroupFl = :toGroupFl")
    , @NamedQuery(name = "TCaseIcd.findByVersion", query = "SELECT t FROM TCaseIcd t WHERE t.version = :version")})
public class TCaseIcd implements Serializable {

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
    @Column(name = "icd_reference_en")
    private BigDecimal icdReferenceEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "icdc_loc_en")
    private String icdcLocEn;
    @Column(name = "icdc_type_en")
    private BigDecimal icdcTypeEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "main_diag_case_fl")
    private long mainDiagCaseFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "main_diag_dep_fl")
    private long mainDiagDepFl;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_group_fl")
    private long toGroupFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;

//icdcCode
    @JoinColumn(name = "icdc_code", referencedColumnName = "icd_code")
    @ManyToOne()
    @IndexedEmbedded
    private IcdDe icdcCode;

//tCaseDepartment
    @JoinColumn(name = "t_case_department_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @ContainedIn
    private TCaseDepartment tCaseDepartmentId;
    
    @OneToMany(mappedBy = "tCaseIcdId")
    private Collection<TCaseIcd> tCaseIcdCollection;
    @JoinColumn(name = "t_case_icd_id", referencedColumnName = "id")
    @ManyToOne
    private TCaseIcd tCaseIcdId;
    @JoinColumn(name = "t_case_ward_id", referencedColumnName = "id")
    @ManyToOne
    private TCaseWard tCaseWardId;

    public TCaseIcd() {
    }

    public TCaseIcd(BigDecimal id) {
        this.id = id;
    }

    public TCaseIcd(BigDecimal id, String icdcLocEn, long mainDiagCaseFl, long mainDiagDepFl, long toGroupFl, BigDecimal version) {
        this.id = id;
        this.icdcLocEn = icdcLocEn;
        this.mainDiagCaseFl = mainDiagCaseFl;
        this.mainDiagDepFl = mainDiagDepFl;
        this.toGroupFl = toGroupFl;
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

    public BigDecimal getIcdReferenceEn() {
        return icdReferenceEn;
    }

    public void setIcdReferenceEn(BigDecimal icdReferenceEn) {
        this.icdReferenceEn = icdReferenceEn;
    }

    public String getIcdcLocEn() {
        return icdcLocEn;
    }

    public void setIcdcLocEn(String icdcLocEn) {
        this.icdcLocEn = icdcLocEn;
    }

    public BigDecimal getIcdcTypeEn() {
        return icdcTypeEn;
    }

    public void setIcdcTypeEn(BigDecimal icdcTypeEn) {
        this.icdcTypeEn = icdcTypeEn;
    }

    public long getMainDiagCaseFl() {
        return mainDiagCaseFl;
    }

    public void setMainDiagCaseFl(long mainDiagCaseFl) {
        this.mainDiagCaseFl = mainDiagCaseFl;
    }

    public long getMainDiagDepFl() {
        return mainDiagDepFl;
    }

    public void setMainDiagDepFl(long mainDiagDepFl) {
        this.mainDiagDepFl = mainDiagDepFl;
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

    public long getToGroupFl() {
        return toGroupFl;
    }

    public void setToGroupFl(long toGroupFl) {
        this.toGroupFl = toGroupFl;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public IcdDe getIcdcCode() {
        return icdcCode;
    }

    public void setIcdcCode(IcdDe icdcCode) {
        this.icdcCode = icdcCode;
    }

    public TCaseDepartment getTCaseDepartmentId() {
        return tCaseDepartmentId;
    }

    public void setTCaseDepartmentId(TCaseDepartment tCaseDepartmentId) {
        this.tCaseDepartmentId = tCaseDepartmentId;
    }

    @XmlTransient
    public Collection<TCaseIcd> getTCaseIcdCollection() {
        return tCaseIcdCollection;
    }

    public void setTCaseIcdCollection(Collection<TCaseIcd> tCaseIcdCollection) {
        this.tCaseIcdCollection = tCaseIcdCollection;
    }

    public TCaseIcd getTCaseIcdId() {
        return tCaseIcdId;
    }

    public void setTCaseIcdId(TCaseIcd tCaseIcdId) {
        this.tCaseIcdId = tCaseIcdId;
    }

    public TCaseWard getTCaseWardId() {
        return tCaseWardId;
    }

    public void setTCaseWardId(TCaseWard tCaseWardId) {
        this.tCaseWardId = tCaseWardId;
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
        if (!(object instanceof TCaseIcd)) {
            return false;
        }
        TCaseIcd other = (TCaseIcd) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TCaseIcd[ id=" + id + " ]";
    }
    
}
