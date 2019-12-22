package com.example.barberapp.models;

public class User {

private int id;
private String email;
private String email_verified_at;
private String password;
private String role;
private String profile_pic,deleted_at,created_at,updated_at;
private boolean remember_token;

    public User() {
    }

    public User(int id, String email, String email_verified_at, String password, String role,
                String profile_pic, boolean remember_token, String deleted_at, String created_at, String updated_at) {
        this.id = id;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.password = password;
        this.role = role;
        this.profile_pic = profile_pic;
        this.remember_token = remember_token;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public boolean getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(boolean remember_token) {
        this.remember_token = remember_token;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
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
}
