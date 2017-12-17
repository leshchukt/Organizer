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
    All events from DB:<br>
    <%=request.getAttribute("events")%>
    <br><br>

    Sorted events:<br>
    <%=request.getAttribute("sortedEvents")%>
    <br><br>

    Find event by date 2018-01-10:<br>
    <%=request.getAttribute("eventsByDate")%>
    <br><br>

    Find event between 2017-12-15 and 2018-01-09:<br>
    <%=request.getAttribute("eventsWithinDates")%>
    <br><br>

    Coming events for next week:<br>
    <%=request.getAttribute("comingEvents")%>

</body>
</html>
