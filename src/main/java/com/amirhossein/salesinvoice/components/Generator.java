package com.amirhossein.salesinvoice.components;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class Generator {

    private Random random;

    public Generator() {
        random = new Random(System.currentTimeMillis());
    }

    public String generateRandomNumber(int length) {
        String numbers = "1234567890";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(numbers.charAt(random.nextInt(numbers.length())));
        return stringBuilder.toString();
    }

    public String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    public String generateRandomProductCode() {
        random = new Random(System.currentTimeMillis());
        return "product_" + random;
    }

    public String alphaNumericString(int len) {
        String AB = "0123456789abcdefghijklmnopqrstuvwxrzABCDEFGHIJKLMNOPQRSTUVWXYZ_-/*+^*(@#)!*#%^$!.";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

}
