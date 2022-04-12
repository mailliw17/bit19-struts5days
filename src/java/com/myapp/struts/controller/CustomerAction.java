/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import com.myapp.struts.bean.CustomerBean;
import com.myapp.struts.model.CustomerForm;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;

/**
 *
 * @author willi
 */
public class CustomerAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "pst";
    private static final String DB_PASSWORD = "pst";

//    static Connection conn;
//    static Statement stmt;
//    static ResultSet rs;
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        deklarasi variabel
        CustomerForm customerForm = (CustomerForm) form;
        List list = new ArrayList();

//        deklarasi parameter
        String act = request.getParameter("act");

//        FOR CREATE
        if ("create".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO T_CUST(NAME, FULL_NAME, ID_TYPE, ID_NUMBER, ID_EXPIRY_DATE, GENDER, PLACE_OF_BIRTH, CITY_ID, PROVINCE_ID, DATE_OF_BIRTH, AGE_YEAR, AGE_MONTH, MARITAL_STATUS, NUMBER_OF_DEPENDENTS, LEVEL_OF_EDUCATION, MOTHER_MAIDEN_NAME, SPOUSE_NAME, SPOUSE_ID_NO, SPOUSE_DATE_YEAR, SPOUSE_DATE_MONTH, PRENUPTIAL_AGREEMEENT, DATE_CREATED, CREATED_BY, MAILING_ADDRESS, RESIDENCE_ADDRESS, R_CITY_ID, R_PROVINCE_ID, ZIP_CODE, KELURAHAN, KECAMATAN, NO_HOME_PHONE, NO_MOBILE_PHONE, EMAIL, RESIDENCE_STATUS, LENGTH_OF_STAY_YEAR, LENGTH_OF_STAY_MONTH) VALUES (?, ?, ?, ?, CURRENT_DATE, ?, ?, ?, ?, CURRENT_DATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            System.out.println(provinceForm.getCode()); 
//            execute the query 
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, customerForm.getName());
            ps.setString(2, customerForm.getFull_name());
            ps.setString(3, customerForm.getId_type());
            ps.setString(4, customerForm.getId_number());
//            ps.setDate(5, customerForm.getId_expiry_date());
            ps.setString(5, customerForm.getGender());
            ps.setString(6, customerForm.getPlace_of_birth());
            ps.setInt(7, parseInt(customerForm.getCity_id()));
            ps.setInt(8, parseInt(customerForm.getProvince_id()));
//             ps.setDate(9, customerForm.getDate_of_birth());
            ps.setInt(9, parseInt(customerForm.getAge_year()));
            ps.setInt(10, parseInt(customerForm.getAge_month()));
            ps.setString(11, customerForm.getMarital_status());
            ps.setInt(12, parseInt(customerForm.getNumber_of_dependents()));
            ps.setString(13, customerForm.getLevel_of_education());
            ps.setString(14, customerForm.getMother_maiden_name());
            ps.setString(15, customerForm.getSpouse_name());
            ps.setString(16, customerForm.getSpouse_id_no());
            ps.setInt(17, parseInt(customerForm.getSpouse_date_year()));
            ps.setInt(18, parseInt(customerForm.getSpouse_date_month()));
            ps.setString(19, customerForm.getPrenuptial_agreemeent());
            ps.setString(20, customerForm.getCreated_by());
            ps.setString(21, customerForm.getMailing_address());
            ps.setString(22, customerForm.getResidence_address());
            ps.setInt(23, parseInt(customerForm.getR_city_id()));
            ps.setInt(24, parseInt(customerForm.getR_province_id()));
            ps.setInt(25, parseInt(customerForm.getZip_code()));
            ps.setString(26, customerForm.getKelurahan());
            ps.setString(27, customerForm.getKecamatan());
            ps.setInt(28, parseInt(customerForm.getNo_home_phone()));
            ps.setInt(29, parseInt(customerForm.getNo_mobile_phone()));
            ps.setString(30, customerForm.getEmail());
            ps.setString(31, customerForm.getResidence_status());
            ps.setInt(32, parseInt(customerForm.getLength_of_stay_year()));
            ps.setInt(33, parseInt(customerForm.getLength_of_stay_month()));

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");

//            FOR SHOW ALL DATA
        } else if ("detail".equalsIgnoreCase(act)) {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM T_CUST WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            CustomerBean customerBean = new CustomerBean();
            while (rs.next()) {
                customerBean.setId(rs.getInt("ID"));
                customerBean.setName(rs.getString("NAME"));
                customerBean.setFull_name(rs.getString("FULL_NAME"));
                customerBean.setId_type(rs.getString("ID_TYPE"));
                customerBean.setId_number(rs.getString("ID_NUMBER"));
                customerBean.setId_expiry_date(rs.getDate("ID_EXPIRY_DATE"));
                customerBean.setGender(rs.getString("GENDER"));
                customerBean.setPlace_of_birth(rs.getString("PLACE_OF_BIRTH"));
                customerBean.setCity_id(rs.getInt("CITY_ID"));
                customerBean.setProvince_id(rs.getInt("PROVINCE_ID"));
                customerBean.setDate_of_birth(rs.getDate("DATE_OF_BIRTH"));
                customerBean.setAge_year(rs.getInt("AGE_YEAR"));
                customerBean.setAge_month(rs.getInt("AGE_MONTH"));
                customerBean.setMarital_status(rs.getString("MARITAL_STATUS"));
                customerBean.setNumber_of_dependents(rs.getInt("NUMBER_OF_DEPENDENTS"));
                customerBean.setLevel_of_education(rs.getString("LEVEL_OF_EDUCATION"));
                customerBean.setMother_maiden_name(rs.getString("MOTHER_MAIDEN_NAME"));
                customerBean.setSpouse_name(rs.getString("SPOUSE_NAME"));
                customerBean.setSpouse_id_no(rs.getString("SPOUSE_ID_NO"));
                customerBean.setSpouse_date_year(rs.getInt("SPOUSE_DATE_YEAR"));
                customerBean.setSpouse_date_month(rs.getInt("SPOUSE_DATE_MONTH"));
                customerBean.setPrenuptial_agreement(rs.getString("PRENUPTIAL_AGREEMEENT"));
                customerBean.setMailing_address(rs.getString("MAILING_ADDRESS"));
                customerBean.setResidence_address(rs.getString("RESIDENCE_ADDRESS"));
                customerBean.setR_city_id(rs.getInt("R_CITY_ID"));
                customerBean.setR_province_id(rs.getInt("R_PROVINCE_ID"));
                customerBean.setZip_code(rs.getInt("ZIP_CODE"));
                customerBean.setKelurahan("KELURAHAN");
                customerBean.setKecamatan(rs.getString("KECAMATAN"));
                customerBean.setNo_home_phone(rs.getInt("NO_HOME_PHONE"));
                customerBean.setNo_mobile_phone(rs.getInt("NO_MOBILE_PHONE"));
                customerBean.setEmail(rs.getString("EMAIL"));
                customerBean.setResidence_status(rs.getString("RESIDENCE_STATUS"));
                customerBean.setLength_of_stay_year(rs.getInt("LENGTH_OF_STAY_YEAR"));
                customerBean.setLength_of_stay_month(rs.getInt("LENGTH_OF_STAY_MONTH"));
            }

//          lempar ke view
            customerForm.setId(String.valueOf(customerBean.getId()));
            customerForm.setName(customerBean.getName());
            customerForm.setFull_name(customerBean.getFull_name());
            customerForm.setId_type(customerBean.getId_type());
            customerForm.setId_number(customerBean.getId_number());
            customerForm.setId_expiry_date(String.valueOf(customerBean.getId_expiry_date()));
            customerForm.setGender(customerBean.getGender());
            customerForm.setPlace_of_birth(customerBean.getPlace_of_birth());
            customerForm.setCity_id(String.valueOf(customerBean.getCity_id()));
            customerForm.setProvince_id(String.valueOf(customerBean.getProvince_id()));
            customerForm.setDate_of_birth(String.valueOf(customerBean.getDate_of_birth()));
            customerForm.setAge_year(String.valueOf(customerBean.getAge_year()));
            customerForm.setAge_month(String.valueOf(customerBean.getAge_month()));
            customerForm.setMarital_status(customerBean.getMarital_status());
            customerForm.setNumber_of_dependents(String.valueOf(customerBean.getNumber_of_dependents()));
            customerForm.setLevel_of_education(customerBean.getLevel_of_education());
            customerForm.setMother_maiden_name(customerBean.getMother_maiden_name());
            customerForm.setSpouse_name(customerBean.getSpouse_name());
            customerForm.setSpouse_id_no(customerBean.getSpouse_id_no());
            customerForm.setSpouse_date_year(String.valueOf(customerBean.getSpouse_date_year()));
            customerForm.setSpouse_date_month(String.valueOf(customerBean.getSpouse_date_month()));
            customerForm.setPrenuptial_agreemeent(customerBean.getPrenuptial_agreement());
            customerForm.setMailing_address(customerBean.getMailing_address());
            customerForm.setResidence_address(customerBean.getResidence_address());
            customerForm.setR_city_id(String.valueOf(customerBean.getR_city_id()));
            customerForm.setR_province_id(String.valueOf(customerBean.getR_province_id()));
            customerForm.setZip_code(String.valueOf(customerBean.getZip_code()));
            customerForm.setKelurahan(customerBean.getKelurahan());
            customerForm.setKecamatan(customerBean.getKecamatan());
            customerForm.setNo_home_phone(String.valueOf(customerBean.getNo_home_phone()));
            customerForm.setNo_mobile_phone(String.valueOf(customerBean.getNo_mobile_phone()));
            customerForm.setEmail(customerBean.getEmail());
            customerForm.setResidence_status(customerBean.getResidence_status());
            customerForm.setLength_of_stay_year(String.valueOf(customerBean.getLength_of_stay_year()));
            customerForm.setLength_of_stay_month(String.valueOf(customerBean.getLength_of_stay_month()));

            return mapping.findForward("successShowData");

        }//        FOR FORM UPDATE
        else if ("formUpdate".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM T_CUST WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            CustomerBean customerBean = new CustomerBean();
            while (rs.next()) {
                customerBean.setId(rs.getInt("ID"));
                customerBean.setName(rs.getString("NAME"));
                customerBean.setFull_name(rs.getString("FULL_NAME"));
                customerBean.setId_type(rs.getString("ID_TYPE"));
                customerBean.setId_number(rs.getString("ID_NUMBER"));
                customerBean.setId_expiry_date(rs.getDate("ID_EXPIRY_DATE"));
                customerBean.setGender(rs.getString("GENDER"));
                customerBean.setPlace_of_birth(rs.getString("PLACE_OF_BIRTH"));
                customerBean.setCity_id(rs.getInt("CITY_ID"));
                customerBean.setProvince_id(rs.getInt("PROVINCE_ID"));
                customerBean.setDate_of_birth(rs.getDate("DATE_OF_BIRTH"));
                customerBean.setAge_year(rs.getInt("AGE_YEAR"));
                customerBean.setAge_month(rs.getInt("AGE_MONTH"));
                customerBean.setMarital_status(rs.getString("MARITAL_STATUS"));
                customerBean.setNumber_of_dependents(rs.getInt("NUMBER_OF_DEPENDENTS"));
                customerBean.setLevel_of_education(rs.getString("LEVEL_OF_EDUCATION"));
                customerBean.setMother_maiden_name(rs.getString("MOTHER_MAIDEN_NAME"));
                customerBean.setSpouse_name(rs.getString("SPOUSE_NAME"));
                customerBean.setSpouse_id_no(rs.getString("SPOUSE_ID_NO"));
                customerBean.setSpouse_date_year(rs.getInt("SPOUSE_DATE_YEAR"));
                customerBean.setSpouse_date_month(rs.getInt("SPOUSE_DATE_MONTH"));
                customerBean.setPrenuptial_agreement(rs.getString("PRENUPTIAL_AGREEMEENT"));
                customerBean.setMailing_address(rs.getString("MAILING_ADDRESS"));
                customerBean.setResidence_address(rs.getString("RESIDENCE_ADDRESS"));
                customerBean.setR_city_id(rs.getInt("R_CITY_ID"));
                customerBean.setR_province_id(rs.getInt("R_PROVINCE_ID"));
                customerBean.setZip_code(rs.getInt("ZIP_CODE"));
                customerBean.setKelurahan("KELURAHAN");
                customerBean.setKecamatan(rs.getString("KECAMATAN"));
                customerBean.setNo_home_phone(rs.getInt("NO_HOME_PHONE"));
                customerBean.setNo_mobile_phone(rs.getInt("NO_MOBILE_PHONE"));
                customerBean.setEmail(rs.getString("EMAIL"));
                customerBean.setResidence_status(rs.getString("RESIDENCE_STATUS"));
                customerBean.setLength_of_stay_year(rs.getInt("LENGTH_OF_STAY_YEAR"));
                customerBean.setLength_of_stay_month(rs.getInt("LENGTH_OF_STAY_MONTH"));
            }

//          lempar ke view
            customerForm.setId(String.valueOf(customerBean.getId()));
            customerForm.setName(customerBean.getName());
            customerForm.setFull_name(customerBean.getFull_name());
            customerForm.setId_type(customerBean.getId_type());
            customerForm.setId_number(customerBean.getId_number());
            customerForm.setId_expiry_date(String.valueOf(customerBean.getId_expiry_date()));
            customerForm.setGender(customerBean.getGender());
            customerForm.setPlace_of_birth(customerBean.getPlace_of_birth());
            customerForm.setCity_id(String.valueOf(customerBean.getCity_id()));
            customerForm.setProvince_id(String.valueOf(customerBean.getProvince_id()));
            customerForm.setDate_of_birth(String.valueOf(customerBean.getDate_of_birth()));
            customerForm.setAge_year(String.valueOf(customerBean.getAge_year()));
            customerForm.setAge_month(String.valueOf(customerBean.getAge_month()));
            customerForm.setMarital_status(customerBean.getMarital_status());
            customerForm.setNumber_of_dependents(String.valueOf(customerBean.getNumber_of_dependents()));
            customerForm.setLevel_of_education(customerBean.getLevel_of_education());
            customerForm.setMother_maiden_name(customerBean.getMother_maiden_name());
            customerForm.setSpouse_name(customerBean.getSpouse_name());
            customerForm.setSpouse_id_no(customerBean.getSpouse_id_no());
            customerForm.setSpouse_date_year(String.valueOf(customerBean.getSpouse_date_year()));
            customerForm.setSpouse_date_month(String.valueOf(customerBean.getSpouse_date_month()));
            customerForm.setPrenuptial_agreemeent(customerBean.getPrenuptial_agreement());
            customerForm.setMailing_address(customerBean.getMailing_address());
            customerForm.setResidence_address(customerBean.getResidence_address());
            customerForm.setR_city_id(String.valueOf(customerBean.getR_city_id()));
            customerForm.setR_province_id(String.valueOf(customerBean.getR_province_id()));
            customerForm.setZip_code(String.valueOf(customerBean.getZip_code()));
            customerForm.setKelurahan(customerBean.getKelurahan());
            customerForm.setKecamatan(customerBean.getKecamatan());
            customerForm.setNo_home_phone(String.valueOf(customerBean.getNo_home_phone()));
            customerForm.setNo_mobile_phone(String.valueOf(customerBean.getNo_mobile_phone()));
            customerForm.setEmail(customerBean.getEmail());
            customerForm.setResidence_status(customerBean.getResidence_status());
            customerForm.setLength_of_stay_year(String.valueOf(customerBean.getLength_of_stay_year()));
            customerForm.setLength_of_stay_month(String.valueOf(customerBean.getLength_of_stay_month()));

            return mapping.findForward("formUpdate");
        } else if ("update".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "UPDATE T_CUST SET NAME = ?, FULL_NAME = ?, ID_TYPE = ?, ID_NUMBER = ?, ID_EXPIRY_DATE = CURRENT_DATE, GENDER = ?, PLACE_OF_BIRTH = ?, CITY_ID = ?, PROVINCE_ID = ?, DATE_OF_BIRTH = CURRENT_DATE, AGE_YEAR = ?, AGE_MONTH = ?, MARITAL_STATUS = ?, NUMBER_OF_DEPENDENTS = ?, LEVEL_OF_EDUCATION = ?, MOTHER_MAIDEN_NAME = ?, SPOUSE_NAME = ?, SPOUSE_ID_NO = ?, SPOUSE_DATE_YEAR = ?, SPOUSE_DATE_MONTH = ?, PRENUPTIAL_AGREEMEENT = ?, MAILING_ADDRESS = ?, RESIDENCE_ADDRESS = ?, R_CITY_ID = ?, R_PROVINCE_ID = ?, ZIP_CODE = ?, KELURAHAN = ?, KECAMATAN = ?, NO_HOME_PHONE = ?, NO_MOBILE_PHONE = ?, EMAIL = ?, RESIDENCE_STATUS = ?, LENGTH_OF_STAY_YEAR = ?, LENGTH_OF_STAY_MONTH = ?, DATE_LAST_UPDATED = CURRENT_DATE, UPDATED_BY = ? WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, customerForm.getName());
            ps.setString(2, customerForm.getFull_name());
            ps.setString(3, customerForm.getId_type());
            ps.setString(4, customerForm.getId_number());
//            ps.setDate(5, customerForm.getId_expiry_date());
            ps.setString(5, customerForm.getGender());
            ps.setString(6, customerForm.getPlace_of_birth());
            ps.setInt(7, parseInt(customerForm.getCity_id()));
            ps.setInt(8, parseInt(customerForm.getProvince_id()));
//             ps.setDate(9, customerForm.getDate_of_birth());
            ps.setInt(9, parseInt(customerForm.getAge_year()));
            ps.setInt(10, parseInt(customerForm.getAge_month()));
            ps.setString(11, customerForm.getMarital_status());
            ps.setInt(12, parseInt(customerForm.getNumber_of_dependents()));
            ps.setString(13, customerForm.getLevel_of_education());
            ps.setString(14, customerForm.getMother_maiden_name());
            ps.setString(15, customerForm.getSpouse_name());
            ps.setString(16, customerForm.getSpouse_id_no());
            ps.setInt(17, parseInt(customerForm.getSpouse_date_year()));
            ps.setInt(18, parseInt(customerForm.getSpouse_date_month()));
            ps.setString(19, customerForm.getPrenuptial_agreemeent());                    
            ps.setString(20, customerForm.getMailing_address());
            ps.setString(21, customerForm.getResidence_address());
            ps.setInt(22, parseInt(customerForm.getR_city_id()));
            ps.setInt(23, parseInt(customerForm.getR_province_id()));
            ps.setInt(24, parseInt(customerForm.getZip_code()));
            ps.setString(25, customerForm.getKelurahan());
            ps.setString(26, customerForm.getKecamatan());
            ps.setInt(27, parseInt(customerForm.getNo_home_phone()));
            ps.setInt(28, parseInt(customerForm.getNo_mobile_phone()));
            ps.setString(29, customerForm.getEmail());
            ps.setString(30, customerForm.getResidence_status());
            ps.setInt(31, parseInt(customerForm.getLength_of_stay_year()));
            ps.setInt(32, parseInt(customerForm.getLength_of_stay_month()));
            ps.setString(33, customerForm.getUpdated_by());
            ps.setInt(34, parseInt(customerForm.getId()));
            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");
        } //            FOR SHOW ALL DATA
        else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement stmt = connection.createStatement();
                String query = "SELECT ID, FULL_NAME, RESIDENCE_ADDRESS, ID_TYPE, ID_NUMBER, DATE_OF_BIRTH FROM T_CUST ORDER BY ID DESC";
                ResultSet rs = stmt.executeQuery(query);
//            nampilin data ke cmd wildfly
                while (rs.next()) {
//                only show data in cmd when click the menu in web
                    System.out.println(rs.getString("FULL_NAME"));
                    CustomerBean customerBean = new CustomerBean();
                    customerBean.setId(rs.getInt("ID"));
                    customerBean.setFull_name(rs.getString("FULL_NAME"));
                    customerBean.setResidence_address(rs.getString("RESIDENCE_ADDRESS"));
                    customerBean.setId_type(rs.getString("ID_TYPE"));
                    customerBean.setId_number(rs.getString("ID_NUMBER"));
                    customerBean.setDate_of_birth(rs.getDate("DATE_OF_BIRTH"));
                    list.add(customerBean);
                }
                System.out.println(list.size());
                customerForm.setListCustomer(list);
                return mapping.findForward(SUCCESS);

            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        return mapping.findForward(FAILED);
    }
}
