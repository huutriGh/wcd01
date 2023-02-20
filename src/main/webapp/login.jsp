<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="message" var="lang"/>
<%--<fmt:setLocale value="en_US"/>--%>
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
        <input type="text" placeholder="<fmt:message key="login.user.placeholder" bundle="${lang}"/>" name="username">
    </p>
    <p>
        <input type="password" placeholder="<fmt:message key="login.password.placeholder" bundle="${lang}"/> "
               name="password">
    </p>
    <p>
        <input type="submit" value="<fmt:message key="login.submit.text" bundle="${lang}"/> ">
    </p>
</form>
</body>
</html>