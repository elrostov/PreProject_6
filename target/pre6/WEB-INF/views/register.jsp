<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version="4.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
    <title>Register user</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}/resources/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-6">
    <h1>Register new user:<br/></h1>
    <form:form modelAttribute="userForm" method="POST"
               action="${pageContext.request.contextPath}/saveUser">
        <label>
            <form:input path="name" type="text" placeholder="Name" />
        </label>
        <label>
            <form:input path="password" type="password" placeholder="Password" />
        </label>
        <label>
            <form:select path="role">
                <option value="user">user</option>
                <option value="admin">admin</option>
            </form:select>
        </label>
        <input type="submit" value="Register" />
    </form:form>
</div>
</body>
</html>
