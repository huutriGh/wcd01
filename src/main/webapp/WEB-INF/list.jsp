<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
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
<h1>
    <c:if test="${!empty sessionScope.user}">
        Hello ${sessionScope.user.userName} <a href="<c:url value="/logout"/>">Logout</a>
    </c:if>
</h1>
<h3>Employee List</h3>
<p>
    <a href="<c:url value="insert"/>">Create Employee</a>
</p>
<div>
    <form action="<c:url value="/search"/> " method="post">
        <p>
            <input type="text" placeholder="Search by name" value="${lastSearchStr}" name="searchString"/>
        </p>
        <p>
            <input type="submit" value="search"/>
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


