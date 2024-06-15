package cue.edu.co.mini.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cue.edu.co.mini.service.PaymentService;
import cue.edu.co.mini.mapping.dtos.PaymentDto;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/get-payments")
    public List<PaymentDto> getAllPayment() throws SQLException {
        return paymentService.getPayments();
    }

    @DeleteMapping(value = "/delete-payments/{id}")
    public void removePayment(@PathVariable Long id)throws SQLException {
        paymentService.removePayment(id);
    }

    @PostMapping(value = "/add-payment")
    public void addPayment(@RequestBody PaymentDto payment)throws SQLException {
        paymentService.addPayment(payment);
    }

    @GetMapping(value = "/get-payments-by-id/{id}")
    public PaymentDto getPaymentById(Long id)throws SQLException {
        return paymentService.getPaymentById(id);
    }
}