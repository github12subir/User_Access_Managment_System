package com.uams.controller;
import com.uams.model.DatabaseConnection;
import com.uams.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SignUpServlet")  // This annotation maps the URL to this servlet class

public class SignUpServlet extends javax.servlet.http.HttpServlet{

    // This method handles POST requests to the SignUpServlet
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        // Get the input from the user
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hash the password using BCrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        // Create a new User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setRole("Employee");

        // Insert the new user into the database
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, hashedPassword);
                stmt.setString(3, user.getRole());
                stmt.executeUpdate();
            }
            // Redirect to login page after successful registration
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
