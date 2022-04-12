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

        <title>Update</title>
    </head>
    <body>
        <div class="text-center">
            <h1>Edit City</h1>
        </div>

        <html:errors/>

        <div class="container">
            <html:form method="POST" action="city-action.do?act=update">
                <div class="form-group">
                    <label >Province :</label><br>
                    <select name="province_id" class="form-control" value="${cityForm.province_id}">
                        <option value=225>JAWA TIMUR</option>
                        <option value=223>JAWA TENGAH</option>
                        <option value=221>DKI JAKARTA</option>
                    </select>
                </div>

                <label >Code :</label><br>
                <input type="number" name="code" class="form-control" value="${cityForm.code}"  required=""><br>

                <label>Name : </label><br>
                <input type="text" name="name" class="form-control" value="${cityForm.name}"  required=""><br>

                <input type="hidden" name="updated_by" value="${sessionScope.user}">
                <input type="hidden" name="id" value="${cityForm.id}">
                <button type="submit" class="btn btn-success"> Create </button>
            </html:form>
        </div>

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

    </body>
</html>
