<%--
  Created by IntelliJ IDEA.
  User: masf
  Date: 2020/3/5
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">Beer Recommendations JSP</h1>
    <p>
        <%
            List styles = (List)request.getAttribute("styles");
            Iterator it = styles.iterator();
            while (it.hasNext()) {
                out.print("<br>try: " + it.next());
            }
        %>
    </p>
</body>
</html>
