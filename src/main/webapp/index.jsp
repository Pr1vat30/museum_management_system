<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homepage - Museum Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/index.css">
</head>
<body>
<jsp:include page="WEB-INF/pages/visitor_section/header.jsp"/>
<main>
    <!-- Messaggio per ruoli -->
    <section class="role-message">
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
                <p>Please log in to discover more.</p>
            </c:otherwise>
        </c:choose>
    </section>
    <jsp:include page="WEB-INF/pages/box_info.jsp"/>
</main>
<jsp:include page="WEB-INF/pages/visitor_section/footer.jsp"/>
</body>
</html>
