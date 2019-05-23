package com.saveobjectininternalmemory;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String userEmail;
    private String userAddress;

    public User(String userName, String userEmail, String userAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

}