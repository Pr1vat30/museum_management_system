<%@ page import="museum_management_system.Application.Dto.EventDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifica Evento</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/eventeditor.css">
</head>
<body>
<div class="container">
    <h1>Modifica Evento</h1>
    <% EventDTO event = (EventDTO) request.getAttribute("event");%>
    <!-- Form di modifica evento -->
    <form action="${pageContext.request.contextPath}/eventeditor" method="POST">
        <input type="hidden" name="id" value="<%=event.getId()%>" />
        <input type="hidden" name="postioccupati" value="<%=event.getPosti() - event.getPostiLiberi()%>" />

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%=event.getName()%>" required />

        <label for="descrizione">Descrizione:</label>
        <textarea id="descrizione" name="descrizione" required><%=event.getDescription()%></textarea>

        <label for="posti">Posti:</label>
        <input type="number" id="posti" name="posti" value="<%=event.getPosti()%>" required />

        <label for="startdate">Data Inizio:</label>
        <input type="date" id="startdate" name="startdate" value="<%=event.getStartDate()%>" required />

        <label for="enddate">Data Fine:</label>
        <input type="date" id="enddate" name="enddate" value="<%=event.getEndDate()%>" required />

        <label for="prezzo">Prezzo a Biglietto (€):</label>
        <input type="number" step="0.01" id="prezzo" name="prezzo" value="<%=event.getPriceXTicket()%>" required />

        <button type="submit">Salva Modifiche</button>
    </form>
</div>
</body>
</html>
