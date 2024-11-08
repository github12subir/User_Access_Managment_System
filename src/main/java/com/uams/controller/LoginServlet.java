package com.uams.controller;

import com.uams.model.DatabaseConnection;
import com.uams.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        // Get the input from the user
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the input (you can add further validation if needed)
        if (username == null || password == null) {
            response.sendRedirect("login.jsp?error=Invalid%20username%20or%20password");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Query to get user details by username
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // User exists, now check the password
                    String storedPassword = rs.getString("password");
                    String role = rs.getString("role");

                    // Check if the password matches (using bcrypt)
                    if (BCrypt.checkpw(password, storedPassword)) {
                        // Password is correct, set session and redirect based on role
                        request.getSession().setAttribute("username", username);
                        request.getSession().setAttribute("role", role);

                        if ("Admin".equals(role)) {
                            response.sendRedirect("createSoftware.jsp");
                        } else if ("Manager".equals(role)) {
                            response.sendRedirect("pendingRequests.jsp");
                        } else if("Employee".equals(role)){
                            response.sendRedirect("requestAccess.jsp");
                        }
                    } else {
                        // Password is incorrect
                        response.sendRedirect("login.jsp?error=Invalid%20username%20or%20password");
                    }
                } else {
                    // No user found with the given username
                    response.sendRedirect("login.jsp?error=Invalid%20username%20or%20password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
