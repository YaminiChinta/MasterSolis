package com.example.mastersolis.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

@Service
public class MobileOTPService {

    private static final String  ACCOUNT_SID ="";
    private static final String  AUTH_TOKEN ="";
    private static final String  FROM_PHONE_NUMBER ="+91 8179834529";

    public MobileOTPService(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }

    public void sendOtpToPhone(String toPhoneNumber, String otp){
        Message.creator(new com.twilio.type.PhoneNumber(toPhoneNumber),
                new com.twilio.type.PhoneNumber(FROM_PHONE_NUMBER),
                "Your OTP(One Time Password) is: "+otp)
                .create();
    }
}
