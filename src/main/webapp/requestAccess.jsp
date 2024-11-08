<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Access</title>
    <style>
        /* General Page Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        /* Form Container */
        form {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        /* Label and Input Fields */
        label {
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }

        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        select:focus,
        textarea:focus {
            border-color: #5c9df6;
            outline: none;
        }

        button {
            background-color: #5c9df6;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #4a8de6;
        }

        /* Link Styling */
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #5c9df6;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        /* Textarea Custom Styling */
        textarea {
            height: 100px;
            resize: vertical;
        }
    </style>
</head>
<body>
    <div class="request-access-container">
        <h2>Request Access to Software</h2>
        <form action="RequestServlet" method="post">
            <label for="software">Select Software:</label><br>
            <select name="softwareId" id="software" required>
                <!-- Dynamically populated with software names from database -->
                <option value="1">Software 1</option>
                <option value="2">Software 2</option>
                <option value="3">Software 3</option>
            </select><br><br>

            <label for="accessType">Access Type:</label><br>
            <select name="accessType" id="accessType" required>
                <option value="Read">Read</option>
                <option value="Write">Write</option>
                <option value="Admin">Admin</option>
            </select><br><br>

            <label for="reason">Reason for Request:</label><br>
            <textarea name="reason" id="reason" required></textarea><br><br>

            <button type="submit">Submit Request</button>
        </form>

        <a href="employeeDashboard.jsp">Back to Dashboard</a>
    </div>
</body>
</html>
