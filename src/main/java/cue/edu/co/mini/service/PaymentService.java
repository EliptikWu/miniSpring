package cue.edu.co.mini.service;

import cue.edu.co.mini.mapping.dtos.PaymentDto;

import java.sql.SQLException;
import java.util.List;

public interface PaymentService{
    List<PaymentDto> getPayments()throws SQLException;
    void removePayment(Long id)throws SQLException;
    void addPayment(PaymentDto payment)throws SQLException;
    PaymentDto getPaymentById(Long id)throws SQLException;
}
