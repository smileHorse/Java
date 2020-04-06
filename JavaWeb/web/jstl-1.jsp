<%--
  Created by IntelliJ IDEA.
  User: masf
  Date: 2020/3/5
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <strong> Movie List: </strong>
    <br><br>

    <table>
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td>${movie}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
