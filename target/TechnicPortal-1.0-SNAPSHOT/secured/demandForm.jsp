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
        <c:if test="${demand == null}">
        <form action="insert" method="get">
            </c:if>
            <table border="1" cellpadding="5">

                <tr>
                    <th>Запит:</th>
                    <td>
                        <label>
                            <select name="dep">
                                <c:forEach var="department" items="${depDropdown}">
                                    <option value="${department.id}">${department.nameDepartment}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <br>
                        <%--<input type="text" name="message" size="45" value="<c:out value='${demand.message}'/>"/>--%>
                        <label>
                            <textarea type="text" name="message" cols="69" rows="4" maxlength="190" required
                                      value="<c:out value='${demand.message}'/>"></textarea>
                        </label>
                    </td>
                </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </table>
        </form>
    </div>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>
