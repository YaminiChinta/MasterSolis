package com.example.mastersolis.controller;

import com.example.mastersolis.Wrappers.ForgotPasswordWrapper;
import com.example.mastersolis.Wrappers.UserLoginWrapper;
import com.example.mastersolis.model.Users;
import com.example.mastersolis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserAuthController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignup(@RequestBody Users users){
        return userService.userSignup(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserLoginWrapper userLoginWrapper){
        return userService.userLogin(userLoginWrapper);
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordWrapper forgotPasswordWrapper){
        return userService.forgotPassword(forgotPasswordWrapper.getEmailOrPhone());
    }

}
