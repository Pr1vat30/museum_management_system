<%@ page import="museum_management_system.Application.Dto.MostraDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dettaglio Mostra</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/eventPage.css">
</head>
<body>
<%
    MostraDTO mostra = (MostraDTO) request.getAttribute("mostra");
    String user = (String) session.getAttribute("email");
    if (user != null) {
        if (user.endsWith("@personale.com") || user.endsWith("@admin.com")) {
%>
<a style="display: block; text-align: center; margin: 20px auto; font-size: 1.5em; font-weight: bold; color: #007BFF; text-decoration: none;" href="${pageContext.request.contextPath}/eventeditor?id=<%= mostra.getId() %>">Modifica Evento</a>
<%
        }
    }
%>
<div class="details-container">
    <div class="mostra-details">
        <!-- Messa in risalto del titolo -->
        <h1 class="highlight-title"><%= mostra.getName() %></h1>
        <p><strong>Descrizione:</strong> <%= mostra.getDescription() %></p>
        <p><strong>Data Inizio:</strong> <%= mostra.getStartDate() %></p>
        <p><strong>Data Fine:</strong> <%= mostra.getEndDate() %></p>
        <p><strong>Posti Disponibili:</strong> <%= mostra.getPostiLiberi() %></p>
        <p><strong>Prezzo per Biglietto:</strong> &euro;<%= String.format("%.2f", mostra.getPriceXTicket()) %></p>
    </div>
</div>
</body>
</html>


