<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Province</title>
    </head>
    <body>
        <h1>Edit Customer</h1>
        <html:errors/>
        <html:form  method="POST" action="customer-action.do?act=update">

            <label >Name :</label><br>
            <input type="text" name="name" value="${customerForm.name}"><br>
            <br> <br>

            <label>Full Name :</label><br>
            <input type="text" name="full_name" value="${customerForm.full_name}"><br>
            <br> <br>

            <label>ID Type : </label><br>
            <select name="id_type" value="${customerForm.id_type}">
                <option value="KTP">KTP</option>
                <option value="SIM">SIM</option>
                <option value="Passport">Passport</option>
            </select>
            <br><br>

            <label >ID Number :</label><br>
            <input type="text" name="id_number" value="${customerForm.id_number}"><br>
            <br> <br>

            <label >ID Expiry Date :</label><br>
            <input type="date" name="id_expiry_date" value="${customerForm.id_expiry_date}"><br>
            <br> <br>

            <label>Gender : </label><br>
            <select name="gender" value="${customerForm.gender}">
                <option value="Pria">Pria</option>
                <option value="Wanita">Wanita</option>
            </select>
            <br><br>

            <label >Place of Birth :</label><br>
            <input type="text" name="place_of_birth" value="${customerForm.place_of_birth}"><br>
            <br> <br>

            <label>City : </label><br>
            <select name="city_id" value="${customerForm.city_id}">
                <option value=121>JAKARTA UTARA</option>
                <option value=122>JAKARTA BARAT</option>
                <option value=126>SEMARANG</option>
                <option value=127>DEMAK</option>
                <option value=129>SURABAYA</option>
                <option value=130>JEMBER</option>
            </select>
            <br><br>

            <label>Province : </label><br>
            <select name="province_id" value="${customerForm.province_id}">
                <option value=221>DKI JAKARTA</option>
                <option value=225>JAWA TIMUR</option>
                <option value=223>JAWA TENGAH</option>               
            </select>
            <br><br>

            <label >Date of Birth :</label><br>
            <input type="date" name="date_of_birth" value="${customerForm.date_of_birth}"><br>
            <br> <br>

            <label >Age Year :</label><br>
            <input type="number" name="age_year" value="${customerForm.age_year}"><br>
            <br> <br>

            <label >Age Month :</label><br>
            <input type="number" name="age_month" value="${customerForm.age_month}"><br>
            <br> <br>

            <label>Marital Status : </label><br>
            <select name="marital_status" value="${customerForm.marital_status}">
                <option value="Single">Single</option>
                <option value="Married">Married</option>
                <option value="Widowed">Widowed</option>
                <option value="Divorced">Divorced</option>
            </select>
            <br><br>

            <label >Number of Dependents :</label><br>
            <input type="number" name="number_of_dependents" value="${customerForm.number_of_dependents}"><br>
            <br> <br>

            <label>Level of Education : </label><br>
            <select name="level_of_education" value="${customerForm.level_of_education}">
                <option value="SD">SD</option>
                <option value="SMP">SMP</option>
                <option value="SMA">SMA</option>
                <option value="D3">D3</option>
                <option value="S1">S1</option>
                <option value="S2">S2</option>
                <option value="S3">S3</option>
            </select>
            <br><br>

            <label >Mother Maiden Name :</label><br>
            <input type="text" name="mother_maiden_name" value="${customerForm.mother_maiden_name}"><br>
            <br> <br>

            <label >Spouse name :</label><br>
            <input type="text" name="spouse_name" value="${customerForm.spouse_name}"><br>
            <br> <br>

            <label >Spouse ID no :</label><br>
            <input type="text" name="spouse_id_no" value="${customerForm.spouse_id_no}"><br>
            <br> <br>

            <label >Spouse Age Year :</label><br>
            <input type="number" name="spouse_date_year" value="${customerForm.spouse_date_year}"><br>
            <br> <br>

            <label >Spouse Age Month :</label><br>
            <input type="number" name="spouse_date_month" value="${customerForm.spouse_date_month}"><br>
            <br> <br>

            <label>Prenuptial Agreement : </label><br>
            <select name="prenuptial_agreemeent" value="${customerForm.prenuptial_agreemeent}">
                <option value="Yes">Yes</option>
                <option value="Yes">No</option>
            </select>
            <br><br>

            <hr>

            <h1>Residence Information</h1>

            <label>Mailing Address : </label><br>
            <select name="mailing_address" value="${customerForm.mailing_address}">
                <option value="O - Office">O - Office</option>
                <option value="R - Residence">R - Residence</option>
            </select>
            <br><br>

            <label >Residence Address</label><br>
            <textarea name="residence_address" rows="4" cols="50">${customerForm.residence_address}"</textarea>
            <br> <br>

            <label>Residence City : </label><br>
            <select name="r_city_id" value="${customerForm.r_city_id}">
                <option value=121>JAKARTA UTARA</option>
                <option value=122>JAKARTA BARAT</option>
                <option value=126>SEMARANG</option>
                <option value=127>DEMAK</option>
                <option value=129>SURABAYA</option>
                <option value=130>JEMBER</option>
            </select>
            <br><br>

            <label>Residence Province : </label><br>
            <select name="r_province_id" value="${customerForm.r_province_id}">
                <option value=221>DKI JAKARTA</option>
                <option value=225>JAWA TIMUR</option>
                <option value=223>JAWA TENGAH</option>               
            </select>
            <br><br>

            <label >Zip Code :</label><br>
            <input type="number" name="zip_code" value="${customerForm.zip_code}"><br>
            <br> <br>

            <label >Kelurahan :</label><br>
            <input type="text" name="kelurahan" value="${customerForm.kelurahan}"><br>
            <br> <br>

            <label >Kecamatan :</label><br>
            <input type="text" name="kecamatan" value="${customerForm.kecamatan}"><br>
            <br> <br>

            <label >Home Phone no. :</label><br>
            <input type="number" name="no_home_phone" value="${customerForm.no_home_phone}"><br>
            <br> <br>

            <label >Mobile Phone no. :</label><br>
            <input type="number" name="no_mobile_phone" value="${customerForm.no_mobile_phone}"><br>
            <br> <br>

            <label >Email Address</label><br>
            <input type="email" name="email" value="${customerForm.email}"><br>
            <br> <br>

            <label>Residence Status : </label><br>
            <select name="residence_status" value="${customerForm.residence_status}">
                <option value="Owner">00 – Owner</option>
                <option value="Parent">01 – Parent</option>
                <option value="Rent">02 – Rent</option>  
                <option value="Relatives">03 – Relatives</option>  
            </select>
            <br><br>

            <label >Length Stay Year :</label><br>
            <input type="number" name="length_of_stay_year" value="${customerForm.length_of_stay_year}"><br>
            <br> <br>

            <label >Length Stay Month :</label><br>
            <input type="number" name="length_of_stay_month" value="${customerForm.length_of_stay_month}"><br>
            <br> <br>

            <input type="hidden" name="id" value="${customerForm.id}"> 
            <input type="hidden" name="updated_by" value="${sessionScope.user}"> 
            <input type="submit" value="Submit">
        </html:form>
    </body>
</html>

