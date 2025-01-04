<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Acquisto Biglietti - Selezione</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/ticketShopStyle.css" />
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<h1>Seleziona i tuoi biglietti</h1>
<form id = "shopPhase1" action="${pageContext.request.contextPath}//phase2redirect" method="post">
    <label for="numero">Numero di biglietti:</label>
    <select id="numero" name="numero" required>
<%@ page import="museum_management_system.Application.Dto.EventDTO" %>
<% for (int i = 1; i <= 8; i++) { %>
        <option value="<%= i %>"><%= i %></option>
        <% } %>
    </select><br><br>

    <label for="eventId">Evento: </label>
    <select id="eventId" name="eventId" required>
        <option value = "-1">Biglietto Base</option>
        <%
            List<EventDTO> eventi = (List<EventDTO>) request.getAttribute("eventi");
            if(eventi != null){
            for (EventDTO evento : eventi) {
        %>
        <option value="<%= evento.getId() %>">
            <%= evento.getName() %> - <%= evento.getStartDate() %> - <%= evento.getEndDate() %>
        </option>
        <%      }
            }%>
    </select><br><br>

    <label for="data">Data della prenotazione:</label>
    <input type="date" id="data" name="data" required><br><br>

    <button type="submit">Prosegui</button>
</form>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>