package service;

import mapping.dtos.PaymentDto;
import java.util.List;
import java.util.Optional;

public interface PaymentService{
    List<PaymentDto> getPayments();
    void removePayment(Long id);
    void addPayment(PaymentDto payment);
    Optional<PaymentDto> getPaymentById(Long id);
    void savePayment(PaymentDto payment);
}
