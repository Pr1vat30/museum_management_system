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
    <button class="menu-toggle" id="menu-toggle">☰</button>
</header>
<aside id="sidebar" class="sidebar">
    <nav>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="exhibitions.jsp">Esposizioni</a></li>
            <li><a href = "${pageContext.request.contextPath}/bigliettocontroller">Biglietto</a></li>
            <%String user = (String) session.getAttribute("email");
            if(user == null){%>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/registrazione">Registrati</a></li>
            <%}else
                if(user.endsWith("@personale.com")){%>
                    <li><a href="staff.jsp">Area Personale</a></li>
                    <li><a href="manage-museum.jsp">Gestisci Museo</a></li>
                <%} else if(user.endsWith("@admin.com")){%>
                    <li><a href="staff.jsp">Area Personale</a></li>
                    <li><a href="manage-museum.jsp">Gestisci Museo</a></li>
                    <li><a href="manage-museum.jsp">Gestisci Personale</a></li>
                <%} else {%>
                    <li><a href="users.jsp">Area Utente</a></li>
                    <li><a href="${pageContext.request.contextPath}//ticketshop">Acquista Biglietti</a></li>
                    <li><a href="${pageContext.request.contextPath}//storico-biglietti">Storico Biglietti</a></li>
                <%}%>
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
