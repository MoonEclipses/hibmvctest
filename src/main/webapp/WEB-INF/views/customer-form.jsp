<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 06.04.2022
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="header">
        <h2>CRM</h2>
    </div>
</div>
<div class="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">To list</a>
    </p>
</div>
</body>
</html>
