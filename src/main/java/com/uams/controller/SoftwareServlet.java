package com.uams.controller;

import com.uams.model.DatabaseConnection;
import com.uams.model.Software;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SoftwareServlet")
public class SoftwareServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String accessLevels = request.getParameter("accessLevels");

        Software software = new Software();
        software.setName(name);
        software.setDescription(description);
        software.setAccessLevels(accessLevels);

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, software.getName());
                stmt.setString(2, software.getDescription());
                stmt.setString(3, software.getAccessLevels());
                stmt.executeUpdate();
            }
            response.sendRedirect("createSoftware.jsp?success=Software created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
