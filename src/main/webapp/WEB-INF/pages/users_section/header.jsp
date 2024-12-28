<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/header.css">
</head>
<body>
<header>
    <div class="logo">
        <a href="index.jsp">Museum Management System</a>
    </div>
    <div class="user-actions">
        <a href="../login.jsp" class="login-link">Login</a> <!-- Solo se non è loggato -->
        <a href="account.jsp" class="account-link">Account</a> <!-- Solo se loggato -->
        <button class="menu-toggle" id="menu-toggle">☰</button>
    </div>
</header>
<aside id="sidebar" class="sidebar">
    <nav>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="manage-museum.jsp">Gestisci Museo</a></li>
            <li><a href="exhibitions.jsp">Esposizioni</a></li>
            <li><a href="staff.jsp">Personale</a></li>
            <li><a href="users.jsp">Utenti</a></li>
            <li><a href="settings.jsp">Impostazioni</a></li>
        </ul>
    </nav>
</aside>
<script>
    // Funzione per aprire e chiudere il menu laterale
    document.getElementById("menu-toggle").addEventListener("click", function() {
        var sidebar = document.getElementById("sidebar");
        sidebar.classList.toggle("open");
    });
</script>
</body>
</html>
