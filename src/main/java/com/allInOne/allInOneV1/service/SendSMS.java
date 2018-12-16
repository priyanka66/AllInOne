package com.allInOne.allInOneV1.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.HashMap;

public class SendSMS {
    public static final String ACCOUNT_SID = "";
    public static final String AUTH_TOKEN = "";
    HashMap<String, String> messageTemplate = new HashMap<String, String>();

    public void sendSMS(String receiver, String sender) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(receiver),
                new PhoneNumber(sender),
                "Booking confirmed. Please check your email for the tickets").create();
    }
}
