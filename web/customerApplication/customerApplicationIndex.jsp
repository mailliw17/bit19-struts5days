<%-- 
    Document   : provinceIndex
    Created on : Apr 7, 2022, 11:52:26 AM
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Application List</title>
    </head>
    <body>
        <a href="customer-action.do"><---Back</a>
        <h1>Customer Application List</h1>
        <a href="customerApplication/createCustomerApplication.jsp?id=<bean:write name="customerApplicationForm" property="id"/>">Add</a>
        <hr>
        <table>
            <thead>
                <tr style="background-color: #E0E0E1;">
                    <th>Ref No.</th>
                    <th>Date Created</th>
                    <th>Creator</th>
                    <th>Status</th>
                    <th>Hold By</th>
                </tr>
            </thead>
            <logic:iterate id="u" name="customerApplicationForm" property="listCustomerApplication">
                <tr>
                    <td> <bean:write name="u" property="ref_no"/></td>
                    <td> <bean:write name="u" property="date_received"/> </td>
                    <td> <bean:write name="u" property="created_by"/> </td>
                    <td> Pending Data Entry </td>
                    <td> <bean:write name="u" property="created_by"/> </td>
                </tr>
            </logic:iterate>
        </table>
    </body>
</html>
