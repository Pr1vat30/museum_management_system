<%@ page import="museum_management_system.Application.Dto.EventDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dettaglio Evento</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/eventPage.css">
</head>
<body>
<%
    EventDTO event = (EventDTO) request.getAttribute("event");
    String user = (String) session.getAttribute("email");
    if (user != null) {
        if (user.endsWith("@personale.com") || user.endsWith("@admin.com")) {
%>
<a style="display: block; text-align: center; margin: 20px auto; font-size: 1.5em; font-weight: bold; color: #007BFF; text-decoration: none;" href="${pageContext.request.contextPath}/eventeditor?id=<%= event.getId() %>">Modifica Evento</a>
<%
        }
    }
%>
<div class="details-container">
    <div class="event-details">
        <!-- Messa in risalto del titolo -->
        <h1 class="highlight-title"><%= event.getName() %></h1>
        <p><strong>Descrizione:</strong> <%= event.getDescription() %></p>
        <p><strong>Data Inizio:</strong> <%= event.getStartDate() %></p>
        <p><strong>Data Fine:</strong> <%= event.getEndDate() %></p>
        <p><strong>Posti Disponibili:</strong> <%= event.getPostiLiberi() %></p>
        <p><strong>Prezzo per Biglietto:</strong> &euro;<%= String.format("%.2f", event.getPriceXTicket()) %></p>
    </div>
</div>
</body>
</html>


