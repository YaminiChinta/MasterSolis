package com.example.mastersolis.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailOTPService {
    private final JavaMailSender mailSender;

    public MailOTPService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOtpToEmail(String toEmail, String otp) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, otp);
        helper.setTo(toEmail);
        helper.setSubject("Your OTP ");
        helper.setText("Your OTP(One Time Password) is : " + otp);
        mailSender.send(message);
    }
}
