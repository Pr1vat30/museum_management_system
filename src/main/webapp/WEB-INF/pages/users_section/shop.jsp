<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 01/02/25
  Time: 10:12
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
            <label>Ticket Store</label>
        </div>

        <div class="table-section">
            <table>
                <thead>
                <tr>
                    <th>Event Title</th>
                    <th>Ticket type</th>
                    <th>Ticket price</th>
                    <th>Available seats</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody class="tbody_shop">
                <c:if test="${not empty shop_items}">
                    <c:forEach var="item" items="${shop_items}">
                        <tr>
                            <td><c:out value="${item.event_name}"/></td>
                            <td><c:out value="${item.ticket_type}"/></td>
                            <td><c:out value="${item.ticket_price}"/></td>
                            <td><c:out value="${item.n_seats_available}"/></td>
                            <td>
                                <button class="button-field" onclick="openShop('${item.event_id}', '${item.event_name}', '${item.ticket_id}', '${item.ticket_type}', '${item.ticket_price}', '${sessionScope.user.id}')">
                                    buy ticket
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty shop_items}">
                    <tr>
                        <td colspan="5">Nessuna notifica disponibile</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </section>
</main>

<div id="shop-panel" class="poUp-panel">
    <div class="form-content">
        <span class="close" onclick="closeShop()">&times;</span>
        <h2 id="shop-entity"></h2>
        <form id="shop-form" action="#">
            <input type="hidden" name="event_id" id="event_id">
            <label id="event-name"></label>
            <input type="hidden" name="ticket_id" id="ticket_id">
            <label id="ticket-type"></label>
            <label id="ticket-price"></label>

            <label> Autenticazione:</label>
            <input type ="password" placeholder="Password" name ="user_password" id="user_password">

            <input type="hidden" name="user_id" id="user_id">
            <button type="submit">Buy</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/scripts/users_section/shop.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
