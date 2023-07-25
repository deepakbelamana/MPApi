package com.Moviepapers.MPapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MPOTPService {

    private String generatedOTP=null;

    @Autowired
    JavaMailSender javaMailSender;

    public String generateOTP()
    {
        Random random = new Random();
        int otp = 100_000 + random.nextInt(900_000);
        return String.valueOf(otp);
    }

    public ResponseEntity sendOTP(String userMail) {
        try{
            this.setGeneratedOTP(generateOTP());
            String subject = "password reset";
            String text = "Your OTP for resetting the pasword is: " + this.getGeneratedOTP();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userMail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            return ResponseEntity.ok("Otp sent successfully..!");
        }
        catch(Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending OTP!"+" "+e);
        }
    }
    public String getGeneratedOTP() {
        return generatedOTP;
    }

    public void setGeneratedOTP(String generatedOTP) {
        this.generatedOTP = generatedOTP;
    }
}
