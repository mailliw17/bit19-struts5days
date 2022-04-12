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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">

        <title>Province</title>
    </head>
    <body>
        <a href="home.jsp" class="btn btn-primary">Back</a>
        
        <div class="text-center">
            <h1>List Customer</h1>
            <a href="Customer/createCustomer.jsp" class="btn btn-success">Create new</a>
        </div>
        <hr>

        <div class="container">
            <table class="myTable">
                <thead>
                    <tr style="background-color: #E0E0E1;">
                        <th>ID</th>
                        <th>Name</th>
                        <th>Adress</th>
                        <th>ID Type</th>
                        <th>ID Number</th>
                        <th>Birth Date</th>
                    </tr>
                </thead>
                <tbody>
                    <logic:iterate id="u" name="customerForm" property="listCustomer">
                        <tr>
                            <td> <bean:write name="u" property="id"/> </td>
                            <td><a href="customer-action.do?act=detail&id=<bean:write name="u" property="id"/>"> <bean:write name="u" property="full_name"/> </a></td>
                            <td>  <bean:write name="u" property="residence_address"/> </td>
                            <td> <bean:write name="u" property="id_type"/> </td>
                            <td> <bean:write name="u" property="id_number"/> </td>
                            <td>
                                <bean:write name="u" property="date_of_birth"/> 
                            </td>
                        </tr>
                    </logic:iterate>
                </tbody>
            </table>
        </div>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

        <script>
            $(document).ready(function () {
                $('.myTable').DataTable();
            });
        </script>
    </body>
</html>
