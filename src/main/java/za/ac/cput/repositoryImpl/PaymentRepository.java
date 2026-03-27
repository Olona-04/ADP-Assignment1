package za.ac.cput.repositoryImpl;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.Payment;
import za.ac.cput.Repository.IPaymentRepository;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    private static PaymentRepository repository = null;
    private List<Payment> allPayments;

    private PaymentRepository() {
        allPayments = new ArrayList<>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        allPayments.add(payment);
        return payment;
    }

    @Override
    public Payment read(String id) {
        for (Payment payment : allPayments) {
            if (payment.getPaymentId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment existingPayment = read(payment.getPaymentId());
        if (existingPayment != null) {
            allPayments.remove(existingPayment);
            allPayments.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Payment paymentToDelete = read(id);
        if (paymentToDelete != null) {
            allPayments.remove(paymentToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return allPayments;
    }

    @Override
    public List<Payment> getAllPayment() {
        return getAll();
    }
}
