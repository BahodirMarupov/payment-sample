package uz.bahodirsmind.paymentdemo.repository;

import org.springframework.data.repository.CrudRepository;
import uz.bahodirsmind.paymentdemo.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
