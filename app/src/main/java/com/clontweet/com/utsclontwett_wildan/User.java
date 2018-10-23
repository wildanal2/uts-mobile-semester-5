package com.clontweet.com.utsclontwett_wildan;

public class User {
    private String username,email,pswd;

    public User() {
    }

    public User(String username, String email, String pswd) {
        this.username = username;
        this.email = email;
        this.pswd = pswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
