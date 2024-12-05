/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author danie
 */
public class User {
    private int user_id;
    private String username;
    private String password;
    private String phone_num;
    private String role; // only "CUSTOMER", "RECEPTIONIST", "STAFF", "ADMIN"
    
    public User(String username, String password, String phone_num , String role)  { 
        this.username = username;
        this.password = password;
        this.phone_num = phone_num;
        this.role = role;
    }
    
    public int get_user_id(){ 
        return this.user_id;
    }
    
    public String get_username() {
        return this.username;
    }
    
    public String get_password() { 
        return this.password;
    }
    
    public String get_phone_num() { 
        return this.phone_num;
    }
    public String get_role() { 
        return this.role;
    }
    
}
