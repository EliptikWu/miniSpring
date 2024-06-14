package repository;

import domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository <Payment,Long> {
    List<Payment> listPayment();
    void removePayment(Long id);
    void addPayment(Payment payment);
    Optional<Payment> getPaymentById(Long id);
    void savePayment(Payment payment);
}