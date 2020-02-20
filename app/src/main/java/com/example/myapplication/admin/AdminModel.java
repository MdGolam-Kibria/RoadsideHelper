package com.example.myapplication.admin;

public class AdminModel {

    public int adminId;

    public String adminName;

    public String adminEmail;

    public String adminPhone;

    public String adminPassword;

    public String adminLocation;

    public AdminModel() {
    }

    public AdminModel(int adminId, String adminName, String adminEmail, String adminPhone, String adminPassword, String adminLocation) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
        this.adminPassword = adminPassword;
        this.adminLocation = adminLocation;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminLocation() {
        return adminLocation;
    }

    public void setAdminLocation(String adminLocation) {
        this.adminLocation = adminLocation;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminLocation='" + adminLocation + '\'' +
                '}';
    }
}
