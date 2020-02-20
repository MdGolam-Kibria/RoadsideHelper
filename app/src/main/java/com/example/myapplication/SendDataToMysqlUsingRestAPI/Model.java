package com.example.myapplication.SendDataToMysqlUsingRestAPI;

public class Model {


    public String userName;
    public String userEmail;
    public String userPhone;
    public String userPassword;
    public String userType;
    public String userLocation;
    ForResponceAnotherModel forResponceAnotherModel;

    public ForResponceAnotherModel getForResponceAnotherModel() {
        return forResponceAnotherModel;
    }

    public void setForResponceAnotherModel(ForResponceAnotherModel forResponceAnotherModel) {
        this.forResponceAnotherModel = forResponceAnotherModel;
    }

    public Model() {
    }

    public Model(String userName, String userEmail, String userPhone, String userPassword, String userType, String userLocation) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "Model{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", userLocation='" + userLocation + '\'' +
                '}';
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
}
