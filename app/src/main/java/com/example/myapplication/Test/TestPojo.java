package com.example.myapplication.Test;

public class TestPojo {
    public String userEmail;
    public String userPassword;
    public String userType;

    public TestPojo() {
    }

    public TestPojo(String userEmail, String userPassword, String userType) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "TestPojo{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
