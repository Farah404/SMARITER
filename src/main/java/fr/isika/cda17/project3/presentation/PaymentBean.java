package fr.isika.cda17.project3.presentation;


import java.nio.file.Paths;



import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

public class PaymentBean {

 

    // This is a public sample test API key.
    // Donâ€™t submit any personally identifiable information in requests made with this key.
    // Sign in to see your own test API key embedded in code samples.
    Stripe.apiKey = "sk_test_VePHdqKTYQjKNInc7u56JBrQ";

    staticFiles.externalLocation(
        Paths.get("public").toAbsolutePath().toString());
    
public void createCheckoutSession() {
    
        String YOUR_DOMAIN = "http://localhost:8080/Smariter";
        SessionCreateParams params =
          SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
            .addLineItem(
              SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                .setPrice("{{PRICE_ID}}")
                .build())
            .build();
      Session session = Session.create(params);

      response.redirect(session.getUrl(), 303);
      return "";
    });
  }
}