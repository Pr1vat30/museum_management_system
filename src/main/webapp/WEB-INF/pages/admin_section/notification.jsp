<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 28/12/24
  Time: 20:49
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
    <title>Notification Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<main>
    <section class="container-table">
        <div class="table-header">
            <label>Notifications Section</label>
            <button class="button-field" onclick="openInsert('notification')">Add notification +</button>
        </div>

        <div class="table-section">
            <table>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Object</th>
                    <th>Created at</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody class="tbody_notification">
                <c:if test="${not empty messages}">
                    <c:forEach var="message" items="${messages}">
                        <tr>
                            <td><c:out value="${message.title}"/></td>
                            <td><c:out value="${message.object}"/></td>
                            <td><c:out value="${message.send_date}"/></td>
                            <td>
                                <button onclick="openUpdate('${message.message_id}', '${message.title}', '${message.object}', '${message.content}' ,'notification')">
                                    <i class='bx bxs-edit icon'></i>
                                </button>
                                <button onclick="deleteResource('notification', ${message.message_id})">
                                    <i class='bx bx-trash icon'></i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty messages}">
                    <tr>
                        <td colspan="4">Nessuna notifica disponibile</td>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </div>
    </section>
</main>

<div id="insert-panel" class="poUp-panel">
    <div class="form-content">
        <span class="close" onclick="closeInsert()">&times;</span>
        <h2 id="insert-entity"></h2>
        <form id="insert-form" action="#">
            <label for="insert-title">Title:</label>
            <input type="text" id="insert-title" name="title" required>
            <label for="insert-object">Object:</label>
            <input type="text" id="insert-object" name="object" required>
            <label for="insert-content">Content:</label>
            <textarea id="insert-content" name="content" required></textarea>
            <button type="submit">Insert</button>
        </form>
    </div>
</div>

<div id="update-panel" class="poUp-panel">
    <div class="form-content">
        <span class="close" onclick="closeUpdate()">&times;</span>
        <h2 id="update-entity"></h2>
        <form id="update-form" action="#">
            <input type="hidden" id="update-Id" name="id">

            <label for="update-title">Title:</label>
            <input type="text" id="update-title" name="title" required>

            <label for="update-object">Object:</label>
            <input type="text" id="update-object" name="object" required>

            <label for="update-content">Content:</label>
            <textarea id="update-content" name="content" required></textarea>

            <button type="submit">Update</button>
        </form>
    </div>
</div>

<div id="details-panel" class="poUp-panel">
    <div class="form-content">
        <input type="hidden" id="details-Id" name="id">
        <span class="close" onclick="">&times;</span>
        <h2 id="details-entity"></h2>
        <div id="details-content">

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/scripts/admin_section/navbar.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/admin_section/notification.js" defer></script>

</body>
</html>
