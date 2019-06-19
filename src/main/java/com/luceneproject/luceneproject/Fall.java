/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luceneproject.luceneproject;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 *
 * @author Khaled Halabieh
 * Create Fall Objects
 */
public class Fall implements Serializable {

    //Tcase
    String cs_case_number;
    String insurance_identifier;
    String insurance_number_patient;


    //TCase_details
    //one to Many
    LinkedHashSet<String> hd_icd_code;
    LinkedHashSet<Integer> age_years;
    LinkedHashSet<Date> admisstion_date;
    
    //T_Patient 
    //Many to one
    String pat_number;
    String pat_first_name;
    
    //T_Case_icd
    //one to many
    LinkedHashSet<String> icdcCode;
    
    //T_Case_ops
    //one to many
    LinkedHashSet<String> opscCode;
    
    //icd_de
    //one to many
    LinkedHashSet<String> ICD_DESCRIPTION;

    
    //ops_de
    //one to many
    LinkedHashSet<String> OPS_DESCRIPTION;
    

    public Fall() {

    }

    public Fall(String cs_case_number) {
        this.cs_case_number = cs_case_number;
    }

    public Fall(String cs_case_number, String insurance_identifier, 
            String insurance_number_patient, LinkedHashSet<String> hd_icd_code, 
            LinkedHashSet<Integer> age_years, LinkedHashSet<Date> admisstion_date,
            String pat_number ,String pat_first_name ,LinkedHashSet<String> icdcCode, LinkedHashSet<String> opscCode
            ,LinkedHashSet<String> ICD_DESCRIPTION, LinkedHashSet<String> OPS_DESCRIPTION) {
        
        this.cs_case_number = cs_case_number;
        this.insurance_identifier = insurance_identifier;
        this.insurance_number_patient = insurance_number_patient;
        this.hd_icd_code = hd_icd_code;
        this.age_years = age_years;
        this.admisstion_date = admisstion_date;
        
        this.pat_number=pat_number;
        this.pat_first_name=  pat_first_name;
        
        this.icdcCode=icdcCode;
        this.opscCode=opscCode;
        this.ICD_DESCRIPTION=ICD_DESCRIPTION;
        this.OPS_DESCRIPTION=OPS_DESCRIPTION;
    }

    public String getCs_case_number() {
        return cs_case_number;
    }

    public void setCs_case_number(String cs_case_number) {
        this.cs_case_number = cs_case_number;
    }



    public String getInsurance_identifier() {
        return insurance_identifier;
    }

    public void setInsurance_identifier(String insurance_identifier) {
        this.insurance_identifier = insurance_identifier;
    }

    public String getInsurance_number_patient() {
        return insurance_number_patient;
    }

    public void setInsurance_number_patient(String insurance_number_patient) {
        this.insurance_number_patient = insurance_number_patient;
    }

    public LinkedHashSet<String> getHd_icd_code() {
        return hd_icd_code;
    }

    public void setHd_icd_code(LinkedHashSet<String> hd_icd_code) {
        this.hd_icd_code = hd_icd_code;
    }

    public LinkedHashSet<Integer> getAge_years() {
        return age_years;
    }

    public void setAge_years(LinkedHashSet<Integer> age_years) {
        this.age_years = age_years;
    }

    public LinkedHashSet<Date> getAdmisstion_date() {
        return admisstion_date;
    }

    public void setAdmisstion_date(LinkedHashSet<Date> admisstion_date) {
        this.admisstion_date = admisstion_date;
    }

    public String getPat_number() {
        return pat_number;
    }

    public void setPat_number(String pat_number) {
        this.pat_number = pat_number;
    }

    public String getPat_first_name() {
        return pat_first_name;
    }

    public void setPat_first_name(String pat_first_name) {
        this.pat_first_name = pat_first_name;
    }

    public LinkedHashSet<String> getIcdcCode() {
        return icdcCode;
    }

    public void setIcdcCode(LinkedHashSet<String> icdcCode) {
        this.icdcCode = icdcCode;
    }

    public LinkedHashSet<String> getOpscCode() {
        return opscCode;
    }

    public void setOpscCode(LinkedHashSet<String> opscCode) {
        this.opscCode = opscCode;
    }

    public LinkedHashSet<String> getICD_DESCRIPTION() {
        return ICD_DESCRIPTION;
    }

    public void setICD_DESCRIPTION(LinkedHashSet<String> ICD_DESCRIPTION) {
        this.ICD_DESCRIPTION = ICD_DESCRIPTION;
    }

    public LinkedHashSet<String> getOPS_DESCRIPTION() {
        return OPS_DESCRIPTION;
    }

    public void setOPS_DESCRIPTION(LinkedHashSet<String> OPS_DESCRIPTION) {
        this.OPS_DESCRIPTION = OPS_DESCRIPTION;
    }
    
      @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.cs_case_number != null ? this.cs_case_number.hashCode() : 0);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Fall other = (Fall) obj;
        if ((this.cs_case_number == null) ? (other.cs_case_number != null) : !this.cs_case_number.equals(other.cs_case_number)) {
            return false;
        }
        return true;
    }

}
