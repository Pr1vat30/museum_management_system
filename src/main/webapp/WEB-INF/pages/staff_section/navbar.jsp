<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 28/12/24
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <div class="logo main">
        <div class="logo-space">
            <i class='bx bx-menu menu-icon'></i>
            <span class="logo-name">Dashboard</span>
        </div>
        <div class="logo-message">
            <span><c:out value="Welcome ${sessionScope.user.name}"/></span>
        </div>
    </div>

    <div class="sidebar">
        <div class="logo">
            <i class='bx bx-menu menu-icon'></i>
            <span class="logo-name">Dashboard</span>
        </div>

        <div class="sidebar-content">
            <ul class="lists">
                <li class="list">
                    <a href="staff-nav-servlet?pg=homepage" class="nav-link">
                        <i class='bx bx-home-alt icon'></i>
                        <span class="link">Homepage</span>
                    </a>
                </li>

                <li class="list">
                    <a href="staff-nav-servlet?pg=notification" class="nav-link">
                        <i class='bx bx-package icon'></i>
                        <span class="link">Notification</span>
                    </a>
                </li>

                <li class="list">
                    <a href="staff-nav-servlet?pg=manage_arts" class="nav-link">
                        <i class='bx bx-category icon'></i>
                        <span class="link">Mange Arts</span>
                    </a>
                </li>

                <li class="list">
                    <a href="staff-nav-servlet?pg=event" class="nav-link">
                        <i class='bx bx-category icon'></i>
                        <span class="link">Mange Event</span>
                    </a>
                </li>

                <li class="list">
                    <a href="staff-nav-servlet?pg=ticket" class="nav-link">
                        <i class='bx bx-category icon'></i>
                        <span class="link">Mange Ticket</span>
                    </a>
                </li>
            </ul>

            <div class="bottom-content">
                <li class="list">
                    <a href="" class="nav-link">
                        <i class='bx bx-cog icon'></i>
                        <span class="link">Setting</span>
                    </a>
                </li>

                <li class="list">
                    <a href="#" class="nav-link" id="logout">
                        <i class='bx bx-log-out icon'></i>
                        <span class="link">Log Out</span>
                    </a>
                </li>
            </div>
        </div>
    </div>
</nav>

<section class="overlay"></section>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>