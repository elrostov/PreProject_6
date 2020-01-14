<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<?xml version="4.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
    <title>Update user</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}resources/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-6">
    <h1>Update user: <strong><c:out value="${user.name}"/></strong><br/></h1>
    <form:form modelAttribute="user" method="POST"
            action="${pageContext.request.contextPath}/update">
        <form:hidden path="id" value="${user.id}"/>
        <form:input path="name" value="${user.name}"/>
        <form:input path="password" value="${user.password}"/>
        <label>
            <form:select path="role">
                <option value="user">user</option>
                <option value="admin">admin</option>
            </form:select>
        </label>
        <input type="submit" value="Update">
    </form:form>
</div>
</body>
</html>
