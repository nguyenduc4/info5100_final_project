package Utility;


import Model.Room;
import java.sql.*;

import Model.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management_final_project?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String DB_PASSWORD = "root";

    public static ArrayList<User> get_all_Agency_stuff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void remove_user(int userId) {
        String query = "DELETE FROM User WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);

            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error removing user: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update_user(User user) {
        String query = "UPDATE User SET username = ?, phone_num = ?, role = ?" +
                       (user.get_password() != null ? ", password = ?" : "") + // 如果密码非空，则更新
                       " WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.get_username());
            stmt.setString(2, user.get_phone_num());
            stmt.setString(3, user.get_role());

            int paramIndex = 4;
            if (user.get_password() != null) {
                stmt.setString(paramIndex++, user.get_password());
            }

            stmt.setInt(paramIndex, user.get_user_id());

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error updating user: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static void add_user(User user) {
        String query = "INSERT INTO User (username, password, phone_num, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.get_username());
            stmt.setString(2, user.get_password());
            stmt.setString(3, user.get_phone_num());
            stmt.setString(4, user.get_role());

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error adding user: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static ArrayList<User> get_all_agency_admin_and_staff() {
        ArrayList<User> users = new ArrayList<>();
        String QUERY = "SELECT * FROM User WHERE role IN ('AgencyStaff', 'AgencyAdmin')";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                User u = new User();
                u.set_user_id(rs.getInt("user_id"));
                u.set_username(rs.getString("username"));
                u.set_phone_num(rs.getString("phone_num"));
                u.set_role(rs.getString("role"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return users;
    }



    public static ArrayList<Room> get_filtered_reservation(String roomID, String hotelID, String name, String type, String status) {
        ArrayList<Room> rooms = new ArrayList<>();
        StringBuilder QUERY = new StringBuilder(
            "SELECT r2.room_id, r2.hotel_id, r2.name, r2.type, r.status, r2.price, r.confirm " +
            "FROM Reservation r " +
            "INNER JOIN Hotel h ON r.hotel_id = h.hotel_id " +
            "INNER JOIN Room r2 ON r.room_id = r2.room_id WHERE 1=1"
        );

        // Append filters dynamically
        if (!roomID.isEmpty()) {
            QUERY.append(" AND r2.room_id = ").append(roomID);
        }
        if (!hotelID.isEmpty()) {
            QUERY.append(" AND r2.hotel_id = ").append(hotelID);
        }
        if (!name.isEmpty()) {
            QUERY.append(" AND r2.name LIKE '%").append(name).append("%'");
        }
        if (!type.isEmpty()) {
            QUERY.append(" AND r2.type LIKE '%").append(type).append("%'");
        }
        if (!status.equals("All")) {
            QUERY.append(" AND r.status = '").append(status).append("'");
        }
        QUERY.append(" ORDER BY r.status;");

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY.toString())) {

            while (rs.next()) {
                Room r = new Room();
                r.set_room_id(rs.getInt("room_id"));
                r.set_hotel_id(rs.getInt("hotel_id"));
                r.set_name(rs.getString("name"));
                r.set_type(rs.getString("type"));
                r.set_status(rs.getString("status"));
                r.set_price(rs.getFloat("price"));
                r.set_approved(rs.getInt("confirm"));
                rooms.add(r);
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Exception: " + sqle.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rooms;
    }



    
    
    public void Login(String username, String password){ 
        
        return;
    }
    
    public static ArrayList<Room> get_all_reservation() {
        ArrayList<Room> rooms = new ArrayList();
        String QUERY = "SELECT r2.room_id, r2.hotel_id, r2.name, r2.type, r.status, r2.price , r.confirm \n" +
                        "FROM Reservation r\n" +
                        "INNER JOIN Hotel h ON r.hotel_id = h.hotel_id\n" +
                        "INNER JOIN Room r2 ON r.room_id = r2.room_id\n" +
                        "ORDER BY r.status;";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            
            while(rs.next()) { 
                Room r = new Room() ;
                r.set_room_id(Integer.parseInt(rs.getString("room_id")));
                r.set_hotel_id(Integer.parseInt(rs.getString("hotel_id")));
                System.out.println(rs.getString("name"));
                r.set_name(rs.getString("name"));
                r.set_type(rs.getString("type"));
                r.set_status(rs.getString("status"));
                r.set_price(Float.parseFloat(rs.getString("price")));
                r.set_approved(Integer.parseInt(rs.getString("confirm")));
                rooms.add(r);
            }
            rs.close();
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
        return rooms;
    }
    
    public static void update_reservation(Room room) { 
        String QUERY = "UPDATE Room SET name = ?, type = ?, price = ? WHERE room_id=?";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            System.out.println(room.get_name()  + "?????");
            
            stmt.setString(1, room.get_name());
            stmt.setString(2, room.get_type());
            stmt.setString(3, String.valueOf(room.get_price()));
            stmt.setInt(4, room.get_room_id());
            
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void approve_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET confirm = 1 WHERE room_id=?";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            stmt.setInt(1, room_id);
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void reject_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET confirm = 0 WHERE room_id=?";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            stmt.setInt(1, room_id);
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void update_reservation_status(int room_id, String newStatus) {
        String QUERY = "UPDATE Reservation SET status = ? WHERE room_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(QUERY)) {

            stmt.setString(1, newStatus);
            stmt.setInt(2, room_id);

            int rows = stmt.executeUpdate();
            System.out.println("Rows updated : " + rows);

        } catch (SQLException sqle) {
            System.out.println("SQL Exception: " + sqle.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}