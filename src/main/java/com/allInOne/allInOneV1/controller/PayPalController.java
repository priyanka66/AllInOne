package com.allInOne.allInOneV1.controller;


import com.allInOne.allInOneV1.service.PayPalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {
    private final PayPalClient payPalClient;

    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }

    @RequestMapping(path = "/make/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> makePayment(@RequestParam("sum") String sum){
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
    @RequestMapping(path = "/complete/payment", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> completePayment(HttpServletRequest request){
        return payPalClient.completePayment(request);
    }

    @RequestMapping(path = "/process", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String transactionSuccessful() {
        return "Success";
    }
}
