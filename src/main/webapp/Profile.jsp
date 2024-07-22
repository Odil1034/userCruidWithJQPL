<%@ page import="uz.pdp.maven.usercruidwithjpql.entity.user.User" %><%--
  Created by IntelliJ IDEA.
  User: Skipper
  Date: 22.07.2024
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%String username = (String) request.getSession().getAttribute("username");%>
<%String password = (String) request.getSession().getAttribute("password");%>
<%String email = (String) request.getSession().getAttribute("email");%>

<h1>Username: <%=username%></h1>
<h1>Password: <%=password%></h1>
<h1>Email: <%=email%></h1>

</body>
</html>
