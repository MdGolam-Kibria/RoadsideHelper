package com.example.myapplication.modelClass.loginModel.UserPojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPojo {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userPassword;
    private String userType;
    private String userLocation;
}
