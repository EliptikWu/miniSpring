package cue.edu.co.mini.mapping.mapper;

import cue.edu.co.mini.domain.Payment;
import cue.edu.co.mini.mapping.dtos.PaymentDto;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapper {
    public static PaymentDto mapFrom(Payment PaymentMapper){
        return new PaymentDto(PaymentMapper.getIdPayment(),
                PaymentMapper.getIdVehicle(),
                PaymentMapper.getIdReservation(),
                PaymentMapper.getIdUser()
        );
    }

    public static Payment mapFrom(PaymentDto paymentMapper){
        return new Payment(paymentMapper.idPayment(),
                paymentMapper.idVehicle(),
                paymentMapper.idReservation(),
                paymentMapper.idUser());
    }

    public static List<PaymentDto> mapFrom(List<Payment> paymentMapper){
        return paymentMapper.stream().map(PaymentMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Payment> mapFromDto(List<PaymentDto> paymentMapper){
        return paymentMapper.stream().map(PaymentMapper::mapFrom).collect(Collectors.toList());
    }
}
