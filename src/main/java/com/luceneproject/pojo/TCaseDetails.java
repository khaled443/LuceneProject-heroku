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
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_case_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCaseDetails.findAll", query = "SELECT t FROM TCaseDetails t")
    , @NamedQuery(name = "TCaseDetails.findById", query = "SELECT t FROM TCaseDetails t WHERE t.id = :id")
    , @NamedQuery(name = "TCaseDetails.findByActualFl", query = "SELECT t FROM TCaseDetails t WHERE t.actualFl = :actualFl")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionCauseEn", query = "SELECT t FROM TCaseDetails t WHERE t.admissionCauseEn = :admissionCauseEn")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionDate", query = "SELECT t FROM TCaseDetails t WHERE t.admissionDate = :admissionDate")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionLawEn", query = "SELECT t FROM TCaseDetails t WHERE t.admissionLawEn = :admissionLawEn")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionModeEn", query = "SELECT t FROM TCaseDetails t WHERE t.admissionModeEn = :admissionModeEn")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionReason12En", query = "SELECT t FROM TCaseDetails t WHERE t.admissionReason12En = :admissionReason12En")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionReason34En", query = "SELECT t FROM TCaseDetails t WHERE t.admissionReason34En = :admissionReason34En")
    , @NamedQuery(name = "TCaseDetails.findByAdmissionWeight", query = "SELECT t FROM TCaseDetails t WHERE t.admissionWeight = :admissionWeight")
    , @NamedQuery(name = "TCaseDetails.findByAgeDays", query = "SELECT t FROM TCaseDetails t WHERE t.ageDays = :ageDays")
    , @NamedQuery(name = "TCaseDetails.findByAgeYears", query = "SELECT t FROM TCaseDetails t WHERE t.ageYears = :ageYears")
    , @NamedQuery(name = "TCaseDetails.findByCreationDate", query = "SELECT t FROM TCaseDetails t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCaseDetails.findByCreationUser", query = "SELECT t FROM TCaseDetails t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCaseDetails.findByCsdComment", query = "SELECT t FROM TCaseDetails t WHERE t.csdComment = :csdComment")
    , @NamedQuery(name = "TCaseDetails.findByDateOfAccident", query = "SELECT t FROM TCaseDetails t WHERE t.dateOfAccident = :dateOfAccident")
    , @NamedQuery(name = "TCaseDetails.findByDischargeDate", query = "SELECT t FROM TCaseDetails t WHERE t.dischargeDate = :dischargeDate")
    , @NamedQuery(name = "TCaseDetails.findByDischargeReason12En", query = "SELECT t FROM TCaseDetails t WHERE t.dischargeReason12En = :dischargeReason12En")
    , @NamedQuery(name = "TCaseDetails.findByDischargeReason3En", query = "SELECT t FROM TCaseDetails t WHERE t.dischargeReason3En = :dischargeReason3En")
    , @NamedQuery(name = "TCaseDetails.findByHdIcdCode", query = "SELECT t FROM TCaseDetails t WHERE t.hdIcdCode = :hdIcdCode")
    , @NamedQuery(name = "TCaseDetails.findByHmv", query = "SELECT t FROM TCaseDetails t WHERE t.hmv = :hmv")
    , @NamedQuery(name = "TCaseDetails.findByLeave", query = "SELECT t FROM TCaseDetails t WHERE t.leave = :leave")
    , @NamedQuery(name = "TCaseDetails.findByLocalFl", query = "SELECT t FROM TCaseDetails t WHERE t.localFl = :localFl")
    , @NamedQuery(name = "TCaseDetails.findByLos", query = "SELECT t FROM TCaseDetails t WHERE t.los = :los")
    , @NamedQuery(name = "TCaseDetails.findByLosAlteration", query = "SELECT t FROM TCaseDetails t WHERE t.losAlteration = :losAlteration")
    , @NamedQuery(name = "TCaseDetails.findByLosIntensiv", query = "SELECT t FROM TCaseDetails t WHERE t.losIntensiv = :losIntensiv")
    , @NamedQuery(name = "TCaseDetails.findByModificationDate", query = "SELECT t FROM TCaseDetails t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCaseDetails.findByModificationUser", query = "SELECT t FROM TCaseDetails t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCaseDetails.findBySumOfIcd", query = "SELECT t FROM TCaseDetails t WHERE t.sumOfIcd = :sumOfIcd")
    , @NamedQuery(name = "TCaseDetails.findBySumOfOps", query = "SELECT t FROM TCaseDetails t WHERE t.sumOfOps = :sumOfOps")
    , @NamedQuery(name = "TCaseDetails.findByTransferringHospIdent", query = "SELECT t FROM TCaseDetails t WHERE t.transferringHospIdent = :transferringHospIdent")
    , @NamedQuery(name = "TCaseDetails.findByVersion", query = "SELECT t FROM TCaseDetails t WHERE t.version = :version")
    , @NamedQuery(name = "TCaseDetails.findByVersionNumber", query = "SELECT t FROM TCaseDetails t WHERE t.versionNumber = :versionNumber")
    , @NamedQuery(name = "TCaseDetails.findByCancelDate", query = "SELECT t FROM TCaseDetails t WHERE t.cancelDate = :cancelDate")
    , @NamedQuery(name = "TCaseDetails.findByCancelReasonEn", query = "SELECT t FROM TCaseDetails t WHERE t.cancelReasonEn = :cancelReasonEn")})
public class TCaseDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual_fl")
    private long actualFl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "admission_cause_en")
    private String admissionCauseEn;
    
//admissionDate
    @Basic(optional = false)
    @NotNull
    @Column(name = "admission_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    @DateBridge(resolution = Resolution.DAY)
    private Date admissionDate;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "admission_law_en")
    private long admissionLawEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "admission_mode_en")
    private String admissionModeEn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "admission_reason_12_en")
    private String admissionReason12En;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "admission_reason_34_en")
    private String admissionReason34En;
    @Column(name = "admission_weight")
    private BigDecimal admissionWeight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age_days")
    private long ageDays;
    
//ageYears
    @Field(index = Index.YES, store = Store.YES)
    @NumericField
    @Column(name = "age_years")
    private int ageYears;
    
    
    
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "creation_user")
    private BigDecimal creationUser;
    @Size(max = 255)
    @Column(name = "csd_comment")
    private String csdComment;
    @Column(name = "date_of_accident")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAccident;
    @Column(name = "discharge_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dischargeDate;
    @Size(max = 255)
    @Column(name = "discharge_reason_12_en")
    private String dischargeReason12En;
    @Size(max = 255)
    @Column(name = "discharge_reason_3_en")
    private String dischargeReason3En;
    
//hd_icd_code
    @Size(max = 255)
    @Column(name = "hd_icd_code")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES
    ,analyzer = @Analyzer(definition = "CustomAutocompleteAnalyzer")
    )             
    private String hdIcdCode;
    
    
    @Column(name = "hmv")
    private BigDecimal hmv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leave")
    private long leave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "local_fl")
    private long localFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "los")
    private BigDecimal los;
    @Basic(optional = false)
    @NotNull
    @Column(name = "los_alteration")
    private BigDecimal losAlteration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "los_intensiv")
    private long losIntensiv;
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Column(name = "sum_of_icd")
    private BigDecimal sumOfIcd;
    @Column(name = "sum_of_ops")
    private BigDecimal sumOfOps;
    @Size(max = 255)
    @Column(name = "transferring_hosp_ident")
    private String transferringHospIdent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version_number")
    private long versionNumber;
    @Column(name = "cancel_date")
    @Temporal(TemporalType.DATE)
    private Date cancelDate;
    @Column(name = "cancel_reason_en")
    @Temporal(TemporalType.DATE)
    private Date cancelReasonEn;
    
//TCASE    
    @JoinColumn(name = "t_case_id", referencedColumnName = "id")
    @ManyToOne
    @ContainedIn
    private TCase tCaseId;
    
    
    @OneToMany(mappedBy = "parentId")
    private Collection<TCaseDetails> tCaseDetailsCollection;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne
    private TCaseDetails parentId;
    @OneToMany(mappedBy = "externId")
    private Collection<TCaseDetails> tCaseDetailsCollection1;
    @JoinColumn(name = "extern_id", referencedColumnName = "id")
    @ManyToOne
    private TCaseDetails externId;
    
//tCaseDepartmentCollection    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tCaseDetailsId" ,fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
    @IndexedEmbedded
    private Collection<TCaseDepartment> tCaseDepartmentCollection;

    public TCaseDetails() {
    }

    public TCaseDetails(BigDecimal id) {
        this.id = id;
    }

    public TCaseDetails(BigDecimal id, long actualFl, String admissionCauseEn, Date admissionDate, long admissionLawEn, String admissionModeEn, String admissionReason12En, String admissionReason34En, long ageDays, long leave, long localFl, BigDecimal los, BigDecimal losAlteration, long losIntensiv, BigDecimal version, long versionNumber) {
        this.id = id;
        this.actualFl = actualFl;
        this.admissionCauseEn = admissionCauseEn;
        this.admissionDate = admissionDate;
        this.admissionLawEn = admissionLawEn;
        this.admissionModeEn = admissionModeEn;
        this.admissionReason12En = admissionReason12En;
        this.admissionReason34En = admissionReason34En;
        this.ageDays = ageDays;
        this.leave = leave;
        this.localFl = localFl;
        this.los = los;
        this.losAlteration = losAlteration;
        this.losIntensiv = losIntensiv;
        this.version = version;
        this.versionNumber = versionNumber;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public long getActualFl() {
        return actualFl;
    }

    public void setActualFl(long actualFl) {
        this.actualFl = actualFl;
    }

    public String getAdmissionCauseEn() {
        return admissionCauseEn;
    }

    public void setAdmissionCauseEn(String admissionCauseEn) {
        this.admissionCauseEn = admissionCauseEn;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public long getAdmissionLawEn() {
        return admissionLawEn;
    }

    public void setAdmissionLawEn(long admissionLawEn) {
        this.admissionLawEn = admissionLawEn;
    }

    public String getAdmissionModeEn() {
        return admissionModeEn;
    }

    public void setAdmissionModeEn(String admissionModeEn) {
        this.admissionModeEn = admissionModeEn;
    }

    public String getAdmissionReason12En() {
        return admissionReason12En;
    }

    public void setAdmissionReason12En(String admissionReason12En) {
        this.admissionReason12En = admissionReason12En;
    }

    public String getAdmissionReason34En() {
        return admissionReason34En;
    }

    public void setAdmissionReason34En(String admissionReason34En) {
        this.admissionReason34En = admissionReason34En;
    }

    public BigDecimal getAdmissionWeight() {
        return admissionWeight;
    }

    public void setAdmissionWeight(BigDecimal admissionWeight) {
        this.admissionWeight = admissionWeight;
    }

    public long getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(long ageDays) {
        this.ageDays = ageDays;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
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

    public String getCsdComment() {
        return csdComment;
    }

    public void setCsdComment(String csdComment) {
        this.csdComment = csdComment;
    }

    public Date getDateOfAccident() {
        return dateOfAccident;
    }

    public void setDateOfAccident(Date dateOfAccident) {
        this.dateOfAccident = dateOfAccident;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeReason12En() {
        return dischargeReason12En;
    }

    public void setDischargeReason12En(String dischargeReason12En) {
        this.dischargeReason12En = dischargeReason12En;
    }

    public String getDischargeReason3En() {
        return dischargeReason3En;
    }

    public void setDischargeReason3En(String dischargeReason3En) {
        this.dischargeReason3En = dischargeReason3En;
    }

    public String getHdIcdCode() {
        return hdIcdCode;
    }

    public void setHdIcdCode(String hdIcdCode) {
        this.hdIcdCode = hdIcdCode;
    }

    public BigDecimal getHmv() {
        return hmv;
    }

    public void setHmv(BigDecimal hmv) {
        this.hmv = hmv;
    }

    public long getLeave() {
        return leave;
    }

    public void setLeave(long leave) {
        this.leave = leave;
    }

    public long getLocalFl() {
        return localFl;
    }

    public void setLocalFl(long localFl) {
        this.localFl = localFl;
    }

    public BigDecimal getLos() {
        return los;
    }

    public void setLos(BigDecimal los) {
        this.los = los;
    }

    public BigDecimal getLosAlteration() {
        return losAlteration;
    }

    public void setLosAlteration(BigDecimal losAlteration) {
        this.losAlteration = losAlteration;
    }

    public long getLosIntensiv() {
        return losIntensiv;
    }

    public void setLosIntensiv(long losIntensiv) {
        this.losIntensiv = losIntensiv;
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

    public BigDecimal getSumOfIcd() {
        return sumOfIcd;
    }

    public void setSumOfIcd(BigDecimal sumOfIcd) {
        this.sumOfIcd = sumOfIcd;
    }

    public BigDecimal getSumOfOps() {
        return sumOfOps;
    }

    public void setSumOfOps(BigDecimal sumOfOps) {
        this.sumOfOps = sumOfOps;
    }

    public String getTransferringHospIdent() {
        return transferringHospIdent;
    }

    public void setTransferringHospIdent(String transferringHospIdent) {
        this.transferringHospIdent = transferringHospIdent;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(long versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Date getCancelReasonEn() {
        return cancelReasonEn;
    }

    public void setCancelReasonEn(Date cancelReasonEn) {
        this.cancelReasonEn = cancelReasonEn;
    }

    public TCase getTCaseId() {
        return tCaseId;
    }

    public void setTCaseId(TCase tCaseId) {
        this.tCaseId = tCaseId;
    }

    @XmlTransient
    public Collection<TCaseDetails> getTCaseDetailsCollection() {
        return tCaseDetailsCollection;
    }

    public void setTCaseDetailsCollection(Collection<TCaseDetails> tCaseDetailsCollection) {
        this.tCaseDetailsCollection = tCaseDetailsCollection;
    }

    public TCaseDetails getParentId() {
        return parentId;
    }

    public void setParentId(TCaseDetails parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<TCaseDetails> getTCaseDetailsCollection1() {
        return tCaseDetailsCollection1;
    }

    public void setTCaseDetailsCollection1(Collection<TCaseDetails> tCaseDetailsCollection1) {
        this.tCaseDetailsCollection1 = tCaseDetailsCollection1;
    }

    public TCaseDetails getExternId() {
        return externId;
    }

    public void setExternId(TCaseDetails externId) {
        this.externId = externId;
    }

    @XmlTransient
    public Collection<TCaseDepartment> getTCaseDepartmentCollection() {
        return tCaseDepartmentCollection;
    }

    public void setTCaseDepartmentCollection(Collection<TCaseDepartment> tCaseDepartmentCollection) {
        this.tCaseDepartmentCollection = tCaseDepartmentCollection;
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
        if (!(object instanceof TCaseDetails)) {
            return false;
        }
        TCaseDetails other = (TCaseDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TCaseDetails[ id=" + id + " ]";
    }
    
}
