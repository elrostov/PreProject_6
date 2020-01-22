<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<?xml version="4.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
    <title>Register user</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/formStyle.css"
          rel="stylesheet">
</head>
<body>
<div class="form-style-6">
    <h1>Register new user:<br/></h1>
    <form method="POST" action="${pageContext.request.contextPath}/admin/register">
        <label><input name="username" type="text" placeholder="User name"/></label>
        <label><input name="password" type="text" placeholder="Password"/></label><br><br>
        <label><input name="USER" type="checkbox" value="USER" checked>USER</label><br><br>
        <label><input name="ADMIN" type="checkbox" value="ADMIN">ADMIN</label><br><br>
        <input type="submit" value="Register"/>
    </form>
</div>
</body>
</html>
