package com.mycompany.dao;

import com.mycompany.model.EmergencyContact;
import com.mycompany.model.Health;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.model.Student;

public class StudentDAO {
    private Connection conn;
    private static final String DB_URL = "jdbc:sqlserver://QUANGNGUYEN;databaseName=QLSKSV;useUnicode=true&characterEncoding=UTF-8;user=sa;password=12345;encrypt=true;trustServerCertificate=true";
    
    public StudentDAO() {
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM details";
        
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                students.add(mapRowToStudent(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    
    public List<Student> searchStudents(String studentCode, String fullName) {
        List<Student> students = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM details WHERE 1=1");
        if (studentCode != null && !studentCode.isEmpty()) {
            query.append(" AND studentCode LIKE ?");
        }
        if (fullName != null && !fullName.isEmpty()) {
            query.append(" AND fullName LIKE ?");
        }
        
        try (PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            int paramIndex = 1;
            if (studentCode != null && !studentCode.isEmpty()) {
                stmt.setString(paramIndex++, "%" + studentCode + "%");
            }
            if (fullName != null && !fullName.isEmpty()) {
                stmt.setString(paramIndex, "%" + fullName + "%");
            }
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    students.add(mapRowToStudent(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    
    public boolean deleteStudent(String studentCode) {
        try {
            String[] tables = {"details", "healths", "emergencyContact"};
            for (String table : tables) {
                deleteFromTable(conn, table, studentCode);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void deleteFromTable(Connection connection, String tableName, String studentCode) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE studentCode = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, studentCode);
            stmt.executeUpdate();
        }
    }
    
    public Student getStudentDetails(String studentCode) throws SQLException {
        String query = "SELECT * FROM details WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToStudent(rs);
                }
            }
        }
        return null;
    }

    public Health getStudentHealthDetails(String studentCode) throws SQLException {
        String query = "SELECT * FROM healths WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToHealth(rs);
                }
            }
        }
        return null;
    }

    public EmergencyContact getStudentEmergencyContact(String studentCode) throws SQLException {
        String query = "SELECT * FROM emergencyContact WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToEmergencyContact(rs);
                }
            }
        }
        return null;
    }
    
    public void insertStudentDetails(Student student) throws SQLException{
        String insertDetails = "INSERT INTO details (studentCode, fullName, birth, gender, CCCD, URL) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertDetails)){
            stmt.setString(1, student.getStudentCode());
            stmt.setString(2, student.getFullName());
            stmt.setString(3, student.getBirth());
            stmt.setString(4, student.getGender());
            stmt.setString(5, student.getCCCD());
            stmt.setString(6, student.getURLImageStudent());               
            stmt.executeUpdate();
        }
    }
    
    public void insertStudentHealthDetails(Health health) throws SQLException{
        String insertHealths = "INSERT INTO healths (studentCode, height, weight, bmi, bloodType, healthCode, healthStatus, note) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertHealths)){
            stmt.setString(1, health.getStudentCode());
            stmt.setDouble(2, health.getHeight());
            stmt.setDouble(3, health.getWeight());
            stmt.setString(4, health.getBmi());
            stmt.setString(5, health.getBloodType());
            stmt.setString(6, health.getHealthCode());
            stmt.setString(7, health.getHealthStatus());
            stmt.setString(8, health.getNote());
            stmt.executeUpdate();
        }
    }
    
    public void insertStudentEmergencyContact(EmergencyContact emergencyContact) throws SQLException{
        String insertEmergencyContact = "INSERT INTO emergencyContact (studentCode, fullNameContact, relationshipContact, phoneContact, addressContact) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertEmergencyContact)){
            stmt.setString(1, emergencyContact.getStudentCode());
            stmt.setString(2, emergencyContact.getFullNameContact());
            stmt.setString(3, emergencyContact.getRelationshipContact());
            stmt.setString(4, emergencyContact.getPhoneContact());
            stmt.setString(5, emergencyContact.getAddressContact());
            stmt.executeUpdate();
        }
    }
    
    public void updateStudentDetails(String oldStudentCode, Student student) throws SQLException {
        String query = "UPDATE details SET studentCode = ?, fullName = ?, birth = ?, gender = ?, CCCD = ?, URL = ? WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getStudentCode());
            stmt.setString(2, student.getFullName());
            stmt.setString(3, student.getBirth());
            stmt.setString(4, student.getGender());
            stmt.setString(5, student.getCCCD());
            stmt.setString(6, student.getURLImageStudent());
            stmt.setString(7, oldStudentCode);
            stmt.executeUpdate();
        }
    }

    public void updateStudentHealthDetails(String oldStudentCode, Health health) throws SQLException {
        String query = "UPDATE healths SET studentCode = ?, height = ?, weight = ?, bmi = ?, bloodType = ?, healthCode = ?, healthStatus = ?, note = ? WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, health.getStudentCode());
            stmt.setDouble(2, health.getHeight());
            stmt.setDouble(3, health.getWeight());
            stmt.setString(4, health.getBmi());
            stmt.setString(5, health.getBloodType());
            stmt.setString(6, health.getHealthCode());
            stmt.setString(7, health.getHealthStatus());
            stmt.setString(8, health.getNote());
            stmt.setString(9, oldStudentCode);
            stmt.executeUpdate();
        }
    }

    public void updateStudentEmergencyContact(String oldStudentCode, EmergencyContact emergencyContact) throws SQLException {
        String query = "UPDATE emergencyContact SET studentCode = ?, fullNameContact = ?, relationshipContact = ?, phoneContact = ?, addressContact = ? WHERE studentCode = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emergencyContact.getStudentCode());
            stmt.setString(2, emergencyContact.getFullNameContact());
            stmt.setString(3, emergencyContact.getRelationshipContact());
            stmt.setString(4, emergencyContact.getPhoneContact());
            stmt.setString(5, emergencyContact.getAddressContact());
            stmt.setString(6, oldStudentCode);
            stmt.executeUpdate();
        }
    }

    private Student mapRowToStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setStudentCode(rs.getString("studentCode"));
        student.setFullName(rs.getString("fullName"));
        student.setBirth(rs.getString("birth"));
        student.setGender(rs.getString("gender"));
        student.setCCCD(rs.getString("CCCD"));
        student.setURLImageStudent(rs.getString("URL"));
        return student;
    }

    private Health mapRowToHealth(ResultSet rs) throws SQLException {
        Health health = new Health();
        health.setStudentCode(rs.getString("studentCode"));
        health.setHeight(rs.getInt("height"));
        health.setWeight(rs.getInt("weight"));
        health.setBmi(rs.getString("bmi"));
        health.setBloodType(rs.getString("bloodType"));
        health.setHealthCode(rs.getString("healthCode"));
        health.setHealthStatus(rs.getString("healthStatus"));
        health.setNote(rs.getString("note"));
        return health;
    }

    private EmergencyContact mapRowToEmergencyContact(ResultSet rs) throws SQLException {
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setStudentCode(rs.getString("studentCode"));
        emergencyContact.setFullNameContact(rs.getString("fullNameContact"));
        emergencyContact.setRelationshipContact(rs.getString("relationshipContact"));
        emergencyContact.setPhoneContact(rs.getString("phoneContact"));
        emergencyContact.setAddressContact(rs.getString("addressContact"));
        return emergencyContact;
    }
    
    public void close() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
