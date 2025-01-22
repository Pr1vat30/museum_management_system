<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/table.css">
    <title>Arts Page</title>
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
        <label>Arts Details</label>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>Nome</th>
                <th>Descrizione</th>
                <th>Artista</th>
                <th>Altezza</th>
                <th>Larghezza</th>
            </tr>
            </thead>
            <tbody class="tbody_arts">
            <c:if test="${not empty arts}">
                <c:forEach var="art" items="${arts}">
                    <tr>
                        <td><c:out value="${art.name}"/></td>
                        <td><c:out value="${art.desc}"/></td>
                        <td><c:out value="${art.artist}"/></td>
                        <td><c:out value="${art.height}"/></td>
                        <td><c:out value="${art.length}"/></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty arts}">
                <tr>
                    <td colspan="6">Nessuna opera disponibile</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</main>
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/scripts/staff_section/arts.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
