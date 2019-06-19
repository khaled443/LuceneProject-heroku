/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "icd_de")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IcdDe.findAll", query = "SELECT i FROM IcdDe i")
    , @NamedQuery(name = "IcdDe.findById", query = "SELECT i FROM IcdDe i WHERE i.id = :id")
    , @NamedQuery(name = "IcdDe.findByCreationDate", query = "SELECT i FROM IcdDe i WHERE i.creationDate = :creationDate")
    , @NamedQuery(name = "IcdDe.findByModificationDate", query = "SELECT i FROM IcdDe i WHERE i.modificationDate = :modificationDate")
    , @NamedQuery(name = "IcdDe.findByCountryEn", query = "SELECT i FROM IcdDe i WHERE i.countryEn = :countryEn")
    , @NamedQuery(name = "IcdDe.findByIcdCode", query = "SELECT i FROM IcdDe i WHERE i.icdCode = :icdCode")
    , @NamedQuery(name = "IcdDe.findByIcdIsCompleteFl", query = "SELECT i FROM IcdDe i WHERE i.icdIsCompleteFl = :icdIsCompleteFl")
    , @NamedQuery(name = "IcdDe.findByIcdParentId", query = "SELECT i FROM IcdDe i WHERE i.icdParentId = :icdParentId")
    , @NamedQuery(name = "IcdDe.findByIcdYear", query = "SELECT i FROM IcdDe i WHERE i.icdYear = :icdYear")
    , @NamedQuery(name = "IcdDe.findByIcdDepth", query = "SELECT i FROM IcdDe i WHERE i.icdDepth = :icdDepth")
    , @NamedQuery(name = "IcdDe.findByIcdDescription", query = "SELECT i FROM IcdDe i WHERE i.icdDescription = :icdDescription")
    , @NamedQuery(name = "IcdDe.findByIcdExclusion", query = "SELECT i FROM IcdDe i WHERE i.icdExclusion = :icdExclusion")
    , @NamedQuery(name = "IcdDe.findByIcdInclusion", query = "SELECT i FROM IcdDe i WHERE i.icdInclusion = :icdInclusion")
    , @NamedQuery(name = "IcdDe.findByIcdNote", query = "SELECT i FROM IcdDe i WHERE i.icdNote = :icdNote")})
public class IcdDe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "modification_date")
    @Temporal(TemporalType.DATE)
    private Date modificationDate;
    @Size(max = 25)
    @Column(name = "country_en")
    private String countryEn;
    
//icdCode    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "icd_code")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO
    ,analyzer = @Analyzer(definition = "CustomAutocompleteAnalyzer"))
    private String icdCode;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "icd_is_complete_fl")
    private int icdIsCompleteFl;
    @Column(name = "icd_parent_id")
    private BigInteger icdParentId;
    @Column(name = "icd_year")
    private Integer icdYear;
    @Column(name = "icd_depth")
    private Integer icdDepth;
    
//icdDescription    
    @Size(max = 2147483647)
    @Column(name = "icd_description")      
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO
    ,analyzer = @Analyzer(definition = "CustomTextAnalyzer"))
    private String icdDescription;
    
    
    @Size(max = 2147483647)
    @Column(name = "icd_exclusion")
    private String icdExclusion;
    @Size(max = 2147483647)
    @Column(name = "icd_inclusion")
    private String icdInclusion;
    @Size(max = 2147483647)
    @Column(name = "icd_note")
    private String icdNote;

    public IcdDe() {
    }

    public IcdDe(Integer id) {
        this.id = id;
    }

    public IcdDe(Integer id, String icdCode, int icdIsCompleteFl) {
        this.id = id;
        this.icdCode = icdCode;
        this.icdIsCompleteFl = icdIsCompleteFl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public int getIcdIsCompleteFl() {
        return icdIsCompleteFl;
    }

    public void setIcdIsCompleteFl(int icdIsCompleteFl) {
        this.icdIsCompleteFl = icdIsCompleteFl;
    }

    public BigInteger getIcdParentId() {
        return icdParentId;
    }

    public void setIcdParentId(BigInteger icdParentId) {
        this.icdParentId = icdParentId;
    }

    public Integer getIcdYear() {
        return icdYear;
    }

    public void setIcdYear(Integer icdYear) {
        this.icdYear = icdYear;
    }

    public Integer getIcdDepth() {
        return icdDepth;
    }

    public void setIcdDepth(Integer icdDepth) {
        this.icdDepth = icdDepth;
    }

    public String getIcdDescription() {
        return icdDescription;
    }

    public void setIcdDescription(String icdDescription) {
        this.icdDescription = icdDescription;
    }

    public String getIcdExclusion() {
        return icdExclusion;
    }

    public void setIcdExclusion(String icdExclusion) {
        this.icdExclusion = icdExclusion;
    }

    public String getIcdInclusion() {
        return icdInclusion;
    }

    public void setIcdInclusion(String icdInclusion) {
        this.icdInclusion = icdInclusion;
    }

    public String getIcdNote() {
        return icdNote;
    }

    public void setIcdNote(String icdNote) {
        this.icdNote = icdNote;
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
        if (!(object instanceof IcdDe)) {
            return false;
        }
        IcdDe other = (IcdDe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.IcdDe[ id=" + id + " ]";
    }
    
}
