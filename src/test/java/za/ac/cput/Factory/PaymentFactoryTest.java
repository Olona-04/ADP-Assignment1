package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void createPayment() {
        Payment payment = PaymentFactory.createPayment(
                "PAY1",
                150.0,
                "CARD"
        );

        assertNotNull(payment, "Payment should not be null");
        assertEquals("PAY1", payment.getPaymentId());
        assertEquals(150.0, payment.getAmount());
        assertEquals("CARD", payment.getPaymentMethod());
    }

    @Test
    void createPayment_nullId() {
        Payment payment = PaymentFactory.createPayment(
                null,
                150.0,
                "MASTERCARD"
        );

        assertNull(payment, "Payment ID is null");
    }

    @Test
    void createPayment_nullMethod() {
        Payment payment = PaymentFactory.createPayment(
                "PAY123",
                150.0,
                null
        );

        assertNull(payment, "Payment method is null");
    }

    @Test
    void createPayment_invalidAmount() {
        Payment payment1 = PaymentFactory.createPayment(
                "PAY123",
                0.0,
                "MASTERCARD"
        );

        Payment payment2 = PaymentFactory.createPayment(
                "PAY123",
                -50.0,
                "MASTERCARD"
        );


                assertNull(payment1, "Amount cannot be zero");
        System.out.println("Amount cannot be zero");
                assertNull(payment2, "Amount cannot be negative");
        System.out.println("Amount cannot be negative");

    }

}