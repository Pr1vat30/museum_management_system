<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biglietto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/ticket.css">
</head>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>
<div class="ticket">
    <h2><%=request.getAttribute("titolare")%></h2>
    <img src="<%=request.getAttribute("qrcode")%>" alt="Codice QR del Biglietto" />
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>

