package com.example.mastersolis.service;

import com.example.mastersolis.Wrappers.ForgotPasswordWrapper;
import com.example.mastersolis.Wrappers.UserLoginWrapper;
import com.example.mastersolis.dao.UserDao;
import com.example.mastersolis.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String, String> otpMap=new HashMap<String, String>();
    @Autowired
    UserDao userDao;

    @Autowired
    UserUtilsService userUtilsService;

    @Autowired
    MobileOTPService otpService;

    @Autowired
    MailOTPService mailOTPService;

    public ResponseEntity<String> userSignup(Users users) {
        try{
            if(userUtilsService.existsByEmail(users.getEmail()) || userUtilsService.existsByPhone(users.getPhonenumber())){
                return new ResponseEntity<>("User already Registered", HttpStatus.ALREADY_REPORTED);
            }else{
                userDao.save(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while register the user", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Signup Successfully ", HttpStatus.CREATED);
    }

    public ResponseEntity<String> userLogin(UserLoginWrapper userLoginWrapper) {
        Users users =new Users();
        try{
            if(userUtilsService.isEmail(userLoginWrapper.getEmailOrPhone())){
                users =userDao.findByEmail(userLoginWrapper.getEmailOrPhone());
            }else if(userUtilsService.isMobileNumber(userLoginWrapper.getEmailOrPhone())){
                users =userDao.findByPhonenumber(userLoginWrapper.getEmailOrPhone());
            }
            if(!users.getCpassword().equals(userLoginWrapper.getPassword())){
                return new ResponseEntity<>("Incorrect Password", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>("User Login Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> forgotPassword(String emailOrPhone) {
        Users users =new Users();
        try{
            if(userUtilsService.isEmail(emailOrPhone)){
                if(userUtilsService.existsByEmail(emailOrPhone)){
                    users =userDao.findByEmail(emailOrPhone);
                    String emailOtp= userUtilsService.generateOTP(emailOrPhone);
                    otpMap.put(users.getEmail(), emailOtp);
                    mailOTPService.sendOtpToEmail(users.getEmail(), emailOtp);
                }else {
                    return new ResponseEntity<>("Email not Registered", HttpStatus.BAD_REQUEST);
                }
            }else if(userUtilsService.isMobileNumber(emailOrPhone)){
                if(userUtilsService.existsByPhone(emailOrPhone)){
                    users =userDao.findByPhonenumber(emailOrPhone);
                    String mobileOtp= userUtilsService.generateOTP(emailOrPhone);
                    otpMap.put(users.getPhonenumber(), mobileOtp);
                    otpService.sendOtpToPhone(users.getPhonenumber(), mobileOtp);
                }else {
                    return new ResponseEntity<>("PhoneNumber not Registered", HttpStatus.BAD_REQUEST);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>("Password Changed Successfully", HttpStatus.CREATED);
    }


}
