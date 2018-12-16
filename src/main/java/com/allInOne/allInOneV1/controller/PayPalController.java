package com.allInOne.allInOneV1.controller;


import com.allInOne.allInOneV1.service.PayPalClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.allInOne.allInOneV1.service.SendSMS;

@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {
    private final PayPalClient payPalClient;

    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }
    SendSMS sms = new SendSMS();

    @RequestMapping(path = "/make/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> makePayment(@RequestParam("sum") String sum){

        sms.sendSMS("+13159499748","+13203350324");
        return payPalClient.createPayment(sum);
    }

    /***
     * paymentId = PAY-0C257208756826805LPUMNZI
     * PAY-8X63100930663872JLPUNFQA
     * PayerID  3ADTQM5MACS8G
     *
     * token EC-51F77034EC2399123
     * @param request
     * @return
     */
    @RequestMapping(path = "/complete/payment", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String  completePayment(HttpServletRequest request) {
        Map<String, Object> response = payPalClient.completePayment(request);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.toJson(response);
    }

    @RequestMapping(path = "/process", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String transactionSuccessful() {
        return "Success";
    }
}
