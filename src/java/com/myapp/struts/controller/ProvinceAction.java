/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import com.myapp.struts.bean.ProvinceBean;
import com.myapp.struts.model.ProvinceForm;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class ProvinceAction extends org.apache.struts.action.Action {

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
        ProvinceForm provinceForm = (ProvinceForm) form;
        List list = new ArrayList();

//        deklarasi parameter
        String act = request.getParameter("act");

//        FOR CREATE
        if ("create".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO MS_PROVINCE (CODE, NAME, DATE_CREATED, CREATED_BY) VALUES (?, ?, CURRENT_DATE, ?)";
//            System.out.println(provinceForm.getCode()); 
//            execute the query 
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, parseInt(provinceForm.getCode()));
            ps.setString(2, provinceForm.getName());
            ps.setString(3, provinceForm.getCreated_by());

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");

//            FOR DETAIL
        } else if ("detail".equalsIgnoreCase(act)) {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT ID, CODE, NAME, DATE_CREATED, CREATED_BY FROM MS_PROVINCE WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            ProvinceBean provinceBean = new ProvinceBean();
            while (rs.next()) {
                provinceBean.setId(rs.getInt("ID"));
                provinceBean.setCode(rs.getInt("CODE"));
                provinceBean.setName(rs.getString("NAME"));
                provinceBean.setDate_created(rs.getDate("DATE_CREATED"));
                provinceBean.setCreated_by(rs.getString("CREATED_BY"));
            }

//          lempar ke view
            provinceForm.setCode(String.valueOf(provinceBean.getCode()));
            provinceForm.setName(provinceBean.getName());
            provinceForm.setCreated_by(provinceBean.getCreated_by());

            return mapping.findForward("successShowData");

//            FOR DELETE
        } else if ("delete".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM MS_PROVINCE WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");
        } //        FOR FORM UPDATE
        else if ("formUpdate".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT ID, CODE, NAME FROM MS_PROVINCE WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            ProvinceBean provinceBean = new ProvinceBean();
            while (rs.next()) {
                provinceBean.setCode(rs.getInt("CODE"));
                provinceBean.setName(rs.getString("NAME"));
            }

//          lempar ke view
            provinceForm.setCode(String.valueOf(provinceBean.getCode()));
            provinceForm.setName(provinceBean.getName());

            return mapping.findForward("formUpdate");
        } //        FOR UPDATE
        else if ("update".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "UPDATE MS_PROVINCE SET CODE = ? , NAME = ?, DATE_LAST_UPDATED = CURRENT_DATE, UPDATED_BY = ? WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, parseInt(provinceForm.getCode()));
            ps.setString(2, provinceForm.getName());
            ps.setString(3, provinceForm.getUpdated_by());
            ps.setString(4, provinceForm.getId());

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");
        } //            FOR SHOW ALL DATA
        else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement stmt = connection.createStatement();
                String query = "SELECT ID, CODE, NAME FROM MS_PROVINCE ORDER BY ID DESC";
                ResultSet rs = stmt.executeQuery(query);
//            nampilin data ke cmd wildfly
                while (rs.next()) {
//                only show data in cmd when click the menu in web
//                System.out.println(rs.getString("NAME"));
                    ProvinceBean provinceBean = new ProvinceBean();
                    provinceBean.setId(rs.getInt("ID"));
                    provinceBean.setCode(rs.getInt("CODE"));
                    provinceBean.setName(rs.getString("NAME"));
                    list.add(provinceBean);
                }

                provinceForm.setListProvince(list);
                return mapping.findForward(SUCCESS);

            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        return mapping.findForward(FAILED);
    }
}
