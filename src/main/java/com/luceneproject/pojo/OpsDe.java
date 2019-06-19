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
@Table(name = "ops_de")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpsDe.findAll", query = "SELECT o FROM OpsDe o")
    , @NamedQuery(name = "OpsDe.findById", query = "SELECT o FROM OpsDe o WHERE o.id = :id")
    , @NamedQuery(name = "OpsDe.findByCreationDate", query = "SELECT o FROM OpsDe o WHERE o.creationDate = :creationDate")
    , @NamedQuery(name = "OpsDe.findByModificationDate", query = "SELECT o FROM OpsDe o WHERE o.modificationDate = :modificationDate")
    , @NamedQuery(name = "OpsDe.findByCountryEn", query = "SELECT o FROM OpsDe o WHERE o.countryEn = :countryEn")
    , @NamedQuery(name = "OpsDe.findByOpsCode", query = "SELECT o FROM OpsDe o WHERE o.opsCode = :opsCode")
    , @NamedQuery(name = "OpsDe.findByOpsIsCompleteFl", query = "SELECT o FROM OpsDe o WHERE o.opsIsCompleteFl = :opsIsCompleteFl")
    , @NamedQuery(name = "OpsDe.findByOpsParentId", query = "SELECT o FROM OpsDe o WHERE o.opsParentId = :opsParentId")
    , @NamedQuery(name = "OpsDe.findByOpsYear", query = "SELECT o FROM OpsDe o WHERE o.opsYear = :opsYear")
    , @NamedQuery(name = "OpsDe.findByOpsDepth", query = "SELECT o FROM OpsDe o WHERE o.opsDepth = :opsDepth")
    , @NamedQuery(name = "OpsDe.findByOpsDescription", query = "SELECT o FROM OpsDe o WHERE o.opsDescription = :opsDescription")
    , @NamedQuery(name = "OpsDe.findByOpsExclusion", query = "SELECT o FROM OpsDe o WHERE o.opsExclusion = :opsExclusion")
    , @NamedQuery(name = "OpsDe.findByOpsInclusion", query = "SELECT o FROM OpsDe o WHERE o.opsInclusion = :opsInclusion")
    , @NamedQuery(name = "OpsDe.findByOpsNote", query = "SELECT o FROM OpsDe o WHERE o.opsNote = :opsNote")})
public class OpsDe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "modification_date")
    @Temporal(TemporalType.DATE)
    private Date modificationDate;
    @Size(max = 25)
    @Column(name = "country_en")
    private String countryEn;
    
//opsCode    
    @Size(max = 15)
    @Column(name = "ops_code")
        @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO
    ,analyzer = @Analyzer(definition = "CustomAutocompleteAnalyzer"))
    private String opsCode;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ops_is_complete_fl")
    private int opsIsCompleteFl;
    @Column(name = "ops_parent_id")
    private BigInteger opsParentId;
    @Column(name = "ops_year")
    private Integer opsYear;
    @Column(name = "ops_depth")
    private Integer opsDepth;
    
//OpsDescription    
    @Size(max = 2147483647)
    @Column(name = "ops_description")
        @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO
    ,analyzer = @Analyzer(definition = "CustomTextAnalyzer"))
    private String opsDescription;
    
    
    @Size(max = 2147483647)
    @Column(name = "ops_exclusion")
    private String opsExclusion;
    @Size(max = 2147483647)
    @Column(name = "ops_inclusion")
    private String opsInclusion;
    @Size(max = 2147483647)
    @Column(name = "ops_note")
    private String opsNote;

    public OpsDe() {
    }

    public OpsDe(Integer id) {
        this.id = id;
    }

    public OpsDe(Integer id, int opsIsCompleteFl) {
        this.id = id;
        this.opsIsCompleteFl = opsIsCompleteFl;
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

    public String getOpsCode() {
        return opsCode;
    }

    public void setOpsCode(String opsCode) {
        this.opsCode = opsCode;
    }

    public int getOpsIsCompleteFl() {
        return opsIsCompleteFl;
    }

    public void setOpsIsCompleteFl(int opsIsCompleteFl) {
        this.opsIsCompleteFl = opsIsCompleteFl;
    }

    public BigInteger getOpsParentId() {
        return opsParentId;
    }

    public void setOpsParentId(BigInteger opsParentId) {
        this.opsParentId = opsParentId;
    }

    public Integer getOpsYear() {
        return opsYear;
    }

    public void setOpsYear(Integer opsYear) {
        this.opsYear = opsYear;
    }

    public Integer getOpsDepth() {
        return opsDepth;
    }

    public void setOpsDepth(Integer opsDepth) {
        this.opsDepth = opsDepth;
    }

    public String getOpsDescription() {
        return opsDescription;
    }

    public void setOpsDescription(String opsDescription) {
        this.opsDescription = opsDescription;
    }

    public String getOpsExclusion() {
        return opsExclusion;
    }

    public void setOpsExclusion(String opsExclusion) {
        this.opsExclusion = opsExclusion;
    }

    public String getOpsInclusion() {
        return opsInclusion;
    }

    public void setOpsInclusion(String opsInclusion) {
        this.opsInclusion = opsInclusion;
    }

    public String getOpsNote() {
        return opsNote;
    }

    public void setOpsNote(String opsNote) {
        this.opsNote = opsNote;
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
        if (!(object instanceof OpsDe)) {
            return false;
        }
        OpsDe other = (OpsDe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.OpsDe[ id=" + id + " ]";
    }
    
}
