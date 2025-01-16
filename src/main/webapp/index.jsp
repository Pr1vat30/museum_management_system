<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="access-servlet?pg=login">login</a><br>
<a href="auth-servlet?op=logout">logout</a><br>
<a href="access-servlet?pg=signup">signup</a><br>

<c:choose>
    <c:when test="${sessionScope.logged == true}">
        <c:set var="user" value="${sessionScope.user}" />
        <c:choose>
            <c:when test="${user.role == 'admin'}">
                <h1>Welcome, Admin!</h1>
                <p>You have administrative privileges.</p>
            </c:when>
            <c:when test="${user.role == 'user'}">
                <h1>Welcome, User!</h1>
                <p>You have standard user access.</p>
            </c:when>
            <c:when test="${user.role == 'staff'}">
                <h1>Welcome, Staff!</h1>
                <p>You have staff user access.</p>
            </c:when>
        </c:choose>
    </c:when>
    <c:otherwise>
        <h1>User not authenticated</h1>
        <p>Please log in to access this page.</p>
    </c:otherwise>
</c:choose>
</body>
</html>