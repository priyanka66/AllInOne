package com.allInOne.allInOneV1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.*;


import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public class PayPalClient {

    String clientId = "";
    String clientSecret = "";

    APIContext context = new APIContext(clientId, clientSecret, "sandbox");



    public Map<String, Object> createPayment(String sum) {
        Map<String, Object> response = new HashMap<String, Object>();

        // Payment amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
        // Total must be equal to sum of shipping, tax and subtotal.
        amount.setTotal(sum);

        // Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);

        // Add transaction to a list
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        // Set payer details
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");


        // Set redirect URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8088/paypal/cancel");
        redirectUrls.setReturnUrl("http://localhost:8088/success.html");


        // Set payment details
        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);

        try {
            Payment createdPayment = payment.create(context);
            String redirectUrl = "";
            if(createdPayment!=null) {
                List<Links> links = createdPayment.getLinks();
                for (Links link:links) {
                    if(link.getRel().equals("approval_url")){
                        redirectUrl = link.getHref();
                        break;
                    }
                }
            response.put("status", "success");
            response.put("redirect_url", redirectUrl);
            }
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }

        return response;

    }

    public Map<String, Object> completePayment(HttpServletRequest req) {
        Map<String, Object> response = new HashMap<String, Object>();
        Payment payment = new Payment();
        payment.setId(req.getParameter("paymentId"));

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(req.getParameter("PayerID"));
        try {
            APIContext context =  new APIContext(clientId, clientSecret, "sandbox");;
            Payment createdPayment = payment.execute(context, paymentExecution);
            if(createdPayment!=null){
                response.put("status", "success");
                response.put("payment", createdPayment);
            }

        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }
        return response;
    }

}
