<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录成功</title>
</head>

<body>
<table width="30%" border="1" align="center">
    <tbody>
    <tr>
        <td width="30%">廠商ID：</td>
        <td>${customer.companyId}</td>
    </tr>
    <tr>
        <td>廠商名稱：</td>
        <td>${customer.companyName}</td>
    </tr>
    <tr>
        <td>廠商電話：</td>
        <td>${customer.companyTel}</td>
    </tr>
    <tr>
        <td>廠商地址：</td>
        <td>${customer.companyAddress}</td>
    </tr>
    <tr>
        <td>統一編號：</td>
        <td>${customer.companyNumber}</td>
    </tr>
    <tr>
        <td>負責人：</td>
        <td>${customer.companyPeople}</td>
    </tr>
    <tr>
        <td>對應員工編號：</td>
        <td>${customer.employeeId}</td>
    </tr>
    <tr>
        <td>電子郵件：</td>
        <td>${customer.email}</td>
    </tr>
    </tbody>
</table>
<p>&nbsp;</p>

</body>
</html>