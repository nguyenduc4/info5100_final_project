/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author danie
 */
public class Room {
    private int room_id;
    private int hotel_id;
    private String name;
    private String type;
    private String status;
    private float price;
    private int approved;
    
    public int get_room_id() {
        return room_id;
    }

    public void set_room_id(int room_id) {
        this.room_id = room_id;
    }

    public int get_hotel_id() {
        return hotel_id;
    }

    public void set_hotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    public String get_status() {
        return status;
    }

    public void set_status(String status) {
        this.status = status;
    }

    public float get_price() {
        return price;
    }

    public void set_price(float price) {
        this.price = price;
    }
    
    public void set_approved(int approve) { 
        this.approved = approve;
    }
    
    public int get_approved() { 
        return this.approved;
    }
}
