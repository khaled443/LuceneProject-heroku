/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import com.luceneproject.pojo.TCase;
import com.luceneproject.pojo.TCaseDetails;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author Khaled Halabieh
 */
@ManagedBean(name = "fallData")
@RequestScoped


public class FilterView  {

    EntityManagerFactory emff = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");
//      @PersistenceContext(unitName="com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU")
//      private EntityManager em;
//    
    FallLazyDataModel dataModel = new  FallLazyDataModel();


    private String fallNummer;

    private int fallId = 0;
    private String fallNummer2;

 


    public LazyDataModel<Fall> getModel(){
        return dataModel;
    }
    
    public int getDataSize(){
        System.out.println("Data RowCount:  " + dataModel.getRowCount());
        return dataModel.getRowCount();
    }
    
    public String getFallNummer() {
        return fallNummer;
    }

    public void setFallNummer(String fallNummer) {
        this.fallNummer = fallNummer;
    }

    /**
     * Autocomplete for deleting Patient Case
     *
     * @param query
     * @return List of suggestions
     */
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();

        EntityManager em = emff.createEntityManager();
        FullTextEntityManager fullTextEntityManager
                = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        // create native Lucene query unsing the query DSL
        // alternatively you can write the Lucene query using the Lucene query parser
        // or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(TCase.class).get();
        LinkedHashSet<org.apache.lucene.search.Query> filterQueries = new LinkedHashSet<>();

        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField("csCaseNumber")
                .matching(query.toLowerCase())
                .createQuery();

        FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, TCase.class, TCaseDetails.class)
                        .setFirstResult(0)
                        .setMaxResults(5);

        // execute search
        List<TCase> tcases = jpaQuery.getResultList();
        for (TCase t : tcases) {
            results.add(t.getCsCaseNumber());
        }
        em.close();
        return results;
    }

    /**
     * patientenfall durch ihre Fallnummer löschen
     */
    public void deleteFall() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (fallNummer != null) {
            TCase tcase = null;
            EntityManager em = emff.createEntityManager();
            Query deleteQuery = em.createQuery("select t from TCase t where t.csCaseNumber =:cscase", TCase.class)
                    .setParameter("cscase", fallNummer);
            try {
                tcase = (TCase) deleteQuery.getSingleResult();
            } catch (NoResultException e) {
                Logger.getLogger(QueryManager.class.getName()).log(Level.INFO, "can't find TCase with the fall number: " + fallNummer, e);
            }

            if (tcase == null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Patientenfall mit dem Nummer " + fallNummer + " könnte nicht gefunden werden!"));
            } else {
                em.getTransaction().begin();
                em.remove(tcase);
                em.getTransaction().commit();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gelöscht.", "Patientenfall mit dem Nummer " + fallNummer + " wird erfolgreich gelöscht"));
            }
            em.close();
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler", "Bitte wählen Sie ein Patientennummer aus"));

        }

    }

    public void addNewFall() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

        FacesContext context = FacesContext.getCurrentInstance();

        if (fallNummer2 != null && fallId != 0) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            try {
                BigDecimal bd = new BigDecimal(fallId);
                TCase tcase = new TCase();
                tcase.setId(bd);
                tcase.setCsCaseNumber(fallNummer2);
                tcase.setCsHospitalIdent("260101865");
                tcase.setCsCaseTypeEn("DRG");
                tcase.setVersion(BigDecimal.ZERO);
                tcase.setCsStatusEn("NEW");

                tcase.setCancelFl(new Short("0"));
                tcase.setCreationDate(null);
                tcase.setCreationUser(null);
                tcase.setCsBillingDate(null);
                tcase.setCsDoctorIdent(null);
                tcase.setCsFeeGroupEn(null);
                tcase.setCsKisStatusFl(0);
                tcase.setInsuranceIdentifier("000000");
                tcase.setInsuranceNumberPatient("0000000");
                tcase.setModificationDate(null);
                tcase.setModificationUser(null);
                tcase.setTPatientId(null);

                em.persist(tcase);
                em.getTransaction().commit();
            } catch (Exception e) {
            } finally {
                em.close();
                emf.close();
            }

//            em.refresh(tcase);
//            em.flush();
        }

    }

    public int getFallId() {
        return fallId;
    }

    public void setFallId(int fallId) {
        this.fallId = fallId;
    }

    public String getFallNummer2() {
        return fallNummer2;
    }

    public void setFallNummer2(String fallNummer2) {
        this.fallNummer2 = fallNummer2;
    }
    
 
    
}