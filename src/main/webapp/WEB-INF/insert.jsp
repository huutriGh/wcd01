<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 08/02/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Insert employee</title>
</head>
<body>
<h3>Insert Employee</h3>
<form action="<c:url value="/insert"/> " method="post" >
    <p>
        <input name="id" type="text" placeholder="Employee Id">
    </p>
    <p>
        <input name="name" type="text" placeholder="Employee Name">
    </p>
    <p>
        <input name="address" type="text" placeholder="Address">
    </p>
    <p>
        <input name="age" type="number" placeholder="Age">
    </p>
    <p>
        <input type="reset" value="Reset">
        <input type="submit" value="Submit">
    </p>
</form>

</body>
</html>
