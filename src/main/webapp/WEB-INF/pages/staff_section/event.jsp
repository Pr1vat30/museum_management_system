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
    <title>Events Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<main class="container-table product">
    <div class="table-header">
        <label>Event Details</label>
        <div>
            <button class="button-field" onclick="openInsert()">Add event +</button>
        </div>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>desc</th>
                <th>start date</th>
                <th>end date</th>
                <th>total seats</th>
                <th>available seats</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody class="tbody_event">
            <c:if test="${not empty events}">
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td><c:out value="${event.event_id}"/></td>
                        <td><c:out value="${event.name}"/></td>
                        <td><c:out value="${event.desc}"/></td>
                        <td><c:out value="${event.start_date}"/></td>
                        <td><c:out value="${event.end_date}"/></td>
                        <td><c:out value="${event.n_seats}"/></td>
                        <td><c:out value="${event.n_seats_available}"/></td>

                        <td>
                            <button onclick="openUpdate('${event.event_id}', '${event.name}', '${event.desc}',
                                    '${event.start_date}', '${event.end_date}')">
                                <i class='bx bxs-edit icon'></i>
                            </button>
                            <button onclick="deleteResource('${event.event_id}')">
                                <i class='bx bx-trash icon'></i>
                            </button>
                        </td>
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

<div id="insert-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeInsert()">&times;</span>
        <h2 id="insert-entity">Insert Event</h2>

        <form id="insert-form" action="#">

            <div class="field">
                <label>Event name</label>
                <input type="text" id="insert-name" name="name">
            </div>

            <div class="field">
                <label>Event desc</label>
                <input type="text" id="insert-desc" name="desc">
            </div>

            <div class="field">
                <label>Total seats</label>
                <input type="text" id="insert-seats" name="seats">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Start date</label>
                    <input type="date" id="insert-start-date" name="start-date">
                </div>
                <div class="field input-field">
                    <label>End date</label>
                    <input type="date" id="insert-end-date" name="end-date">
                </div>
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Default ticket type</label>
                    <input type="text" id="insert-ticket-type" name="ticket-type">
                </div>
                <div class="field input-field">
                    <label>Default ticket price</label>
                    <input type="text" id="insert-ticket-price" name="ticket-price">
                </div>
            </div>

            <button type="submit">Insert</button>
        </form>
    </div>
</div>

<div id="update-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeUpdate()">&times;</span>
        <h2 id="update-entity">Update Event</h2>

        <form id="update-form" action="#">
            <input type="hidden" id="update-Id" name="id">

            <div class="field">
                <label>Event name</label>
                <input type="text" id="update-name" name="name">
            </div>

            <div class="field">
                <label>Event desc</label>
                <input type="text" id="update-desc" name="desc">
            </div>

            <div class="field">
                <label>Total seats</label>
                <input type="text" id="update-seats" name="seats">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Start date</label>
                    <input type="date" id="update-start-date" name="start-date">
                </div>
                <div class="field input-field">
                    <label>End date</label>
                    <input type="date" id="update-end-date" name="end-date">
                </div>
            </div>

            <button type="submit">Update</button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/scripts/staff_section/event.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
