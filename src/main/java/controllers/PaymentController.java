package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PaymentService;
import mapping.dtos.PaymentDto;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/get-payments")
    public List<PaymentDto> getAllPayment() {
        return paymentService.getPayments();
    }

    @DeleteMapping(value = "/delete-payments/{id}")
    public void removePayment(@PathVariable Long id) {
        paymentService.removePayment(id);
    }

    @PostMapping(value = "/add-payment")
    public void addPayment(@RequestBody PaymentDto payment) {
        paymentService.addPayment(payment);
    }

    @GetMapping(value = "/get-payments-by-id/{id}")
    public Optional<PaymentDto> getPaymentById(Long id) {
        return paymentService.getPaymentById(id);
    }
}