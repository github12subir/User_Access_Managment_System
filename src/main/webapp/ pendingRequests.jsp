<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pending Requests</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Pending Access Requests</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Employee</th>
                <th>Software</th>
                <th>Access Type</th>
                <th>Reason</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Sample data: Replace with dynamic data from database -->
            <tr>
                <td>John Doe</td>
                <td>Software 1</td>
                <td>Write</td>
                <td>Need access for project work</td>
                <td>
                    <form action="ApprovalServlet" method="post">
                        <input type="hidden" name="requestId" value="1">
                        <button type="submit" name="action" value="approve">Approve</button>
                        <button type="submit" name="action" value="reject">Reject</button>
                    </form>
                </td>
            </tr>
            <!-- More requests go here -->
        </tbody>
    </table>

    <a href="managerDashboard.jsp">Back to Dashboard</a>
</body>
</html>
