package com.example.mastersolis.service;

import com.example.mastersolis.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserUtilsService {

    @Autowired
    UserDao userDao;

    public Boolean existsByEmail(String email){
        return userDao.existsByEmail(email);
    }

    public Boolean existsByPhone(String phonenumber){
        return userDao.existsByPhonenumber(phonenumber);
    }

    public boolean isEmail(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return patternMatches(emailAddress, regexPattern);
    }

    public boolean isMobileNumber(String mobileNumber) {
        String regexPattern = "^(\\+\\d{1,3})?\\d{10}$";
        // String regexPattern = "^(\+\d{1,3}[- ]?)?\d{10}$";
        return patternMatches(mobileNumber, regexPattern);
    }

    public boolean patternMatches(String input, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(input).matches();
    }

    public String generateOTP(String emailORmobile){
        int otp=(int) (Math.random() * 1000000);
        return String.format("%06d",otp);
    }
}
