package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Payment;
import za.ac.cput.repositoryImpl.PaymentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    private IPaymentRepository repository = PaymentRepository.getRepository();

    // Example Payment instances
    private Payment payment1 = new Payment.Builder()
            .setPaymentId("P1")
            .setAmount(100.50)
            .setPaymentMethod("Credit Card")
            .build();

    private Payment payment2 = new Payment.Builder()
            .setPaymentId("P2")
            .setAmount(200.00)
            .setPaymentMethod("Cash")
            .build();

    private Payment payment3 = new Payment.Builder()
            .setPaymentId("P3")
            .setAmount(150.75)
            .setPaymentMethod("Master Card")
            .build();

    @BeforeEach
    void setUp() {
        repository = PaymentRepository.getRepository();
        repository.getAll().clear(); // clear previous data
    }

    @Test
    void create() {
        Payment created1 = repository.create(payment1);
        Payment created2 = repository.create(payment2);
        Payment created3 = repository.create(payment3);

        assertNotNull(created1);
        assertNotNull(created2);
        assertNotNull(created3);

        List<Payment> all = repository.getAll();
        assertEquals(3, all.size());
        System.out.println("All payments in repository: " + all);

    }

    @Test
    void read() {
        repository.create(payment1);
        Payment read = repository.read("P1");

        assertNotNull(read);
        assertEquals(100.50, read.getAmount());
    }

    @Test
    void update() {
        repository.create(payment1);

        Payment updatedPayment = new Payment.Builder()
                .setPaymentId("P1")
                .setAmount(300.00)
                .setPaymentMethod("Credit Card")
                .build();

        Payment updated = repository.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(300.00, updated.getAmount());
        System.out.println(updatedPayment);
    }

    @Test
    void delete() {
        repository.create(payment1);

        boolean deleted = repository.delete("P1");
        assertTrue(deleted);

        Payment read = repository.read("P1");
        assertNull(read);
    }

    @Test
    void getAll() {
        repository.create(payment1);
        repository.create(payment2);

        List<Payment> all = repository.getAll();
        assertEquals(2, all.size());
        System.out.println(repository.getAll());
    }

    @Test
    void getAllPayments() {
        repository.create(payment2);
        repository.create(payment3);

        List<Payment> allPayments = repository.getAllPayment();
        assertEquals(2, allPayments.size());
        System.out.println(repository.getAllPayment());
    }

}