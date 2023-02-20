<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="messages" var="lang"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h4>
    <fmt:message key="list.changeLanguage" bundle="${lang}"/>
</h4>
<ul>
    <li><a href="<c:url value="?lang=vi_Vn"/>"><fmt:message key="list.lang.vn" bundle="${lang}"/></a></li>
    <li><a href="<c:url value="?lang=en_US"/>"><fmt:message key="list.lang.en" bundle="${lang}"/></a></li>
</ul>
<c:set var="date" value="<%=new java.util.Date()%>"/>

<h5><fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
<h2><fmt:message key="list.hello" bundle="${lang}"/> ${sessionScope.user.userName} <a href="<c:url value="/logout"/>">Logout</a>
</h2>
<h3>Employee List</h3>

<p>
    <a href="<c:url value="insert"/>">Create Employee</a>
</p>

<div>
    <form method="post" action="search">
        <%--        <p>--%>
        <%--            <input name="searchStr" type="text" value="${lastSearchStr}">--%>
        <%--        </p>--%>

        <p>
            <input name="searchStr" type="text" value="${cookie.get("lastSearchStr").value}">
        </p>
        <p>
            <input type="submit" value="Search">
        </p>

    </form>
</div>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.address}</td>
            <td>${emp.age}</td>
            <td><a href="<c:url value="/update?id=${emp.id}"/>">Update</a></td>
            <td><a href="<c:url value="/delete?id=${emp.id}"/>">Delete</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


