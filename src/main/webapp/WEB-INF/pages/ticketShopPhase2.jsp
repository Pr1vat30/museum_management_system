<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Acquisto Biglietti - Dettagli</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/ticketShopStyle.css" />
</head>
<body>
<header>
  <jsp:include page="header.jsp"/>
</header>
<h1>Inserisci i dettagli dei titolari</h1>
<form id = "shopPhase2" action="${pageContext.request.contextPath}//ticketshop" method="post">
  <table border="1">
    <tr>
      <th>#</th>
      <th>Nome Titolare</th>
      <th>Prezzo Biglietto</th>
    </tr>
    <%
      int numeroBiglietti = Integer.parseInt(request.getParameter("numero"));
      float prezzoBiglietto = (float) session.getAttribute("price"); // Prezzo unitario
      for (int i = 1; i <= numeroBiglietti; i++) {
    %>
    <tr>
      <td><%= i %></td>
      <td><input type="text" name="titolare<%= i %>" required></td>
      <td>&euro; <%= prezzoBiglietto %></td>
    </tr>
    <% } %>
  </table>
  <p><strong>Totale:</strong> &euro; <%= numeroBiglietti * prezzoBiglietto %></p>

  <h2>Metodo di Pagamento</h2>
  <label for="carta">Numero di Carta:</label>
  <input type="text" id="carta" name="carta" required><br><br>

  <label for="scadenza">Data di Scadenza:</label>
  <input type="month" id="scadenza" name="scadenza" required><br><br>

  <label for="cvv">CVV:</label>
  <input type="text" id="cvv" name="cvv" required><br><br>

  <button type="submit">Conferma Acquisto</button>
</form>
</body>
</html>
