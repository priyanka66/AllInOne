package com.allInOne.allInOneV1.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.HashMap;

public class SendSMS {
    public static final String ACCOUNT_SID = "ACd304487421fb1cae7c9b3de98ba4aac3";
    public static final String AUTH_TOKEN = "000749e7f963f51bb8a245028c2731a7";
    HashMap<String, String> messageTemplate = new HashMap<String, String>();

    public void sendSMS(String receiver, String sender) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(receiver),
                new PhoneNumber(sender),
                "This is a test message").create();
    }
}
