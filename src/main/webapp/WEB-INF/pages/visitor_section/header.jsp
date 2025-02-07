<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/index.css">
<header>
    <nav>
        <div class="container">
            <h1>Museum Management System</h1>
            <ul class="nav-links">
                <c:choose>
                    <c:when test="${sessionScope.logged == true}">
                        <li><a href="auth-servlet?op=logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="access-servlet?pg=login">Login</a></li>
                        <li><a href="access-servlet?pg=signup">Signup</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>