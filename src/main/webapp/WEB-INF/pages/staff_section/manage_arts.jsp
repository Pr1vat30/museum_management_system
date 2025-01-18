<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 05/01/25
  Time: 19:08
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
    <title>Manage Arts Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<main class="container-table product">
    <div class="table-header">
        <label>Arts Details</label>
        <div>
            <button class="button-field" onclick="openInsert()">Add art +</button>
        </div>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>name</th>
                <th>desc</th>
                <th>artist</th>
                <th>length</th>
                <th>height</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody class="tbody_arts">
            <c:if test="${not empty arts}">
                <c:forEach var="art" items="${arts}">
                    <tr>
                        <td><c:out value="${art.name}"/></td>
                        <td><c:out value="${art.desc}"/></td>
                        <td><c:out value="${art.artist}"/></td>
                        <td><c:out value="${art.length}"/></td>
                        <td><c:out value="${art.height}"/></td>

                        <td>
                            <button onclick="openUpdate('${art.art_id}', '${art.name}', '${art.desc}',
                                    '${art.artist}', '${art.length}', '${art.height}')">
                                <i class='bx bxs-edit icon'></i>
                            </button>
                            <button onclick="deleteResource('${art.art_id}')">
                                <i class='bx bx-trash icon'></i>
                            </button>
                        </td>
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

<div id="insert-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeInsert()">&times;</span>
        <h2 id="insert-entity">Insert Art</h2>

        <form id="insert-form" action="#" enctype="multipart/form-data">

            <div class="field">
                <label>Art name</label>
                <input type="text" id="insert-name" name="name">
            </div>

            <div class="field">
                <label>Art desc</label>
                <input type="text" id="insert-desc" name="desc">
            </div>

            <div class="field">
                <label>Artist</label>
                <input type="text" id="insert-artist" name="artist">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Length</label>
                    <input type="text" id="insert-length" name="length">
                </div>
                <div class="field input-field">
                    <label>Height</label>
                    <input type="text" id="insert-height" name="height">
                </div>
            </div>

            <div class="field input-field">
                <label>Cover</label>
                <input type="file" id="insert-cover" name="cover">
            </div>

            <button type="submit">Insert</button>
        </form>
    </div>
</div>

<div id="update-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeUpdate()">&times;</span>
        <h2 id="update-entity">Update Art</h2>

        <form id="update-form" action="#" enctype="multipart/form-data">
            <input type="hidden" id="update-Id" name="id">

            <div class="field">
                <label>Art name</label>
                <input type="text" id="update-name" name="name">
            </div>

            <div class="field">
                <label>Art desc</label>
                <input type="text" id="update-desc" name="desc">
            </div>

            <div class="field">
                <label>Artist</label>
                <input type="text" id="update-artist" name="artist">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Length</label>
                    <input type="text" id="update-length" name="length">
                </div>
                <div class="field input-field">
                    <label>Height</label>
                    <input type="text" id="update-height" name="height">
                </div>
            </div>

            <div class="field input-field">
                <label>Cover</label>
                <input type="file" id="update-cover" name="cover">
            </div>

            <button type="submit">Update</button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/scripts/staff_section/arts.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/staff_section/navbar.js" defer></script>
</body>
</html>
