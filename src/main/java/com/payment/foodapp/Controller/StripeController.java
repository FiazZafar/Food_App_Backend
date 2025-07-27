package com.payment.foodapp.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.foodapp.Services.StripeService;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;


@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
public class StripeController {
    @Autowired
    StripeService stripeService;

 @PostMapping("/create-payment-intent")
public Map<String, Object> createPaymentIntent(@RequestBody Map<String, Object> data) throws Exception {
    BigDecimal amount = new BigDecimal(data.get("amount").toString());
    Long amountInCents = amount.multiply(BigDecimal.valueOf(100)).longValue();

    PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
            .setAmount(amountInCents * 100)  // amount in smallest currency unit
            .setCurrency("usd")
            .build();

    PaymentIntent intent = PaymentIntent.create(params);

    Map<String, Object> responseData = new HashMap<>();
    responseData.put("clientSecret", intent.getClientSecret());
    return responseData;
}

}
