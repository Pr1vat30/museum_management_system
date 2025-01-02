<%@ page import="museum_management_system.Application.Dto.BigliettoDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Storico Acquisti</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container">
    <h1>Storico Acquisti</h1>
    <div class="cards">
        <%
            List<BigliettoDTO> storicoBiglietti = (List<BigliettoDTO>) request.getAttribute("biglietti");
            if (storicoBiglietti != null && !storicoBiglietti.isEmpty()) {
                for (BigliettoDTO ticket : storicoBiglietti) {
        %>
        <form action="TicketDetailServlet" method="post" class="card">
            <input type="hidden" id = "ticketId" name="ticketId" value="<%= ticket.getId() %>">
            <div>
                <h3>Evento: <%= ticket.getEventId() %></h3>
                <p>Data Evento: <%= ticket.getDataPrenotazione() %></p>
                <p>Nome Titolare: <%= ticket.getTitolare() %></p>
                <p>Prezzo: &euro; <%= ticket.getPrezzo() %></p>
            </div>
            <button type="submit" class="btn">Visualizza</button>
        </form>
        <%    }
        } else {
        %>
        <p>Non ci sono acquisti da mostrare.</p>
        <% } %>
    </div>
    <a href="home.jsp" class="btn">Torna alla Home</a>
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
