<%--
  Created by IntelliJ IDEA.
  User: Skipper
  Date: 22.07.2024
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            flex-direction: column;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            font-size: 16px;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<a class="btn btn-success" href="/login">Log In</a>
<a class="btn btn-success" href="/signup">Sign Up</a>

</body>
</html>
