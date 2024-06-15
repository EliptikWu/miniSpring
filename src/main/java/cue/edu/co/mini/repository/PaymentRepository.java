package cue.edu.co.mini.repository;

import cue.edu.co.mini.domain.Payment;
import cue.edu.co.mini.mapping.dtos.PaymentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository <Payment,Long> {
   /** List<PaymentDto> listPayment();
    void removePayment(Long id);
    void addPayment(PaymentDto payment);
    Optional<PaymentDto> getPaymentById(Long id);
    void savePayment(PaymentDto payment);**/
}