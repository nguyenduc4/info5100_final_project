
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
public class DatabaseConnector {
    private final String DB_URL = "jdbc:mysql://localhost:3306/medicaldb?useSSL=false";
    private final String USER = "root";
    private final String DB_PASSWORD = "Cel365";
    
    public DatabaseConnector() { 
        try { 
            Connection conn = DriverManager.getConnection(this.DB_URL, this.USER, this.DB_PASSWORD);
        } catch (SQLException sqle) { 
            System.out.println(sqle);
        } catch (Exception ex) { 
            System.out.println(ex);
        }
    }
}
