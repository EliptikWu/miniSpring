package service;

import domain.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService{
    List<Payment> getPayments();
    void removePayment(Long id);
    void addPayment(Payment payment);
    Optional<Payment> getPaymentById(Long id);
    void savePayment(Payment payment);
}
