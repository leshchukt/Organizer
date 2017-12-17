<%--
  Created by IntelliJ IDEA.
  User: leshchuk.t
  Date: 15.12.2017
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event List</title>
</head>
<body>
    <%=request.getAttribute("event")%>
    <br><br>
    <%=request.getAttribute("eventsByDate")%>
</body>
</html>
