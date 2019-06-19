/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Khaled Halabieh
 * Lazy loading
 */
public class FallLazyDataModel extends LazyDataModel<Fall> {

    
    public FallLazyDataModel() {
        System.out.println("--------- " + this + " -----------------");
        this.setRowCount(DataService.INSTANCE.getFallsTotalCount());
    }

    @Override
    public List<Fall> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, Object> filters) {
        List<Fall> list = DataService.INSTANCE.getFallsList(first, pageSize, filters);
        if (filters.size() > 0) {
            //set filterSize;
            this.setRowCount(DataService.INSTANCE.getFilteredFallSize());
            System.out.println("yessssss i found a filter");
            System.out.println("*************");
            System.out.println("size of filter is: " + filters.size());
            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                System.out.println("the key is: "+entry.getKey());
                System.out.println("object value is: "+entry.getValue());
                System.out.println("value as string?? "+ entry.getValue().toString());
                System.out.println("");
            }
            System.out.println("****************");

            }else if(filters.size()==0){
                System.out.println("empty?");
                System.out.println(filters.size());
            }
            return list;
        }

    }
