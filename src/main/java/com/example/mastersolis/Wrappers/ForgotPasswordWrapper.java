package com.example.mastersolis.Wrappers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgotPasswordWrapper {

    private String emailORpassword;

    public ForgotPasswordWrapper(String emailORpassword) {
        this.emailORpassword = emailORpassword;
    }
}
