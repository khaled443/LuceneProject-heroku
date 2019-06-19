/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.Index;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.batchindexing.MassIndexerProgressMonitor;
import com.luceneproject.pojo.*;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.search.batchindexing.impl.SimpleIndexingProgressMonitor;

/**
 * 6.3.2. Using a MassIndexer
 *
 * @author Khaled Halabieh
 *
 *Reindex all Entities
 */
public class Index {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("com.luceneProject_LuceneProject_war_1.0-SNAPSHOTPU");

    public static void main(String[] args) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        //Monitor the process bar
        MassIndexerProgressMonitor monitor = new SimpleIndexingProgressMonitor();

        //calculate total entities size     
        Map<String, Integer> totalSize = new HashMap<String, Integer>();      
        totalSize.put(TCase.class.getSimpleName(), getTableRowsCount(TCase.class.getSimpleName())*3);
        totalSize.put(TCaseDetails.class.getSimpleName(), getTableRowsCount(TCaseDetails.class.getSimpleName())*3);
        totalSize.put(TPatient.class.getSimpleName(), getTableRowsCount(TPatient.class.getSimpleName())*2);
        totalSize.put(IcdDe.class.getSimpleName(), getTableRowsCount(IcdDe.class.getSimpleName()));
        totalSize.put(OpsDe.class.getSimpleName(), getTableRowsCount(OpsDe.class.getSimpleName()));
        
        System.out.println("Total size of entities: ");
        int total=0;
        for (Map.Entry table: totalSize.entrySet()) {
            System.out.println(table.getKey()+ ": "+table.getValue());
            total+=(Integer)table.getValue();
        }
        System.out.println("total of: "+total);

        
        FullTextSession fullTextSession = Search.getFullTextSession(em.unwrap(Session.class));
        
        try {
            fullTextSession.createIndexer(TCase.class).progressMonitor(monitor)
                    
                    .startAndWait();

        } catch (InterruptedException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, "Error occurred while Indexing!", ex);

        } finally {
            em.close();
            ENTITY_MANAGER_FACTORY.close();
        }
    }

    public static int getTableRowsCount(String table) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        int count = ((Number) em
                .createQuery(
                        "select count(b) "
                        + "from " + table + " b")
                .getSingleResult()).intValue();
        em.close();
        return count;
    }
}
