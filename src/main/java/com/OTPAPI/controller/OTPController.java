package com.OTPAPI.controller;

import com.OTPAPI.payload.OTPRequestDTO;
import com.OTPAPI.service.TwilioSMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OTPController {

    @Autowired
    private TwilioSMSService twilioSMSService;

    @PostMapping("/sendOTP")
    public String sendOTP(@RequestBody OTPRequestDTO otpRequestDTO) {
        String phoneNumber = otpRequestDTO.getPhoneNumber();

        // Generate OTP
        String otp = generateOTP(); // Implement your OTP generation logic here

        // Send OTP via Twilio service
        twilioSMSService.sendOTP(phoneNumber, otp);

        return "OTP sent successfully!";
    }

    private String generateOTP() {
        // Implement OTP generation logic (e.g., using Random class)
        return "1234"; // Replace this with your OTP
    }
}
