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
    <title>Manage Staff Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<main class="container-table product">
    <div class="table-header">
        <label>Staff Details</label>
        <div>
            <button class="button-field" onclick="openInsert()">Add staff +</button>
        </div>
    </div>

    <div class="table-section">
        <table>
            <thead>
            <tr>
                <th>full name</th>
                <th>email</th>
                <th>cf</th>
                <th>salary</th>
                <th>contract</th>
                <th>actions</th>
            </tr>
            </thead>
            <tbody class="tbody_staff">
            <c:if test="${not empty staff}">
                <c:forEach var="staff" items="${staff}">
                    <tr>
                        <td><c:out value="${staff.name} ${staff.surname}"/></td>
                        <td><c:out value="${staff.email}"/></td>
                        <td><c:out value="${staff.staff_cf}"/></td>
                        <td><c:out value="${staff.salary}"/></td>
                        <td><c:out value="${staff.contract}"/></td>
                        <td>
                            <button onclick="openUpdate('${staff.staff_id}', '${staff.name}', '${staff.surname}',
                                    '${staff.email}', '${staff.staff_cf}', '${staff.salary}', '${staff.contract}', '${staff.password}')">
                                <i class='bx bxs-edit icon'></i>
                            </button>
                            <button onclick="deleteResource('${staff.staff_id}')">
                                <i class='bx bx-trash icon'></i>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty staff}">
                <tr>
                    <td colspan="6">Nessuno staff disponibile</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</main>

<div id="update-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeUpdate()">&times;</span>
        <h2>Update Staff</h2>

        <form id="update-form" action="#">
            <input type="hidden" id="update-Id" name="id">

            <div class="column">
                <div class="field input-field">
                    <label>Name</label>
                    <input type="text" id="update-name" name="name">
                </div>
                <div class="field input-field">
                    <label>Surname</label>
                    <input type="text" id="update-surname" name="surname">
                </div>
            </div>

            <div class="field input-field">
                <label>Email</label>
                <input type="text" id="update-email" name="email">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Cf</label>
                    <input type="text" id="update-cf" name="cf">
                </div>
                <div class="field input-field">
                    <label>Password</label>
                    <input type="text" id="update-password" name="password">
                </div>
            </div>

            <div class="column">

                <div class="field input-field">
                    <label>Salary</label>
                    <input type="text" id="update-salary" name="salary">
                </div>

                <div class="field input-field">
                    <label>Contract</label>
                    <select name="contract" id="update-contract">
                        <option value="Full-time">Full-time</option>
                        <option value="Part-time">Part-time</option>
                        <option value="Stage">Stage</option>
                    </select>
                </div>

            </div>

            <button type="submit">Insert</button>
        </form>
    </div>
</div>

<div id="insert-panel" class="poUp-panel">
    <div class="form-content product">
        <span class="close" onclick="closeInsert()">&times;</span>
        <h2>Insert New Staff</h2>

        <form id="insert-form" action="#">

            <div class="column">
                <div class="field input-field">
                    <label>Name</label>
                    <input type="text" id="insert-name" name="name">
                </div>
                <div class="field input-field">
                    <label>Surname</label>
                    <input type="text" id="insert-surname" name="surname">
                </div>
            </div>

            <div class="field input-field">
                <label>Email</label>
                <input type="text" id="insert-email" name="email">
            </div>

            <div class="column">
                <div class="field input-field">
                    <label>Cf</label>
                    <input type="text" id="insert-cf" name="cf">
                </div>
                <div class="field input-field">
                    <label>Password</label>
                    <input type="text" id="insert-password" name="password">
                </div>
            </div>

            <div class="column">

                <div class="field input-field">
                    <label>Salary</label>
                    <input type="text" id="insert-salary" name="salary">
                </div>

                <div class="field input-field">
                    <label>Contract</label>
                    <select name="contract" id="insert-contract">
                        <option value="Full-time">Full-time</option>
                        <option value="Part-time">Part-time</option>
                        <option value="Stage">Stage</option>
                    </select>
                </div>

            </div>

            <button type="submit">Insert</button>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/scripts/admin_section/staff.js" defer></script>
<script src="${pageContext.request.contextPath}/scripts/admin_section/navbar.js" defer></script>
</body>
</html>
