/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */

public class UserDAO {
    public Users user;
    public String userLog, roleUserLog;
    
    private Connection conn;
    private static final String DB_URL = "jdbc:sqlserver://QUANGNGUYEN;databaseName=QLSKSV;useUnicode=true&characterEncoding=UTF-8;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
    
    public UserDAO() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            boolean isFirstRow = true; 
            while (rs.next()) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue; 
                }
                users.add(mapRowToUsers(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }
    
    public Users getAuthenticatedUser(String email, String password) {
        user = null;
        String dbURL = "jdbc:sqlserver://QUANGNGUYEN;databaseName=QLSKSV;user=sa;password=12345;encrypt=true;trustServerCertificate=true";

        try {
            Connection conn = DriverManager.getConnection(dbURL);

            String sql = "SELECT * FROM users WHERE email COLLATE SQL_Latin1_General_CP1_CS_AS = ? AND password COLLATE SQL_Latin1_General_CP1_CS_AS = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.firstName = resultSet.getString("firstname");
                user.lastName = resultSet.getString("lastName");
                user.email = resultSet.getString("email");
                user.password = resultSet.getString("password");
                user.roleUser = resultSet.getString("roleUser");

                if (user.firstName == null) {
                    user.firstName = "";
                    userLog = user.lastName;
                } else {
                    userLog = user.firstName + " " + user.lastName;
                }

                if (user.roleUser == null) {
                    user.roleUser = "USER";
                }

                roleUserLog = user.roleUser;
            }

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public Users addUserToDatabase(String firstName, String lastName, String email, String password) {
        user = null;

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "INSERT INTO users (firstName, lastName, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);

                int addedRows = preparedStatement.executeUpdate();
                if (addedRows > 0) {
                    user = new Users();
                    user.firstName = firstName;
                    user.lastName = lastName;
                    user.email = email;
                    user.password = password;
                    JOptionPane.showMessageDialog(null, "User added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add user.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean isEmailAlreadyExist(String email) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                try (ResultSet resultSet = stmt.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void deleteFromTable(String tableName, String studentCode) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "DELETE FROM " + tableName + " WHERE email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, studentCode);

                stmt.close();
            }
        }
    }
    
    private Users mapRowToUsers(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRoleUser(rs.getString("roleUser"));
        return user;
    }
    
    public void updateUsers(Users user, String oldEmail) throws SQLException {
        String query = "UPDATE users SET firstName=?, lastName=?, email=?, password=?, roleUser=? WHERE email=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRoleUser());
            stmt.setString(6, oldEmail);
            
            int rowsUpdated = stmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "User updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update user.");
            }
        }
    }
    
    public void updateRoleInDatabase(String email, String newRole) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "UPDATE users SET roleUser = ? WHERE email = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newRole);
                pstmt.setString(2, email);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Role updated successfully in database.");
                } else {
                    System.out.println("Failed to update role in database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating role in database: " + e.getMessage());
        }
    }
    
    public void addUserRequest(String email) {
        try {
            Users user = getUserByEmail(email);
            if (user != null) {
                String sql = "INSERT INTO requestFromUsers (email, firstName, lastName, roleUser) VALUES (?, ?, ?, ?)";

                try (Connection conn = DriverManager.getConnection(DB_URL);
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, user.getEmail());
                    pstmt.setString(2, user.getLastName());
                    pstmt.setString(3, user.getFirstName());
                    pstmt.setString(4, user.getRoleUser());
                    
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "The request has been sent to the server");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed sending request to server");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("User with email " + email + " not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Users getUserByEmail(String email) {
        Users user = null;
        String query = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = mapRowToUsers(rs);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
      
    public List<Users> getAllUserRequest() {
        List<Users> userRequests = new ArrayList<>();
        String query = "SELECT * FROM requestFromUsers";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Users user = new Users();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setRoleUser(rs.getString("roleUser"));

                userRequests.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userRequests;
    }
    
    public void deleteUserRequest(String email) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "DELETE FROM requestFromUsers WHERE email = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);

                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "The request has been successfully updated to email: " + email);
                } else {
                    JOptionPane.showMessageDialog(null, "No request found to delete for email: " + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting request from database: " + e.getMessage());
        }
    }
    
    public int countUsersInRequestTable() {
        int count = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT COUNT(*) AS total FROM requestFromUsers";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error counting users in request table: " + e.getMessage());
        }
        return count;
    }
    
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
