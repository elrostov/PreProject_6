<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Document</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/register" method="GET">
    <input type="submit" value="Register user">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Role</th>
        <th>Update user</th>
        <th>Delete user</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>
                <form method="GET" action="${pageContext.request.contextPath}/updatePage">
                    <input type="hidden" value="${user.id}" name="userId"/>
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete" method="POST">
                    <input type="hidden" value="${user.id}" name="userId"/>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>