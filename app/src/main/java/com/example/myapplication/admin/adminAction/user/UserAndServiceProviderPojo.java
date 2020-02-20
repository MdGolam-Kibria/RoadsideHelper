package com.example.myapplication.admin.adminAction.user;

public class UserAndServiceProviderPojo {
    public String userName;
    public String userEmail;
    public String userPhone;
    public String userLocation;

    public UserAndServiceProviderPojo() {
    }

    public UserAndServiceProviderPojo(String userName, String userEmail, String userPhone, String userLocation) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userLocation = userLocation;
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

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "UserAndServiceProviderPojo{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userLocation='" + userLocation + '\'' +
                '}';
    }
}
