<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<%@ include file="../header.jsp" %>

<div class="content">
    <div align="center">
        <table border="1" cellpadding="5">

            <tr>
                <th>ДЕПАРТАМЕНТ</th>
                <th>ЗАПИТ</th>
                <th>ДАТА ВІДКРИТТЯ ЗАПИТУ</th>
                <th>ДАТА ЗАКРИТТЯ ЗАПИТУ</th>
                <th>СТАТУС ЗАПИТУ</th>
                <th>УНІКАЛЬНИЙ НОМЕР ЗАПИТУ</th>
            </tr>

            <c:forEach var="demand" items="${listDemandArchive}">
                <tr>
                    <td><c:out value="${demand.fromDemand}"/></td>
                    <td><c:out value="${demand.messageDemand}"/></td>
                    <td><c:out value="${demand.dataOfDemand}"/></td>
                    <td><c:out value="${demand.dataOfDemandEnds}"/></td>
                    <td><c:out value="${demand.statusOfDemand}"/></td>
                    <td><c:out value="${demand.unicNumberOfDemand}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>