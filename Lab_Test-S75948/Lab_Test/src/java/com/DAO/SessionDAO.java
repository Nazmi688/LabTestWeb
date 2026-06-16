/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Model.SessionBean;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MP2-4
 */
public class SessionDAO {

    public static List<SessionBean> ArrayList;

    private String jdbcURL = "jdbc:mysql://localhost:3306/drivesmart_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void bookSession(SessionBean session) throws SQLException {
        String sql = "INSERT INTO trainning_session(session_id,student_name,branch_location,lesson_type,status)VALUES (?,?,?,?,?)";
        try (Connection conn = getConnection();
                PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1, session.getStudent_name());
            psmt.setString(2, session.getBranch_location());
            psmt.setString(3, session.getLesson_type());
            psmt.setString(4, session.getStatus());
        }
    }

    public void getAllSession(String branch_location) throws SQLException {
        String sql = "SELECT * FROM Training_Sessions ORDER BY branch_location ASC";
        try (Connection conn = getConnection();
                PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1, branch_location);
            Resultset test = (Resultset) psmt.executeQuery();
        }
    }
    /**;
     *
     * @return
     */
    public List<SessionBean> getAllSession(){
            List<SessionBean> session = new ArrayList<>();
            String sql = "SELECT * FROM users";
            try (Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet test1 = pstmt.executeQuery();
                while (test1.next()) {
                    int id = test1.getInt("Session_Id");
                    String student_name = test1.getString("student_name");
                    String branch_location = test1.getString("branch_location");
                    String lesson_type = test1.getString("lesson_type");
                    String status = test1.getString("status");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
            
        
        
    }
}