<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Admin page</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/register" method="GET">
    <input type="submit" value="Register user">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Role(s)</th>
        <th>Update user</th>
        <th>Delete user</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    ${role.name}<br>
                </c:forEach>
            </td>
            <td>
                <form method="GET" action="${pageContext.request.contextPath}/admin/update">
                    <input type="hidden" value="${user.id}" name="id"/>
                    <input type="hidden" value="${user.username}" name="username"/>
                    <input type="hidden" value="${user.password}" name="password"/>
                    <c:forEach var="role" items="${user.roles}">
                        <input type="hidden" value="${role.name}" name="${role.name}"/>
                    </c:forEach>
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/admin/delete" method="POST">
                    <input type="hidden" value="${user.id}" name="userId"/>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>