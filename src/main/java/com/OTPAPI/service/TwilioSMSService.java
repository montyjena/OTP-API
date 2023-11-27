package com.OTPAPI.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioSMSService {

    @Value("${twilio.account-sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private String twilioAuthToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    public void sendOTP(String phoneNumber, String otp) {
        Twilio.init(twilioAccountSid, twilioAuthToken);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                        "Your OTP is: " + otp)
                .create();

        System.out.println("OTP sent. SID: " + message.getSid());
    }
}
