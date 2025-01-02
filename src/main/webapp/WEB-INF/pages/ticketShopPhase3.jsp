<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conferma Acquisto</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="container">
    <div class="confirmation-box">
        <h1>Grazie per il tuo acquisto!</h1>
        <p>I tuoi biglietti sono stati acquistati con successo.</p>
        <div class="details">
            <p><strong>Numero di biglietti:</strong> <%=request.getAttribute("numero")%></p>
            <p><strong>Evento:</strong> <%=request.getAttribute("eventoAcquistato")%></p>
            <p><strong>Data:</strong> <%=request.getParameter("data")%></p>
        </div>
        <p class="info">Puoi visualizzare i dettagli dei tuoi acquisti nella sezione "Storico Acquisti".</p>
        <a href="WEB-INF//storico-biglietti" class="btn">Vai allo Storico Acquisti</a>
    </div>
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>

