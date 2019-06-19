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
import org.hibernate.search.annotations.Store;

/**
 *
 * @author kk
 */
@Entity
@Table(name = "t_patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPatient.findAll", query = "SELECT t FROM TPatient t")
    , @NamedQuery(name = "TPatient.findById", query = "SELECT t FROM TPatient t WHERE t.id = :id")
    , @NamedQuery(name = "TPatient.findByCreationDate", query = "SELECT t FROM TPatient t WHERE t.creationDate = :creationDate")
    , @NamedQuery(name = "TPatient.findByCreationUser", query = "SELECT t FROM TPatient t WHERE t.creationUser = :creationUser")
    , @NamedQuery(name = "TPatient.findByModificationDate", query = "SELECT t FROM TPatient t WHERE t.modificationDate = :modificationDate")
    , @NamedQuery(name = "TPatient.findByModificationUser", query = "SELECT t FROM TPatient t WHERE t.modificationUser = :modificationUser")
    , @NamedQuery(name = "TPatient.findByPatDateOfBirth", query = "SELECT t FROM TPatient t WHERE t.patDateOfBirth = :patDateOfBirth")
    , @NamedQuery(name = "TPatient.findByPatFirstName", query = "SELECT t FROM TPatient t WHERE t.patFirstName = :patFirstName")
    , @NamedQuery(name = "TPatient.findByPatGenderEn", query = "SELECT t FROM TPatient t WHERE t.patGenderEn = :patGenderEn")
    , @NamedQuery(name = "TPatient.findByPatNumber", query = "SELECT t FROM TPatient t WHERE t.patNumber = :patNumber")
    , @NamedQuery(name = "TPatient.findByPatSecName", query = "SELECT t FROM TPatient t WHERE t.patSecName = :patSecName")
    , @NamedQuery(name = "TPatient.findByPatTitle", query = "SELECT t FROM TPatient t WHERE t.patTitle = :patTitle")
    , @NamedQuery(name = "TPatient.findByVersion", query = "SELECT t FROM TPatient t WHERE t.version = :version")})
public class TPatient implements Serializable {

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
    @Column(name = "pat_date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patDateOfBirth;
    
//parFirstName
    @Size(max = 255)
    @Column(name = "pat_first_name")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,
            analyzer = @Analyzer(definition = "CustomNameAnalyzer"))    
    private String patFirstName;
    
    
    @Size(max = 255)
    @Column(name = "pat_gender_en")
    private String patGenderEn;

//patNumber    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pat_number")
        @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,
            analyzer = @Analyzer(definition = "CustomAutocompleteAnalyzer")
    )
    private String patNumber;
    
    @Size(max = 255)
    @Column(name = "pat_sec_name")
    private String patSecName;
    @Size(max = 255)
    @Column(name = "pat_title")
    private String patTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private BigDecimal version;
 
//Tcase    
    @OneToMany(mappedBy = "tPatientId")
    @ContainedIn
    private Collection<TCase> tCaseCollection;

    public TPatient() {
    }

    public TPatient(BigDecimal id) {
        this.id = id;
    }

    public TPatient(BigDecimal id, String patNumber, BigDecimal version) {
        this.id = id;
        this.patNumber = patNumber;
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

    public Date getPatDateOfBirth() {
        return patDateOfBirth;
    }

    public void setPatDateOfBirth(Date patDateOfBirth) {
        this.patDateOfBirth = patDateOfBirth;
    }

    public String getPatFirstName() {
        return patFirstName;
    }

    public void setPatFirstName(String patFirstName) {
        this.patFirstName = patFirstName;
    }

    public String getPatGenderEn() {
        return patGenderEn;
    }

    public void setPatGenderEn(String patGenderEn) {
        this.patGenderEn = patGenderEn;
    }

    public String getPatNumber() {
        return patNumber;
    }

    public void setPatNumber(String patNumber) {
        this.patNumber = patNumber;
    }

    public String getPatSecName() {
        return patSecName;
    }

    public void setPatSecName(String patSecName) {
        this.patSecName = patSecName;
    }

    public String getPatTitle() {
        return patTitle;
    }

    public void setPatTitle(String patTitle) {
        this.patTitle = patTitle;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<TCase> getTCaseCollection() {
        return tCaseCollection;
    }

    public void setTCaseCollection(Collection<TCase> tCaseCollection) {
        this.tCaseCollection = tCaseCollection;
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
        if (!(object instanceof TPatient)) {
            return false;
        }
        TPatient other = (TPatient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.luceneproject.pojo.TPatient[ id=" + id + " ]";
    }
    
}
