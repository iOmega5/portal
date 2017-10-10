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
                <th>IP КОМП`ЮТЕРА</th>
                <th>УНІКАЛЬНИЙ НОМЕР ЗАПИТУ</th>
            </tr>

            <c:forEach var="demandip" items="${listIpDemand}">
                <tr>
                    <td><c:out value="${demandip.ipAddress}"/></td>
                    <td><c:out value="${demandip.unicNumberDemand}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>