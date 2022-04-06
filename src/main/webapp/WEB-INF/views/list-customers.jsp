<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 05.04.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer list</title>
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
    <div class="content">

        <input type="button" value="Add Customer" onclick="window.location.href='addForm'; return false;"
               class="add-button">
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>
        <table>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td> ${customer.firstName}</td>
                    <td> ${customer.lastName}</td>
                    <td> ${customer.email}</td>
                    <td>
                        <a href="/customer/updateCustomer?customerId=${customer.id}">Update</a> |
                        <a href="/customer/deleteCustomer?customerId=${customer.id}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
