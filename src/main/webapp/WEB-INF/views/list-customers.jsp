<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 05.04.2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customer list</title>
</head>
<body>
    <div class="wrapper">
        <div class="header">
            <h2>CRM</h2>
        </div>
    </div>
    <div class="container">
        <div class="content">
            <table>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td> ${customer.firstName}</td>
                        <td> ${customer.lastName}</td>
                        <td> ${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
