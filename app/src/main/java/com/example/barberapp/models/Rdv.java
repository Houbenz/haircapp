package com.example.barberapp.models;

import java.sql.Date;

public class Rdv {

    private int id;

    private String date ;

    private String time;

    private String state;

    private int customer_id;

    private int barber_id;

    private int location_x;

    private int location_y;

    private String created_at;

    private String updated_at;

    private int haircut_id;


    public Rdv(int id, String date, String time, String state, int customer_id, int barber_id,
               int location_x, int location_y, String created_at, String updated_at, int haircut_id) {

        this.id = id;
        this.date = date;
        this.time = time;
        this.state = state;
        this.customer_id = customer_id;
        this.barber_id = barber_id;
        this.location_x = location_x;
        this.location_y = location_y;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.haircut_id = haircut_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getBarber_id() {
        return barber_id;
    }

    public void setBarber_id(int barber_id) {
        this.barber_id = barber_id;
    }

    public int getLocation_x() {
        return location_x;
    }

    public void setLocation_x(int location_x) {
        this.location_x = location_x;
    }

    public int getLocation_y() {
        return location_y;
    }

    public void setLocation_y(int location_y) {
        this.location_y = location_y;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getHaircut_id() {
        return haircut_id;
    }

    public void setHaircut_id(int haircut_id) {
        this.haircut_id = haircut_id;
    }
}
