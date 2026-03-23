package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment;

public class PaymentFactory {
    public static Payment createPayment(String id, double amount, String method) {
        return new Payment.Builder()
                .setPaymentId(id)
                .setAmount(amount)
                .setMethod(method)
                .build();
    }
}
