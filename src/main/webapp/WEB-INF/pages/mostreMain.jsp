<%@ page import="museum_management_system.Application.Dto.MostraDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostre Disponibili</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/eventsMain.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container">
    <%
        String user = (String) session.getAttribute("email");
        if(user != null){
            if(user.endsWith("@personale.com") || user.endsWith("@admin.com")){
    %>
    <a style="display: block; text-align: center; margin: 20px auto; font-size: 1.5em; font-weight: bold; color: #007BFF; text-decoration: none;" href="${pageContext.request.contextPath}/eventcreator" >Creazione nuovo Evento</a>
    <% } }
        // Recupera la lista degli eventi passata dal backend
        List<MostraDTO> events = (List<MostraDTO>) request.getAttribute("events");

        if (events != null && !events.isEmpty()) {
            for (MostraDTO mostra : events) {
    %>
    <a href="${pageContext.request.contextPath}/eventpage?id=<%= mostra.getId() %>" class="card-link">
        <div class="card">
            <!-- Rimuovi l'immagine -->
            <div class="card-content">
                <!-- Titolo messo in risalto con classe CSS -->
                <div class="card-title highlight-title"><%= mostra.getName() %></div>
                <div class="card-details">
                    <span>Fine: <%= mostra.getEndDate() %></span>
                    <span>Posti Disponibili: <%= mostra.getPostiLiberi() %></span>
                </div>
                <div class="card-price">&euro;<%= String.format("%.2f", mostra.getPriceXTicket()) %></div>
            </div>
        </div>
    </a>
    <%
        }
    } else {
    %>
    <p style="display: block; text-align: center; margin: 20px auto; font-size: 1.5em; text-decoration: none;">Nessun evento disponibile al momento.</p>
    <%
        }
    %>
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
