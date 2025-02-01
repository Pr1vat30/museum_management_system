<%--
  Created by IntelliJ IDEA.
  User: salvatorenocera
  Date: 28/12/24
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/homepage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/admin_section/navbar.css">
    <title>Dashboard Page</title>
</head>
<body>
<header> <jsp:include page="navbar.jsp"/></header>

<script src="${pageContext.request.contextPath}/scripts/admin_section/navbar.js" defer></script>
</body>
</html>