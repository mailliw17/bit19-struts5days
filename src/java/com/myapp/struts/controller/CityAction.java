/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import com.myapp.struts.bean.CityBean;
import com.myapp.struts.model.CityForm;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class CityAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USERNAME = "pst";
    private static final String DB_PASSWORD = "pst";

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
        CityForm cityForm = (CityForm) form;
        List list = new ArrayList();

//        deklarasi parameter
        String act = request.getParameter("act");
//        FOR CREATE
        if ("create".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO MS_CITY (PROVINCE_ID, CODE, NAME, DATE_CREATED, CREATED_BY) VALUES (?, ?, ?, CURRENT_DATE, ?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, cityForm.getProvince_id());
            ps.setInt(2, cityForm.getCode());
            ps.setString(3, cityForm.getName());
            ps.setString(4, cityForm.getCreated_by());

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");

//            FOR DELETE
        } else if ("delete".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM MS_CITY WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");
        }
//        FOR DETAIL
        else if ("detail".equalsIgnoreCase(act)) {
         Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT ID, PROVINCE_ID, CODE, NAME, DATE_CREATED, CREATED_BY FROM MS_CITY WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            CityBean cityBean = new CityBean();
            while (rs.next()) {
                cityBean.setId(rs.getInt("ID"));
                cityBean.setProvince_id(rs.getInt("PROVINCE_ID"));
                cityBean.setCode(rs.getInt("CODE"));
                cityBean.setName(rs.getString("NAME"));
                cityBean.setDate_created(rs.getDate("DATE_CREATED"));
                cityBean.setCreated_by(rs.getString("CREATED_BY"));
            }

//          lempar ke view
            cityForm.setProvince_id(cityBean.getProvince_id());
            cityForm.setCode(cityBean.getCode());
            cityForm.setName(cityBean.getName());
            cityForm.setCreated_by(cityBean.getCreated_by());

            return mapping.findForward("successShowData");
        }//        FOR FORM UPDATE
        else if ("formUpdate".equalsIgnoreCase(act)) {
             Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "SELECT ID, PROVINCE_ID, CODE, NAME FROM MS_CITY WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

//            ambil inputan dari parameter id
            String id = request.getParameter("id");
            ps.setString(1, id);

//            execute query
            ResultSet rs;
            rs = ps.executeQuery();
            CityBean cityBean = new CityBean();
            while (rs.next()) {
                cityBean.setProvince_id(rs.getInt("PROVINCE_ID"));
                cityBean.setCode(rs.getInt("CODE"));
                cityBean.setName(rs.getString("NAME"));
            }

//          lempar ke view
            cityForm.setProvince_id(cityBean.getProvince_id());
            cityForm.setCode(cityBean.getCode());
            cityForm.setName(cityBean.getName());

            return mapping.findForward("formUpdate");
        }else if ("update".equalsIgnoreCase(act)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String query = "UPDATE MS_CITY SET PROVINCE_ID = ?, CODE = ? , NAME = ?, DATE_LAST_UPDATED = CURRENT_DATE, UPDATED_BY = ? WHERE ID = ?";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, cityForm.getProvince_id());
            ps.setInt(2, cityForm.getCode());
            ps.setString(3, cityForm.getName());
            ps.setString(4, cityForm.getUpdated_by());
            ps.setInt(5, cityForm.getId());

            int affectedRow = ps.executeUpdate();
            System.out.println("Affected rows : " + affectedRow);

            return mapping.findForward("successChangeData");
        }
        else {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement stmt = connection.createStatement();
                String query = "SELECT ID, PROVINCE_ID, CODE, NAME FROM MS_CITY ORDER BY ID DESC";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    CityBean cityBean = new CityBean();
                    cityBean.setId(rs.getInt("ID"));
                    cityBean.setProvince_id(rs.getInt("PROVINCE_ID"));
                    cityBean.setCode(rs.getInt("CODE"));
                    cityBean.setName(rs.getString("NAME"));
                    list.add(cityBean);
                }

                cityForm.setListCity(list);
                return mapping.findForward(SUCCESS);

            } catch (Exception e) {
                e.getStackTrace();
            }
        }

        return mapping.findForward(FAILED);
    }
}
