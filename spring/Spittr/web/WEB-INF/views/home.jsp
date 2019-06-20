<%--
  Created by IntelliJ IDEA.
  User: Masf
  Date: 2019/6/17
  Time: 14:17
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style.css' />">
</head>
<body>
    <h1>Welcome to Spittr</h1>

    <a href="<c:url value="/spittles" />">Spittles</a>
    <a href="<c:url value="/spittr/register" />">Register</a>
</body>
</html>
