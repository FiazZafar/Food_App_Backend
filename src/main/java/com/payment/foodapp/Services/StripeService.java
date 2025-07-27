package com.payment.foodapp.Services;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.annotation.PostConstruct;

@Service
public class StripeService {
    @Value("${stripe.api.key}")
    private String apikey;

    @PostConstruct
    public void init(){
            Stripe.apiKey = apikey;
    }
    public Map<String,Object> createPaymentIntent(Long amount) throws Exception{
    
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .setAmount(amount).setCurrency("usd").setAutomaticPaymentMethods(PaymentIntentCreateParams.AutomaticPaymentMethods
        .builder().setEnabled(true).build()).build();

        PaymentIntent intent = PaymentIntent.create(params);
        
        Map<String,Object> responseData = new HashMap<>();
        responseData.put("clientSecret",intent.getClientSecret());

        return responseData;
    } 
}
