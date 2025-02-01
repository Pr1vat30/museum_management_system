<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/table.css">
    <title>Events Page</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style = "margin-left: 30px">
    <a href="visitors-nav-servlet?pg=homepage" class="nav-link">
        <i class='bx bx-home-alt icon'></i>
        <span class="link">Homepage</span>
    </a>
</div>
<main class="container-table product">
    <div class="table-header">
        <label>Event Details</label>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Inizio</th>
                <th>Fine</th>
                <th>Posti disponibili</th>
            </tr>
            </thead>
            <tbody class="tbody_event">
            <c:if test="${not empty events}">
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td><c:out value="${event.name}"/></td>
                        <td><c:out value="${event.desc}"/></td>
                        <td><c:out value="${event.start_date}"/></td>
                        <td><c:out value="${event.end_date}"/></td>
                        <td><c:out value="${event.n_seats}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty events}">
                <tr>
                    <td colspan="8">Nessuna mostra disponibile</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</main>
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/scripts/staff_section/event.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
