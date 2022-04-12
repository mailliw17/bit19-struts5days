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
        <title>Detail</title>
    </head>
    <body>

        <%--<logic:present name="provinceForm" property="listProvince">--%>

        <ul>
            <li>Customer Name : <bean:write name="customerForm" property="name"/></li>
            <li>Customer Full Name : <bean:write name="customerForm" property="full_name"/></li>
            <li>ID Type : <bean:write name="customerForm" property="id_type"/></li>
            <li>ID No : <bean:write name="customerForm" property="id_number"/></li>
            <li>ID Expiry Date : <bean:write name="customerForm" property="id_expiry_date"/></li>
            <li>Gender : <bean:write name="customerForm" property="gender"/></li>
            <li>Place of Birth : <bean:write name="customerForm" property="place_of_birth"/></li>
            <li>City of Birth : <bean:write name="customerForm" property="city_id"/></li>
            <li>Province of Birth : <bean:write name="customerForm" property="province_id"/></li>
            <li>Country of Birth : INA - Indonesia</li>
            <li>Date of Birth : <bean:write name="customerForm" property="date_of_birth"/></li>
            <li>Age : <bean:write name="customerForm" property="age_year"/> years -  <bean:write name="customerForm" property="age_month"/> months</li>
            <li>Marital Status : <bean:write name="customerForm" property="marital_status"/></li>
            <li>Number of Dependents : <bean:write name="customerForm" property="number_of_dependents"/></li>
            <li>Mother Maiden Name : <bean:write name="customerForm" property="mother_maiden_name"/></li>
            <li>Level of Education : <bean:write name="customerForm" property="level_of_education"/></li>
            <li>Mailing Address : <bean:write name="customerForm" property="mailing_address"/></li>
            <li>Residence Address : <bean:write name="customerForm" property="residence_address"/></li>
            <li>City : <bean:write name="customerForm" property="r_city_id"/></li>
            <li>Province : <bean:write name="customerForm" property="r_province_id"/></li>
            <li>Country : INA - Indonesia</li>
            <li>Zip Code : <bean:write name="customerForm" property="zip_code"/></li>
            <li>Kelurahan : <bean:write name="customerForm" property="kelurahan"/></li>
            <li>Kecamatan : <bean:write name="customerForm" property="kecamatan"/></li>
            <li>Email Address : <bean:write name="customerForm" property="email"/></li>
            <li>Mobile Phone No. : <bean:write name="customerForm" property="no_mobile_phone"/></li>
            <li>Home Phone No. : <bean:write name="customerForm" property="no_home_phone"/></li>
            <li>Residence Status : <bean:write name="customerForm" property="residence_status"/></li>
            <li>Length of Stay : <bean:write name="customerForm" property="length_of_stay_year"/> years - <bean:write name="customerForm" property="length_of_stay_month"/> months</li>
        </ul>

        <a href="customer-action.do?act=formUpdate&id=<bean:write name="customerForm" property="id"/>">Update</a>

        <a href="customer-application-action.do?id=<bean:write name="customerForm" property="id"/>">Customer Application</a>
        <%--</logic:present>--%>
    </body>
</html>
