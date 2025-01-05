<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/users_section/header.css">
<header>
    <i class='bx bx-menu burger-open'></i>

    <div class="header-logo">
        <img src="./resurces/funko_logo.png" alt="logo" width="90" height="30">
    </div>

    <ul class="header-list">
        <i class='bx bx-x burger-close'></i>
        <li><a href="#">Home</a></li>
        <li><a href="#">Product</a></li>
        <li><a href="#">Promotions</a></li>
        <li><a href="#">Explore</a></li>
    </ul>

    <div class="header-icon">
        <i class='bx bx-search icon' id="search-icon"></i>
        <div class="search-box">
            <i class='bx bx-search icon'></i>
            <input type="text" placeholder="Search here...">
        </div>
        <a href="users-nav-servlet?pg=notification"><i class='bx bx-shopping-bag icon'></i></a>

        <c:choose>
            <c:when test="${sessionScope.logged == true}">
                <a href="" id="logout">
                    <i class='bx bx-user-circle icon'></i>
                </a>
            </c:when>
        </c:choose>
    </div>

</header>
