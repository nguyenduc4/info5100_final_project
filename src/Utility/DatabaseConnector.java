package Utility;


import Model.Room;
import java.sql.*;

import Model.User;
import java.util.ArrayList;

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

    
    
    public void Login(String username, String password){ 
        
        return;
    }
    
    public static ArrayList<Room> get_all_reservation() {
        ArrayList<Room> rooms = new ArrayList();
        String QUERY = "SELECT r2.room_id, r2.hotel_id, r2.name, r2.type, r2.status, r2.price , r.confirm FROM Reservation r \n" +
"	INNER JOIN Hotel h ON r.hotel_id = h.hotel_id \n" +
"	INNER JOIN Room r2 ON r.room_id = r2.room_id ORDER BY status;";
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
