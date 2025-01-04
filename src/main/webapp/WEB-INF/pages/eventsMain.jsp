<%@ page import="museum_management_system.Application.Dto.EventDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eventi Disponibili</title>
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
        List<EventDTO> events = (List<EventDTO>) request.getAttribute("events");

        if (events != null && !events.isEmpty()) {
            for (EventDTO event : events) {
    %>
    <a href="${pageContext.request.contextPath}/eventpage?id=<%= event.getId() %>" class="card-link">
        <div class="card">
            <!-- Rimuovi l'immagine -->
            <div class="card-content">
                <!-- Titolo messo in risalto con classe CSS -->
                <div class="card-title highlight-title"><%= event.getName() %></div>
                <div class="card-details">
                    <span>Fine: <%= event.getEndDate() %></span>
                    <span>Posti Disponibili: <%= event.getPostiLiberi() %></span>
                </div>
                <div class="card-price">&euro;<%= String.format("%.2f", event.getPriceXTicket()) %></div>
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
