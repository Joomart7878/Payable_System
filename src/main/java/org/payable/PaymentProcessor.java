package org.payable;

import java.util.Random;

public class PaymentProcessor {
    public static void processrPayments (Payable[] payments) {
        Random rand = new Random();

        for (Payable payment : payments) {
            double amount = 1 + rand.nextDouble() * 99; //random amount between 1-100
            payment.pay(amount);
        }
    }
}
