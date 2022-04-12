<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">        
        <title>Create New Province</title>
    </head>
    <body>
        <div class="text-center">
            <h1>Create New Province</h1>
        </div>
        <html:errors/>

        <div class="container">
            <html:form method="GET" action="report-action.do">
                <div class="form-group">
                    <label >Bulan :</label><br>
                   <select name="month" class="form-control" required="">
                        <option value=01>January</option>
                        <option value=02>February</option>
                         <option value=03>March</option>
                    </select>
                </div>

                 <div class="form-group">
                    <label >Tahun :</label><br>
                   <select name="year" class="form-control" required="">
                        <option value=2022>2022</option>
                        <option value=2021>2021</option>
                         <option value=2020>2020</option>
                    </select>
                </div>

                <button type="submit" value="Submit" class="btn btn-success"> Create </button>
            </html:form>
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

