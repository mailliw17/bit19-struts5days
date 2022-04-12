<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Province</title>
    </head>
    <body>
        <h1>Create New Province</h1>
        <html:errors/>

        <html:form method="POST" action="customer-application-action.do?act=create">

            <input type="hidden" name="customer_id" value="${param.id}">
            <input type="hidden" name="status" value="Pending Data Entry">

            <label>Referral Branch :</label><br>
            <input type="text" name="referral_branch" value="0960 Unit Bisnis Kartu Kredit" readonly=""> 
            <br> <br>

            <label>Date Received :</label><br>
            <input type="date" name="date_received"> 
            <br> <br>

            <label>Facility : </label><br>
            <select name="facility">
                <option value="500 PL Asuransi Jiwa">500 – PL Asuransi Jiwa</option>
                <option value="600 PL Asuransi Jiwa + PHK">600 – PL Asuransi Jiwa + PHK</option>
            </select>
            <br><br>

            <label>Application Purpose : </label><br>
            <select name="application_purpose">
                <option value="Sekolah">Sekolah</option>
                <option value="Liburan">Liburan</option>
                <option value="Modal Kerja">Modal Kerja</option>
                <option value="Lainnya">Lainnya</option>
            </select>
            <br><br>

            <label>Bussiness Source :</label><br>
            <input type="text" name="bussiness_source"> 
            <br> <br>

            <label>Media Channel : </label><br>
            <select name="media_channel">
                <option value="TV">TV</option>
                <option value="Surat Kabar">Surat Kabar</option>
                <option value="Internet">Internet</option>
                <option value="Cabang">Cabang</option>
                <option value="Lainnya">Lainnya</option>
            </select>
            <br><br>
            
            <label>Fee Branch :</label><br>
            <input type="text" name="fee_branch" value="0960 Unit Bisnis Kartu Kredit" readonly=""> 
            <br> <br>
            
             <label>Provision Branch :</label><br>
            <input type="text" name="provision_branch" value="0960 Unit Bisnis Kartu Kredit" readonly=""> 
            <br> <br>
            
             <label>KCKK Branch :</label><br>
            <input type="text" name="kckk_branch"> 
            <br> <br>
            
            <hr>
            <h2>Staff Introducer Information</h2>
            
            <label>Staff Name :</label><br>
            <input type="text" name="staff_name"> 
            <br> <br>
            
            <label>Staff NIP no :</label><br>
            <input type="text" name="staff_nip"> 
            <br> <br>
            
            <label>Staff Branch :</label><br>
            <input type="text" name="staff_branch"> 
            <br> <br>
            
            <label>Staff Account No :</label><br>
            <input type="text" name="staff_account_no"> 
            <br> <br>

            <input type="hidden" name="created_by" value="${sessionScope.user}"> 
            <input type="submit" value="Submit">
        </html:form>
    </body>
</html>

