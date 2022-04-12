/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsAction.java to edit this template
 */
package com.myapp.struts.controller;

import com.myapp.struts.model.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author willi
 */
public class LoginAction extends org.apache.struts.action.Action {

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
        ActionErrors errors = new ActionErrors();
        LoginForm loginForm = (LoginForm) form;

        if (loginForm != null) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            String userName = ((LoginForm) form).getUser_id();
            String password = (((LoginForm) form).getPassword());
            String query = "SELECT * FROM S_USER WHERE USER_ID = '" + userName + "' and PASSWORD = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(query);
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", rs.getString("USER_ID"));
                session.setAttribute("role", rs.getString("ROLE"));
                return mapping.findForward(SUCCESS);
            } 
            else {
                errors.add("login_error", new ActionMessage("error.login.invalid"));
                return mapping.findForward(FAILED);
            }
        } else {
            return mapping.findForward(FAILED);
        }
    
    }
}
