<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 20/01/25
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/navbar.css">
    <title>Ticket Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<main class="container-table product">
    <div class="table-header">
        <label>Ticket Details</label>
        <div>
            <button class="button-field" onclick="openInsert()">Add ticket +</button>
        </div>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>ticket id</th>
                <th>type</th>
                <th>price</th>
                <th>related event</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody class="tbody_ticket">
            <c:if test="${not empty tickets}">
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <td><c:out value="${ticket.ticket_id}"/></td>
                        <td><c:out value="${ticket.type}"/></td>
                        <td><c:out value="${ticket.price}"/></td>
                        <td><c:out value="${ticket.event_id}"/></td>

                        <td>
                            <button onclick="openUpdate('${product.id}', '${product.name}', '${product.price}',
                                    '${product.quantity}', '${product.description}')">
                                <i class='bx bxs-edit icon'></i>
                            </button>
                            <button onclick="deleteResource('${ticket.ticket_id}')">
                                <i class='bx bx-trash icon'></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty tickets}">
                <tr>
                    <td colspan="5">Nessun ticket disponibile</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</main>

<script src="${pageContext.request.contextPath}/scripts/staff_section/ticket.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
