<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Access Management System</title>
    <link rel="stylesheet" href="styles.css"> <!-- Optional: Link to an external CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background-color: white;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 300px;
        }
        h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .btn:focus {
            outline: none;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>User Access Management</h1>
        <p>Welcome to the system! Please choose an option:</p>

        <!-- Sign Up Button -->
        <a href="signup.jsp">
            <button class="btn">Sign Up</button>
        </a>

        <!-- Login Button -->
        <a href="login.jsp">
            <button class="btn">Login</button>
        </a>
    </div>

</body>
</html>

