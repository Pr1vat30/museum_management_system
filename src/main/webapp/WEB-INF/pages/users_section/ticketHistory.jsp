<%--
  Created by IntelliJ IDEA.
  User: ultra
  Date: 22/01/2025
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/navbar.css">
    <title>Shopping Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>
<main>
    <section class="container-table">
        <div class="table-header">
            <label>Ticket History</label>
        </div>

        <div class="table-section">
            <table>
                <thead>
                <tr>
                    <th>Event Title</th>
                    <th>Ticket type</th>
                    <th>Ticket price</th>
                    <th>Purchase date</th>
                </tr>
                </thead>
                <tbody class="tbody_shop">
                <c:if test="${not empty purchases}">
                    <c:forEach var="purchase" items="${purchases}">
                        <tr>
                            <td><c:out value="${purchase.event_name}"/></td>
                            <td><c:out value="${purchase.ticket_type}"/></td>
                            <td><c:out value="${purchase.ticket_price}"/></td>
                            <td><c:out value="${purchase.purchase_date}"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty purchases}">
                    <tr>
                        <td colspan="4">Nessuno storico disponibile</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </section>
</main>

<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>

