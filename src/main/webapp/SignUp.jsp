<%--
  Created by IntelliJ IDEA.
  User: Skipper
  Date: 22.07.2024
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            box-sizing: border-box;
        }

        h1 {
            margin-bottom: 20px;
            font-size: 24px;
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<form action="/signup" method="post">
    <h1>Sign up</h1>
    <label for="firstName">FirstName</label>
    <input id="firstName" name="firstName" type="text" placeholder="Enter firstName" required>
    <label for="lastName">LastName</label>
    <input id="lastName" name="lastName" type="text" placeholder="Enter lastName" required>
    <label for="age">Age</label>
    <input id="age" name="age" type="number" placeholder="Enter age" required>
    <label for="username">Username</label>
    <input id="username" name="username" type="text" placeholder="Enter username" required>
    <label for="password">Password</label>
    <input id="password" name="password" type="password" placeholder="Enter password" required>
    <label for="email">Email</label>
    <input id="email" name="email" type="email" placeholder="Enter email" required>
    <button type="submit">Sign Up</button>
</form>

</body>
</html>
