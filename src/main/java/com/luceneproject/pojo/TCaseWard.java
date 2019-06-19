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

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_case_ward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCaseWard.findAll", query = "SELECT t FROM TCaseWard t")
    , @NamedQuery(name = "TCaseWard.findById", query = "SELECT t FROM TCaseWard t WHERE t.id = :id")
    , @NamedQuery(name = "TCaseWard.findByCreationDate", query = "SELECT t FROM TCaseWard t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TCaseWard.findByCreationUser", query = "SELECT t FROM TCaseWard t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TCaseWard.findByModificationDate", query = "SELECT t FROM TCaseWard t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TCaseWard.findByModificationUser", query = "SELECT t FROM TCaseWard t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TCaseWard.findByVersion", query = "SELECT t FROM TCaseWard t WHERE t.version = :version")
    , @NamedQuery(name = "TCaseWard.findByWardcAdmdate", query = "SELECT t FROM TCaseWard t WHERE t.wardcAdmdate = :wardcAdmdate")
    , @NamedQuery(name = "TCaseWard.findByWardcDisdate", query = "SELECT t FROM TCaseWard t WHERE t.wardcDisdate = :wardcDisdate")
    , @NamedQuery(name = "TCaseWard.findByWardcIdent", query = "SELECT t FROM TCaseWard t WHERE t.wardcIdent = :wardcIdent")})
public class TCaseWard implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
    @Column(name = "wardc_admdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date wardcAdmdate;
    @Column(name = "wardc_disdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date wardcDisdate;
    @Size(max = 255)
    @Column(name = "wardc_ident")
    private String wardcIdent;
    @OneToMany(mappedBy = "tCaseWardId")
    private Collection<TCaseIcd> tCaseIcdCollection;
    @JoinColumn(name = "t_case_department_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TCaseDepartment tCaseDepartmentId;
    @OneToMany(mappedBy = "tCaseWardId")
    private Collection<TCaseOps> tCaseOpsCollection;

    public TCaseWard() {
    }

    public TCaseWard(BigDecimal id) {
        this.id = id;
    }

    public TCaseWard(BigDecimal id, BigDecimal version) {
        this.id = id;
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

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Date getWardcAdmdate() {
        return wardcAdmdate;
    }

    public void setWardcAdmdate(Date wardcAdmdate) {
        this.wardcAdmdate = wardcAdmdate;
    }

    public Date getWardcDisdate() {
        return wardcDisdate;
    }

    public void setWardcDisdate(Date wardcDisdate) {
        this.wardcDisdate = wardcDisdate;
    }

    public String getWardcIdent() {
        return wardcIdent;
    }

    public void setWardcIdent(String wardcIdent) {
        this.wardcIdent = wardcIdent;
    }

    @XmlTransient
    public Collection<TCaseIcd> getTCaseIcdCollection() {
        return tCaseIcdCollection;
    }

    public void setTCaseIcdCollection(Collection<TCaseIcd> tCaseIcdCollection) {
        this.tCaseIcdCollection = tCaseIcdCollection;
    }

    public TCaseDepartment getTCaseDepartmentId() {
        return tCaseDepartmentId;
    }

    public void setTCaseDepartmentId(TCaseDepartment tCaseDepartmentId) {
        this.tCaseDepartmentId = tCaseDepartmentId;
    }

    @XmlTransient
    public Collection<TCaseOps> getTCaseOpsCollection() {
        return tCaseOpsCollection;
    }

    public void setTCaseOpsCollection(Collection<TCaseOps> tCaseOpsCollection) {
        this.tCaseOpsCollection = tCaseOpsCollection;
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
        if (!(object instanceof TCaseWard)) {
            return false;
        }
        TCaseWard other = (TCaseWard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TCaseWard[ id=" + id + " ]";
    }
    
}
