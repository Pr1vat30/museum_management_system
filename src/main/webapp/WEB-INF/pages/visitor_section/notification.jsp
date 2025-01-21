<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/table.css">
    <title>Notification Page</title>
</head>
<body>
<header> <jsp:include page="header.jsp"/></header>
<main>
    <section class="container-table">
        <div class="table-header">
            <label>Notifications Section</label>
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
                                <button onclick="openDetails('${message.message_id}', '${message.title}', '${message.content}')">
                                    <i class='bx bx-detail icon'></i>
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

<div id="details-panel" class="poUp-panel">
    <div class="form-content">
        <input type="hidden" id="details-Id" name="id">
        <span class="close" onclick="closeDetails()">&times;</span>
        <h2 id="details-entity"></h2>
        <div id="details-content">
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/scripts/users_section/notification.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
<jsp:include page="footer.jsp"/>
</body>
</html>
