/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import com.myapp.struts.bean.CustomerApplicationBean;
import com.myapp.struts.model.CustomerApplicationForm;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author willi
 */
public class CustomerApplicationAction extends org.apache.struts.action.Action {

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
        CustomerApplicationForm customerApplicationForm = (CustomerApplicationForm) form;
        List list = new ArrayList();

//        deklarasi parameter
        String act = request.getParameter("act");

        //        FOR CREATE
        if ("create".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO T_APPLICATION (REF_NO, CUSTOMER_ID, REFERRAL_BRANCH, DATE_RECEIVED, FACILITY, APPLICATION_PURPOSE,BUSSINESS_SOURCE, MEDIA_CHANNEL, FEE_BRANCH, PROVISION_BRANCH, KCKK_BRANCH,STATUS, STAFF_NAME,STAFF_NIP, STAFF_BRANCH, STAFF_ACCOUNT_NO ,DATE_CREATED, CREATED_BY) VALUES (DBMS_RANDOM.VALUE, ?, ?,CURRENT_DATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customerApplicationForm.getCustomer_id()); //customer_id
            ps.setString(2, customerApplicationForm.getReferral_branch());
            ps.setString(3, customerApplicationForm.getFacility());
            ps.setString(4, customerApplicationForm.getApplication_purpose());
            ps.setString(5, customerApplicationForm.getBussiness_source());
            ps.setString(6, customerApplicationForm.getMedia_channel());
            ps.setString(7, customerApplicationForm.getFee_branch());
            ps.setString(8, customerApplicationForm.getProvision_branch());
            ps.setString(9, customerApplicationForm.getKckk_branch());
            ps.setString(10, customerApplicationForm.getStatus());
            ps.setString(11, customerApplicationForm.getStaff_name());
            ps.setString(12, customerApplicationForm.getStaff_nip());
            ps.setString(13, customerApplicationForm.getStaff_branch());
            ps.setString(14, customerApplicationForm.getStaff_account_no());
            ps.setString(15, customerApplicationForm.getCreated_by());

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");

        } else {
//        FOR SHOW ALL DATA BY KONSUMEN_ID
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement stmt = connection.createStatement();
                String query = "SELECT * FROM T_APPLICATION WHERE CUSTOMER_ID = ?";
                PreparedStatement ps = connection.prepareStatement(query);

                int id = parseInt(request.getParameter("id"));
//            ambil inputan dari parameter id
                ps.setInt(1, id);
                System.out.println(id);
                System.out.println(query);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CustomerApplicationBean customerApplicationBean = new CustomerApplicationBean();
                    customerApplicationBean.setId(rs.getInt("ID"));
                    customerApplicationBean.setRef_no(rs.getString("REF_NO"));
                    customerApplicationBean.setCustomer_id(rs.getInt("CUSTOMER_ID"));
                    customerApplicationBean.setReferral_branch(rs.getString("REFERRAL_BRANCH"));
                    customerApplicationBean.setDate_received(rs.getDate("DATE_RECEIVED"));
                    customerApplicationBean.setFacility(rs.getString("FACILITY"));
                    customerApplicationBean.setApplication_purpose(rs.getString("APPLICATION_PURPOSE"));
                    customerApplicationBean.setBussiness_source(rs.getString("BUSSINESS_SOURCE"));
                    customerApplicationBean.setMedia_channel(rs.getString("MEDIA_CHANNEL"));
                    customerApplicationBean.setFee_branch(rs.getString("FEE_BRANCH"));
                    customerApplicationBean.setProvision_branch(rs.getString("PROVISION_BRANCH"));
                    customerApplicationBean.setKckk_branch(rs.getString("KCKK_BRANCH"));
                    customerApplicationBean.setStatus(rs.getString("STATUS"));
                    customerApplicationBean.setStaff_name(rs.getString("STAFF_NAME"));
                    customerApplicationBean.setStaff_nip(rs.getString("STAFF_NIP"));
                    customerApplicationBean.setStaff_branch(rs.getString("STAFF_BRANCH"));
                    customerApplicationBean.setStaff_account_no(rs.getString("STAFF_ACCOUNT_NO"));
                    customerApplicationBean.setCreated_by(rs.getString("CREATED_BY"));

                    list.add(customerApplicationBean);
                }

                customerApplicationForm.setListCustomerApplication(list);
                return mapping.findForward(SUCCESS);

            } catch (Exception e) {
                e.getStackTrace();
            }

        }
        return mapping.findForward(FAILED);
    }
}
