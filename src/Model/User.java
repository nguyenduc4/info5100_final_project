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
    private String role; 
    
    // 参数化构造函数
    public User(String username, String password, String phone_num, String role) {
        this.username = username;
        this.password = password;
        this.phone_num = phone_num;
        this.role = role;
    }

    // 无参数构造函数
    public User() {
        // 留空以支持无参实例化
    }

    // Getter 方法
    public int get_user_id() { 
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

    // Setter 方法
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
    }
}
