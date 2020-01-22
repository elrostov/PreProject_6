<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<?xml version="4.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
    <title>Update user</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}resources/css/formStyle.css"
          rel="stylesheet">
</head>
<body>
<div class="form-style-6">
    <h1>Update user: <strong><c:out value="${user.username}"/></strong><br/></h1>
    <form method="POST" action="${pageContext.request.contextPath}/admin/update">
        <input type="hidden" name="id" value="${user.id}"/>
        <input type="text" name="username" value="${user.username}"/>
        <input type="text" name="password"/>
        <label><input name="USER" type="checkbox" value="USER" checked>USER</label><br><br>
        <label><input name="ADMIN" type="checkbox" value="ADMIN">ADMIN</label><br><br>
        <input type="submit" value="Update">
    </form>
</div>
</body>
</html>
