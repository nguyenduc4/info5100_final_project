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
    
    public void set_user_id(int user_id) { 
        this.user_id = user_id;
    }
    
    public void set_username(String username) { 
        this.username = username;
    }
    
    public void set_password(String password) { 
        this.password = password;
    }
    
    public void set_phone_num(String phone_num) { 
        this.phone_num = phone_num;
    }
    
    public void set_role(String role) { 
        this.role = role;
//        if (role.equals("CUSTOMER") || role.equals("RECEPTIONIST") || role.equals("STAFF") || role.equals("ADMIN")) {
//            this.role = role;
//        } else {
//            throw new IllegalArgumentException("Invalid role: must be CUSTOMER, RECEPTIONIST, STAFF, or ADMIN");
//        }
    }
}