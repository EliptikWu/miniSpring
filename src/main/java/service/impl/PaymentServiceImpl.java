package service.impl;
import domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;
import service.PaymentService;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="https://github.com/EliptikWu"
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Retrieves a list of payments from the payment repository.
     *
     * @return a list of payment objects.
     */
    @Override
    public List<Payment> getPayments(){
        return paymentRepository.listPayment();
    }

    /**
     * Removes a payment from the payment repository based on the provided payment ID.
     *
     * @param id the ID of the payment to be removed.
     */
    @Override
    public void removePayment(Long id){
        paymentRepository.removePayment(id);
    }

    /**
     * Adds a new payment to the payment repository.
     *
     * @param payment the Payment object to be added.
     */
    @Override
    public void addPayment(Payment payment){
        paymentRepository.addPayment(payment);
    }

    /**
     * Saves the provided payment to the payment repository.
     * If the payment already exists, it will be updated; otherwise, a new reservation will be added.
     *
     * @param payment the Payment object to be saved.
     */
    @Override
    public void savePayment(Payment payment){
        paymentRepository.save(payment);
    }

    /**
     * Retrieves a payment from the payment repository based on the provided payment ID.
     * @param id the ID of the payment to be retrieved.
     * @return an Optional containing the Payment object if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Payment> getPaymentById(Long id){
        return paymentRepository.findById(id);
    }

}
