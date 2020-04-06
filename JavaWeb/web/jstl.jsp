<%--
  Created by IntelliJ IDEA.
  User: masf
  Date: 2020/3/5
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>

    <table>
        <% String[] items = (String[]) request.getAttribute("movieList");
            String var = null;
            for (int i = 0; i < items.length; ++i) {
                var = items[i];
        %>
        <tr><td><%= var %></td></tr>
        <%}%>
    </table>

</body>
</html>
