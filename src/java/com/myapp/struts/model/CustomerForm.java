/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.myapp.struts.model;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author willi
 */
public class CustomerForm extends org.apache.struts.action.ActionForm {

    private List listCustomer;

    private String id;
    private String name;
    private String full_name;
    private String id_type;
    private String id_number;
    private String id_expiry_date;
    private String gender;
    private String place_of_birth;
    private String city_id;
    private String province_id;
    private String date_of_birth;
    private String age_year;
    private String age_month;
    private String marital_status;
    private String number_of_dependents;
    private String level_of_education;
    private String mother_maiden_name;
    private String spouse_name;
    private String spouse_id_no;
    private String spouse_date_year;
    private String spouse_date_month;
    private String prenuptial_agreemeent;

    private String mailing_address;
    private String residence_address;
    private String r_city_id;
    private String r_province_id;
    private String zip_code;
    private String kelurahan;
    private String kecamatan;
    private String no_home_phone;
    private String no_mobile_phone;
    private String email;
    private String residence_status;
    private String length_of_stay_year;
    private String length_of_stay_month;

    private String date_created;
    private String created_by;
    private String date_last_updated;
    private String updated_by;

    public List getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List listCustomer) {
        this.listCustomer = listCustomer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_expiry_date() {
        return id_expiry_date;
    }

    public void setId_expiry_date(String id_expiry_date) {
        this.id_expiry_date = id_expiry_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAge_year() {
        return age_year;
    }

    public void setAge_year(String age_year) {
        this.age_year = age_year;
    }

    public String getAge_month() {
        return age_month;
    }

    public void setAge_month(String age_month) {
        this.age_month = age_month;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getNumber_of_dependents() {
        return number_of_dependents;
    }

    public void setNumber_of_dependents(String number_of_dependents) {
        this.number_of_dependents = number_of_dependents;
    }

    public String getLevel_of_education() {
        return level_of_education;
    }

    public void setLevel_of_education(String level_of_education) {
        this.level_of_education = level_of_education;
    }

    public String getMother_maiden_name() {
        return mother_maiden_name;
    }

    public void setMother_maiden_name(String mother_maiden_name) {
        this.mother_maiden_name = mother_maiden_name;
    }

    public String getSpouse_name() {
        return spouse_name;
    }

    public void setSpouse_name(String spouse_name) {
        this.spouse_name = spouse_name;
    }

    public String getSpouse_id_no() {
        return spouse_id_no;
    }

    public void setSpouse_id_no(String spouse_id_no) {
        this.spouse_id_no = spouse_id_no;
    }

    public String getSpouse_date_year() {
        return spouse_date_year;
    }

    public void setSpouse_date_year(String spouse_date_year) {
        this.spouse_date_year = spouse_date_year;
    }

    public String getSpouse_date_month() {
        return spouse_date_month;
    }

    public void setSpouse_date_month(String spouse_date_month) {
        this.spouse_date_month = spouse_date_month;
    }

    public String getPrenuptial_agreemeent() {
        return prenuptial_agreemeent;
    }

    public void setPrenuptial_agreemeent(String prenuptial_agreemeent) {
        this.prenuptial_agreemeent = prenuptial_agreemeent;
    }

    public String getMailing_address() {
        return mailing_address;
    }

    public void setMailing_address(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    public String getResidence_address() {
        return residence_address;
    }

    public void setResidence_address(String residence_address) {
        this.residence_address = residence_address;
    }

    public String getR_city_id() {
        return r_city_id;
    }

    public void setR_city_id(String r_city_id) {
        this.r_city_id = r_city_id;
    }

    public String getR_province_id() {
        return r_province_id;
    }

    public void setR_province_id(String r_province_id) {
        this.r_province_id = r_province_id;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNo_home_phone() {
        return no_home_phone;
    }

    public void setNo_home_phone(String no_home_phone) {
        this.no_home_phone = no_home_phone;
    }

    public String getNo_mobile_phone() {
        return no_mobile_phone;
    }

    public void setNo_mobile_phone(String no_mobile_phone) {
        this.no_mobile_phone = no_mobile_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidence_status() {
        return residence_status;
    }

    public void setResidence_status(String residence_status) {
        this.residence_status = residence_status;
    }

    public String getLength_of_stay_year() {
        return length_of_stay_year;
    }

    public void setLength_of_stay_year(String length_of_stay_year) {
        this.length_of_stay_year = length_of_stay_year;
    }

    public String getLength_of_stay_month() {
        return length_of_stay_month;
    }

    public void setLength_of_stay_month(String length_of_stay_month) {
        this.length_of_stay_month = length_of_stay_month;
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
