package com.example.mastersolis.service;

import com.example.mastersolis.Utils.UserUtils;
import com.example.mastersolis.Wrappers.ForgotPasswordWrapper;
import com.example.mastersolis.Wrappers.UserLoginWrapper;
import com.example.mastersolis.dao.UserDao;
import com.example.mastersolis.model.User;
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

    UserUtils userUtils;

    @Autowired
    MobileOTPService otpService;

    @Autowired
    MailOTPService mailOTPService;

    public ResponseEntity<String> userSignup(User user) {
        try{
            if(userUtils.existsByEmail(user.getEmail()) || userUtils.existsByPhone(user.getPhonenumber())){
                return new ResponseEntity<>("User already Registered", HttpStatus.ALREADY_REPORTED);
            }else{
                userDao.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while register the user", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Signup Successfully ", HttpStatus.CREATED);
    }

    public ResponseEntity<String> userLogin(UserLoginWrapper userLoginWrapper) {
        User user=new User();
        try{
            if(userUtils.isEmail(userLoginWrapper.getEmailOrPhone())){
                user=userDao.findByEmail(userLoginWrapper.getEmailOrPhone());
            }else if(userUtils.isMobileNumber(userLoginWrapper.getEmailOrPhone())){
                user=userDao.findByPhonenumber(userLoginWrapper.getEmailOrPhone());
            }
            if(!user.getCpassword().equals(userLoginWrapper.getPassword())){
                return new ResponseEntity<>("Incorrect Password", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>("User Login Successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> forgotPassword(ForgotPasswordWrapper forgotPasswordWrapper) {
        String emailOrPhone=forgotPasswordWrapper.getEmailORpassword();
        User user=new User();
        try{
            if(userUtils.isEmail(emailOrPhone)){
                if(userUtils.existsByEmail(emailOrPhone)){
                    user=userDao.findByEmail(emailOrPhone);
                    String emailOtp=userUtils.generateOTP(emailOrPhone);
                    otpMap.put(user.getEmail(), emailOtp);
                    mailOTPService.sendOtpToEmail(user.getEmail(), emailOtp);
                }else {
                    return new ResponseEntity<>("Email not Registered", HttpStatus.BAD_REQUEST);
                }
            }else if(userUtils.isMobileNumber(emailOrPhone)){
                if(userUtils.existsByPhone(emailOrPhone)){
                    user=userDao.findByPhonenumber(emailOrPhone);
                    String mobileOtp=userUtils.generateOTP(emailOrPhone);
                    otpMap.put(user.getPhonenumber(), mobileOtp);
                    otpService.sendOtpToPhone(user.getPhonenumber(), mobileOtp);
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
