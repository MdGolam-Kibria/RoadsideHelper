package com.example.myapplication.ShowAllUserUsingRetrofit;

public class PojoClass {
    public String userId;
    public String userName;
    public String userEmail;
    public String userPhone;
    public String userPassword;
    public String userType;
    public String userLocation;

    public PojoClass() {
    }

    public PojoClass(String userId, String userName, String userEmail, String userPhone, String userPassword, String userType, String userLocation) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userLocation = userLocation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
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

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "OurDataSet{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", userLocation='" + userLocation + '\'' +
                '}';
    }
}
