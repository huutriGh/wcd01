<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 08/02/2023
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h3>Insert employee success</h3>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.address}</td>
            <td>${emp.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
