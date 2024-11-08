package com.uams.controller;

import com.uams.model.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RequestServlet")
public class RequestServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        // Get the user ID from the session
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        // If userId is not found in session, redirect to login page
        if (userId == null) {
            response.sendRedirect("login.jsp?error=Please log in first.");
            return;
        }

        // Get form parameters
        String softwareId = request.getParameter("softwareId");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");


        String query = "INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, userId);  // Set the user_id from the session
                stmt.setString(2, softwareId);
                stmt.setString(3, accessType);
                stmt.setString(4, reason);
                stmt.setString(5, "Pending");  // Default status is "Pending"
                stmt.executeUpdate();

                // Redirect to a confirmation page or back to the dashboard
                response.sendRedirect("requestSuccess.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
