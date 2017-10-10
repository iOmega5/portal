<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styleLogin.css"/>">
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="resources/js/index.js"></script>

    <title>Портал ОАСУП</title>
</head>
<body>
<br>
<center>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="login-page">
            <div class="form">
                <form class="login-form">
                    <input type="text" placeholder="відділ" name="login"/>
                    <input type="password" placeholder="пароль" name="password"/>
                    <button>Увійти</button>
                    <p class="message">Повернутися на <a href="index.jsp">Головну</a></p>
                </form>
            </div>
        </div>
    </form>
</center>
</body>
</html>