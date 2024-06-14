package service.impl;
import mapping.dtos.PaymentDto;
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
     * @return a list of paymentDto objects.
     * @throws RuntimeException if an error occurs while retrieving the payments.
     */
    @Override
    public List<PaymentDto> getPayments() {
        try {
            return paymentRepository.listPayment();
        } catch (Exception e) {
            System.err.println("Error getting payments: " + e.getMessage());
            throw new RuntimeException("Error getting payments", e);
        }
    }
    /**
     * Removes a payment from the payment repository based on the provided payment ID.
     *
     * @param id the ID of the payment to be removed.
     * @throws RuntimeException if an error occurs while removing the payment.
     */
    @Override
    public void removePayment(Long id){
        try {
            paymentRepository.removePayment(id);
        } catch (Exception e){
            System.err.println("Error remove payment with id: " + id + ", " + e.getMessage());
            throw  new RuntimeException("Error remove payment with id: " + id, e);
        }

    }

    /**
     * Adds a new payment to the payment repository.
     *
     * @param payment the PaymentDto object to be added.
     * @throws RuntimeException if an error occurs while adding the payment.
     */
    @Override
    public void addPayment(PaymentDto payment){
        try {
            paymentRepository.addPayment(payment);
        } catch (Exception e) {
            System.err.println("Error adding payment: " + e.getMessage());
            throw new RuntimeException("Error adding payment", e);
        }
    }

    /**
     * Saves the provided payment to the payment repository.
     * If the payment already exists, it will be updated; otherwise, a new reservation will be added.
     *
     * @param payment the PaymentDto object to be saved.
     * @throws RuntimeException if an error occurs while saving the payment.
     */
    @Override
    public void savePayment(PaymentDto payment){
        try {
            paymentRepository.savePayment(payment);
        } catch (Exception e) {
            System.err.println("Error saving payment: " + e.getMessage());
            throw new RuntimeException("Error saving payment", e);
        }
    }

    /**
     * Retrieves a payment from the payment repository based on the provided payment ID.
     *
     * @param id the ID of the payment to be retrieved.
     * @return an Optional containing the PaymentDto object if found, or an empty Optional if not found.
     * @throws RuntimeException if an error occurs while retrieving the payment.
     */
    @Override
    public Optional<PaymentDto> getPaymentById(Long id){
        try {
            return paymentRepository.getPaymentById(id);
        } catch (Exception e) {
            System.err.println("Error getting payment with id: " + id + ". " + e.getMessage());
            throw new RuntimeException("Error getting payment with id: " + id, e);
        }
    }

}
