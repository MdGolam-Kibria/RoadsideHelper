package com.example.myapplication.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@ToString
@AllArgsConstructor

public class LombokLibraryTest {
    public String serviceName;
    public String serviceEmail;
    public String servicePhone;
    public String servicePassword;
    public String serviceType;
    public String serviceLocation;
}
