package za.ac.cput.Repository;
/**
 * @author Zahrah Vermaak 221406395
 */

import za.ac.cput.Domain.Payment;

import java.util.List;

public interface IPaymentRepository extends IRepository<Payment,String> {

    List<Payment>getAllPayment();//create more lists
}
