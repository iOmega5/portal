<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/responsive-slider.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.css"/>" rel="stylesheet">
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <div class="navbar-brand">
                            <% String dpName = (String) session.getAttribute("departmentName"); %>
                            <% if (dpName != null) { %>
                            <h4>${sessionScope.departmentName},
                                <a href="${pageContext.request.contextPath}/logout">Вихід</a></h4>
                            <% } else { %>
                            <h4><a href="login.jsp">Вхід</a></h4>
                            <% } %>
                        </div>
                    </div>
                    <div class="menu">
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="index.jsp">Головна</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/new">Додати
                                запит</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/list">Активні
                                запити</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/archive">Архів
                                запитів</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/listip">Ip запитів</a>
                            </li>
                            <li role="presentation"><a href="secured/administration.xhtml">Админка</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</header>
</body>
</html>