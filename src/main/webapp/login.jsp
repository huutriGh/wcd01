<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> Login Page </h1>
<br/>
<form method="post" action="login">
    <p>
        <input type="text" placeholder="User Name" name="username">
    </p>
    <p>
        <input type="password" placeholder="Password" name="password">
    </p>
    <p>
        <input type="submit" value="login">
    </p>
</form>
</body>
</html>