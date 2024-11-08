<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Software</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Create New Software</h2>

    <form action="SoftwareServlet" method="post">
        <label for="name">Software Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" required></textarea><br><br>

        <label for="accessLevels">Access Levels:</label><br>
        <input type="checkbox" name="accessLevels" value="Read"> Read<br>
        <input type="checkbox" name="accessLevels" value="Write"> Write<br>
        <input type="checkbox" name="accessLevels" value="Admin"> Admin<br><br>

        <button type="submit">Create Software</button>
    </form>

    <a href="adminDashboard.jsp">Back to Dashboard</a>
</body>
</html>
