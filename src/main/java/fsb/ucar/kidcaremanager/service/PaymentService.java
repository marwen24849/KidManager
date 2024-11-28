package fsb.ucar.kidcaremanager.service;

import fsb.ucar.kidcaremanager.dto.PaymentDto;
import fsb.ucar.kidcaremanager.dto.mapping.PaymentGetMapping;
import fsb.ucar.kidcaremanager.dto.mapping.PaymentPostMapping;
import fsb.ucar.kidcaremanager.entity.Payment;
import fsb.ucar.kidcaremanager.exception.NotFoundException;
import fsb.ucar.kidcaremanager.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentGetMapping paymentGetMapping;
    private final PaymentPostMapping paymentPostMapping;

    public List<PaymentDto> findAllPayment(){
        return paymentRepository
                .findAll()
                .stream()
                .map(paymentGetMapping)
                .collect(Collectors.toList());
    }

    public PaymentDto findPaymentById(Long id){
        return paymentGetMapping
                .apply(
                        findById(id)
                );
    }

    public Map<String, String> addPayment(PaymentDto model){
        paymentRepository.save(
                paymentPostMapping
                        .apply(model)
        );
        return Map.of("status", "Payment Add");
    }
    public Map<String, String> updatePayment(Long id, PaymentDto model){
        Payment payment = findById(id);
        if(model.montant() != null)
            payment.setMontant(model.montant());
        paymentRepository.save(payment);
        return Map.of("status", "Payment Update");
    }

    public Map<String, String> deletePaymentById(Long id){
        findById(id);
        paymentRepository.deleteById(id);
        return Map.of("status", "Payment Delete");
    }
    private Payment findById(Long id){
        return paymentRepository
                .findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("Payment Not Found")
                );
    }
}
