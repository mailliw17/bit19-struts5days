/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Struts/StrutsActionForm.java to edit this template
 */
package com.myapp.struts.model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author willi
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String user_id;
    private String password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    /**
     *
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUser_id()== null || getUser_id().length() < 1) {
            errors.add("user_id", new ActionMessage("login.error.userid.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        
        if (getPassword()== null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("login.error.password.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
