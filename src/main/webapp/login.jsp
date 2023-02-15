<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1> Login Page </h1>
<br/>
<form method="post" action="j_security_check">
    <p>
        <input type="text" placeholder="User Name" name="j_username">
    </p>
    <p>
        <input type="password" placeholder="Password" name="j_password">
    </p>
    <p>
        <input type="submit" value="login">
    </p>
</form>
</body>
</html>