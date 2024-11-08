package com.uams.controller;

import com.uams.model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/ApprovalServlet")  // Maps to "/ApprovalServlet" URL
public class ApprovalServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");  // "approve" or "reject"

        String status = "Rejected";
        if ("approve".equalsIgnoreCase(action)) {
            status = "Approved";
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE requests SET status = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, status);
                stmt.setInt(2, requestId);
                stmt.executeUpdate();
            }
            response.sendRedirect("pendingRequests.jsp?success=Request " + status);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
