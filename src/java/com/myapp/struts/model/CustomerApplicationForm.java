/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.myapp.struts.model;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author willi
 */
public class CustomerApplicationForm extends org.apache.struts.action.ActionForm {

    private List listCustomerApplication;

    private String id;
    private String ref_no;
    private String customer_id;
    private String referral_branch;
    private String date_received;
    private String facility;
    private String application_purpose;
    private String bussiness_source;
    private String media_channel;
    private String fee_branch;
    private String provision_branch;
    private String kckk_branch;
    private String status;
    private String staff_name;
    private String staff_nip;
    private String staff_branch;
    private String staff_account_no;

    private String date_created;
    private String created_by;
    private String date_last_updated;
    private String updated_by;

    public List getListCustomerApplication() {
        return listCustomerApplication;
    }

    public void setListCustomerApplication(List listCustomerApplication) {
        this.listCustomerApplication = listCustomerApplication;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getReferral_branch() {
        return referral_branch;
    }

    public void setReferral_branch(String referral_branch) {
        this.referral_branch = referral_branch;
    }

    public String getDate_received() {
        return date_received;
    }

    public void setDate_received(String date_received) {
        this.date_received = date_received;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getApplication_purpose() {
        return application_purpose;
    }

    public void setApplication_purpose(String application_purpose) {
        this.application_purpose = application_purpose;
    }

    public String getBussiness_source() {
        return bussiness_source;
    }

    public void setBussiness_source(String bussiness_source) {
        this.bussiness_source = bussiness_source;
    }

    public String getMedia_channel() {
        return media_channel;
    }

    public void setMedia_channel(String media_channel) {
        this.media_channel = media_channel;
    }

    public String getFee_branch() {
        return fee_branch;
    }

    public void setFee_branch(String fee_branch) {
        this.fee_branch = fee_branch;
    }

    public String getProvision_branch() {
        return provision_branch;
    }

    public void setProvision_branch(String provision_branch) {
        this.provision_branch = provision_branch;
    }

    public String getKckk_branch() {
        return kckk_branch;
    }

    public void setKckk_branch(String kckk_branch) {
        this.kckk_branch = kckk_branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_nip() {
        return staff_nip;
    }

    public void setStaff_nip(String staff_nip) {
        this.staff_nip = staff_nip;
    }

    public String getStaff_branch() {
        return staff_branch;
    }

    public void setStaff_branch(String staff_branch) {
        this.staff_branch = staff_branch;
    }

    public String getStaff_account_no() {
        return staff_account_no;
    }

    public void setStaff_account_no(String staff_account_no) {
        this.staff_account_no = staff_account_no;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(String date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

}
