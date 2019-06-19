/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author Khaled Halabieh
 * QueryManager
 */
public class QueryManager {
    
        public static org.apache.lucene.search.Query getGlobalSearch(QueryBuilder qb, Map.Entry<String, Object> entry) {

        org.apache.lucene.search.Query luceneQuery = qb
                .simpleQueryString()
                .onField("csCaseNumber").boostedTo(3)
                .andField("insuranceIdentifier")
                .andField("insuranceNumberPatient")
                .andField("tCaseDetailsCollection.hdIcdCode")
                .andField("tPatientId.patNumber")
                .andField("tPatientId.patFirstName")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdCode")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseIcdCollection.icdcCode.icdDescription")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsCode")
                .andField("tCaseDetailsCollection.tCaseDepartmentCollection.tCaseOpsCollection.opscCode.opsDescription")
                .withAndAsDefaultOperator()
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

    public static org.apache.lucene.search.Query getStringsStartsWithQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField(field)
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();
        return luceneQuery;
    }

    public static org.apache.lucene.search.Query getSimpleQueryString(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {

        org.apache.lucene.search.Query luceneQuery = qb
                .simpleQueryString()
                .onField(field).boostedTo(3)
                .withAndAsDefaultOperator()
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

    public static org.apache.lucene.search.Query getDateQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM.yyyy");
        Date date = null;

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
         Date d1 =null;
         Date d2=null;
        try {
            date = formatter1.parse(entry.getValue().toString());

            start.setTime(date);
            start.set(Calendar.DAY_OF_MONTH, start.getActualMinimum(Calendar.DAY_OF_MONTH));

            end.setTime(date);
            end.set(Calendar.DAY_OF_MONTH, end.getActualMaximum(Calendar.DAY_OF_MONTH));

             d1 = start.getTime();
             d2 = end.getTime();

        } catch (ParseException ex) {
            Logger.getLogger(QueryManager.class.getName()).log(Level.SEVERE, "can't convert to Date", ex);
        }

        org.apache.lucene.search.Query query = qb
                .range()
                .onField(field)
                .from(d1)
                .to(d2)
                .excludeLimit()
                .createQuery();

        return query;

    }

    public static org.apache.lucene.search.Query getIntegerQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .wildcard()
                .onField(field)
                .matching(Integer.parseInt(entry.getValue().toString()))
                .createQuery();
        return luceneQuery;
    }

    public static org.apache.lucene.search.Query getFuzzySearchQuery(QueryBuilder qb, Map.Entry<String, Object> entry, String field) {
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(2)
                .withPrefixLength(2)
                        .withThreshold(.8f )
                //        .withPrefixLength( 1 )
                .onField(field).boostedTo(3)
                .matching(entry.getValue().toString().toLowerCase())
                .createQuery();

        return luceneQuery;
    }

}
