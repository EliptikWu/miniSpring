package cue.edu.co.mini.service.impl;
import cue.edu.co.mini.mapping.dtos.PaymentDto;
import cue.edu.co.mini.mapping.mapper.PaymentMapper;
import cue.edu.co.mini.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cue.edu.co.mini.repository.PaymentRepository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author <a href="https://github.com/EliptikWu"
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Retrieves a list of payments from the payment repository.
     *
     * @return a list of paymentDto objects.
     * @throws RuntimeException if an error occurs while retrieving the payments.
     */
    @Override
    public List<PaymentDto> getPayments() throws SQLException {
            return paymentRepository.findAll().stream()
                    .map(PaymentMapper::mapFrom)
                    .toList();
    }

    /**
     * Removes a payment from the payment repository based on the provided payment ID.
     *
     * @param id the ID of the payment to be removed.
     * @throws RuntimeException if an error occurs while removing the payment.
     */
    @Override
    public void removePayment(Long id) throws SQLException{
            paymentRepository.delete(PaymentMapper.mapFrom(getPaymentById(id)));
    }

    /**
     * Adds a new payment to the payment repository.
     *
     * @param payment the PaymentDto object to be added.
     * @throws RuntimeException if an error occurs while adding the payment.
     */
    @Override
    public void addPayment(PaymentDto payment) throws SQLException{
            paymentRepository.save(PaymentMapper.mapFrom(payment));
    }

    /**
     * Retrieves a payment from the payment repository based on the provided payment ID.
     *
     * @param id the ID of the payment to be retrieved.
     * @return an Optional containing the PaymentDto object if found, or an empty Optional if not found.
     * @throws RuntimeException if an error occurs while retrieving the payment.
     */
    @Override
    public PaymentDto getPaymentById(Long id) throws SQLException{
            return paymentRepository.findById(id)
                    .map(PaymentMapper::mapFrom)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

}
