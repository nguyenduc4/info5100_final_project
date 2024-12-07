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
    private static final String DB_PASSWORD = "Cel365";

    public static ArrayList<User> get_all_Agency_stuff() {
        ArrayList<User> users = new ArrayList();
        String QUERY = "SELECT * FROM User;";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            
            while(rs.next()) { 
                User r = new User() ;
                r.set_user_id(Integer.parseInt(rs.getString("user_id")));
                r.set_username(rs.getString("username"));
                r.set_password(rs.getString("password"));
                r.set_phone_num(rs.getString("phone_num"));
                r.set_role(rs.getString("role"));
                users.add(r);
            }
            rs.close();
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
        return users;
    }
    
    public static void update_agency_staff(User user ) { 
        String QUERY = "UPDATE User SET password = ?, phone_num = ?, role = ? WHERE user_id=?";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            
            stmt.setString(1, user.get_password());
            stmt.setString(2, user.get_phone_num());
            stmt.setString(3, user.get_role());
            stmt.setInt(4, user.get_user_id());
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void remove_agency_staff(User user ) { 
        String QUERY = "DELETE FROM User WHERE user_id = ?;";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            stmt.setInt(1, user.get_user_id());
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void add_agency_staff(User user ) { 
        String QUERY = "insert into User (username, password, phone_num, role) values (?, ?, ?, ?);";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            
            stmt.setString(1, user.get_username());
            stmt.setString(2, user.get_password());
            stmt.setString(3, user.get_phone_num());
            stmt.setString(4, user.get_role());
            
            int rows = stmt.executeUpdate();

            System.out.println("Rows updated : " + rows);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    
    public void Login(String username, String password){ 
        
        return;
    }
    
    public static ArrayList<Room> get_all_reservation() {
        ArrayList<Room> rooms = new ArrayList();
        String QUERY = "SELECT r2.room_id, r2.hotel_id, r2.name, r2.type, r2.price , r.status FROM Reservation r \n" +
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
        String QUERY = "UPDATE Room SET name = ?, type = ?, price = ?, status = ? WHERE room_id=?";
        String RESERVATION_QUERY = "UPDATE Reservation SET status = ? WHERE room_id=?;";
        try{  
            Connection conn = DriverManager.getConnection(DB_URL, USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            PreparedStatement stmt1 = conn.prepareStatement(RESERVATION_QUERY);
            
            stmt.setString(1, room.get_name());
            stmt.setString(2, room.get_type());
            stmt.setFloat(3, room.get_price());
            stmt.setString(4, room.get_status());
            stmt.setInt(5, room.get_room_id());
            
            stmt1.setString(1, room.get_status());
            stmt1.setInt(2, room.get_room_id());
            
            
            int rows = stmt.executeUpdate();
            int rows1 = stmt1.executeUpdate();

            System.out.println("Rows Room updated : " + rows);
            System.out.println("Rows Reservation updated : " + rows1);
            
            conn.close() ;
        }catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
    
    public static void approve_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET status = 'Unpaid' WHERE room_id=?";
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
        String QUERY = "UPDATE Reservation SET status = 'Empty' WHERE room_id=?";
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
    
    public static void check_in_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET status = 'Checked in' WHERE room_id=?";
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
    
    public static void check_out_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET status = 'Unclean' WHERE room_id=?";
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
    
    public static void clean_reservation(int room_id){ 
        String QUERY = "UPDATE Reservation SET status = 'Empty' WHERE room_id=?";
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
}
