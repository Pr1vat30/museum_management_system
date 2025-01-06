<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crea Nuova Mostra</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/eventCreator.css">
</head>
<body>
<div class="container">
    <h1>Crea Nuova Mostra</h1>

    <!-- Form di creazione evento -->
    <form id = "eventForm" action="${pageContext.request.contextPath}/eventcreator" method="POST">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required />

        <label for="descrizione">Descrizione:</label>
        <textarea id="descrizione" name="descrizione" required></textarea>

        <label for="startdate">Data Inizio:</label>
        <input type="date" id="startdate" name="startdate" required />

        <label for="enddate">Data Fine:</label>
        <input type="date" id="enddate" name="enddate" required />

        <label for="postiLiberi">Posti Disponibili:</label>
        <input type="number" id="postiLiberi" name="postiLiberi" required />

        <label for="prezzo">Prezzo Biglietto (€):</label>
        <input type="number" step="0.01" id="prezzo" name="prezzo" required />

        <button type="submit">Crea Evento</button>
    </form>
</div>
</body>
</html>
