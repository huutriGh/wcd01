<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 12/02/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h3>Delete Employee</h3>
<form action="<c:url value="/delete"/> " method="post" >
    <p>
        <input name="id" type="hidden" value="${emp.id}" placeholder="Employee Id">
    </p>
    <p>
        <input name="name" type="text" value="${emp.name}" placeholder="Employee Name">
    </p>
    <p>
        <input name="address" type="text" value="${emp.address}" placeholder="Address">
    </p>
    <p>
        <input name="age" type="number" value="${emp.age}" placeholder="Age">
    </p>
    <p>
        <input type="submit" value="Submit">
    </p>
</form>
</body>
</html>