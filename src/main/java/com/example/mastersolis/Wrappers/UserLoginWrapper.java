package com.example.mastersolis.Wrappers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginWrapper {
    private String emailOrPhone;
    private String password;

    public UserLoginWrapper(String emailOrPhone, String password) {
        this.emailOrPhone = emailOrPhone;
        this.password = password;
    }
}
