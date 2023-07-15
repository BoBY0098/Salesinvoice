package com.amirhossein.salesinvoice.components;

import java.util.Random;

public class NumberGenerator {

    public static String getRandomNumberString(){
        Random random = new Random();
        int number = random.nextInt(999999);

        return String.format("%06d" , number);
    }
}
