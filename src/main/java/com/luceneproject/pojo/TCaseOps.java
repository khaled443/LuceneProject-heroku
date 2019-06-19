/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "t_case_ops")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCaseOps.findAll", query = "SELECT t FROM TCaseOps t")
    , @NamedQuery(name = "TCaseOps.findById", query = "SELECT t FROM TCaseOps t WHERE t.id = :id")
    , @NamedQuery(name = "TCaseOps.findByCreationDate", query = "SELECT t FROM TCaseOps t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCaseOps.findByCreationUser", query = "SELECT t FROM TCaseOps t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCaseOps.findByModificationDate", query = "SELECT t FROM TCaseOps t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCaseOps.findByModificationUser", query = "SELECT t FROM TCaseOps t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCaseOps.findByOpscDatum", query = "SELECT t FROM TCaseOps t WHERE t.opscDatum = :opscDatum")
    , @NamedQuery(name = "TCaseOps.findByOpscLocEn", query = "SELECT t FROM TCaseOps t WHERE t.opscLocEn = :opscLocEn")
    , @NamedQuery(name = "TCaseOps.findByToGroupFl", query = "SELECT t FROM TCaseOps t WHERE t.toGroupFl = :toGroupFl")
    , @NamedQuery(name = "TCaseOps.findByVersion", query = "SELECT t FROM TCaseOps t WHERE t.version = :version")})
public class TCaseOps implements Serializable {

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
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @Column(name = "modification_user")
    private BigDecimal modificationUser;
    @Column(name = "opsc_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opscDatum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "opsc_loc_en")
    private String opscLocEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_group_fl")
    private long toGroupFl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;

//opscCode    
    @JoinColumn(name = "opsc_code", referencedColumnName = "ops_code")
    @ManyToOne()
    @IndexedEmbedded
    private OpsDe opscCode;

//tCaseDepartment
    @JoinColumn(name = "t_case_department_id", referencedColumnName = "id")
    @ManyToOne
    @ContainedIn
    private TCaseDepartment tCaseDepartmentId;
    
    
    @JoinColumn(name = "t_case_ward_id", referencedColumnName = "id")
    @ManyToOne
    private TCaseWard tCaseWardId;

    public TCaseOps() {
    }

    public TCaseOps(BigDecimal id) {
        this.id = id;
    }

    public TCaseOps(BigDecimal id, String opscLocEn, long toGroupFl, BigDecimal version) {
        this.id = id;
        this.opscLocEn = opscLocEn;
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

    public Date getOpscDatum() {
        return opscDatum;
    }

    public void setOpscDatum(Date opscDatum) {
        this.opscDatum = opscDatum;
    }

    public String getOpscLocEn() {
        return opscLocEn;
    }

    public void setOpscLocEn(String opscLocEn) {
        this.opscLocEn = opscLocEn;
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

    public OpsDe getOpscCode() {
        return opscCode;
    }

    public void setOpscCode(OpsDe opscCode) {
        this.opscCode = opscCode;
    }

    public TCaseDepartment getTCaseDepartmentId() {
        return tCaseDepartmentId;
    }

    public void setTCaseDepartmentId(TCaseDepartment tCaseDepartmentId) {
        this.tCaseDepartmentId = tCaseDepartmentId;
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
        if (!(object instanceof TCaseOps)) {
            return false;
        }
        TCaseOps other = (TCaseOps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TCaseOps[ id=" + id + " ]";
    }
    
}
