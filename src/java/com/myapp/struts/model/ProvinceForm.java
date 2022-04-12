/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.myapp.struts.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author willi
 */
public class ProvinceForm extends org.apache.struts.action.ActionForm {

    private List listProvince;

    private String id;
    private String code;
    private String name;
    private String created_by;
    private String date_created;
    private String updated_by;

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
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

    public List getListProvince() {
        return listProvince;
    }

    public void setListProvince(List listProvince) {
        this.listProvince = listProvince;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
