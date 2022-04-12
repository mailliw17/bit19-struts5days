<%-- 
    Document   : detailProvince
    Created on : Apr 7, 2022, 8:19:44 PM
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">  
        <title>Detail</title>
    </head>
    <body>
        <div class="text-center">
            <h2>Detail</h2>
        </div>
        <div class="container">
            <div class="card" >
                <div class="card-header">
                    Name : <bean:write name="provinceForm" property="name"/>  
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Code : <bean:write name="provinceForm" property="code"/></li>
                    <li class="list-group-item">Created By : <bean:write name="provinceForm" property="created_by"/></li>
                    <li class="list-group-item btn btn-warning"> <a href="province-action.do?act=formUpdate&id=<bean:write name="provinceForm" property="id"/>">Update</a> </li>
                    <li class="list-group-item btn btn-danger"> <a href="province-action.do?act=delete&id=<bean:write name="provinceForm" property="id"/>">Delete</a> </li>
                </ul>
            </div>
        </div>


        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
    </body>
</html>
