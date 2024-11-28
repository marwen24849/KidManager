package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.PaymentDto;
import fsb.ucar.kidcaremanager.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class PaymentPostMapping implements Function<PaymentDto, Payment> {
    @Override
    public Payment apply(PaymentDto paymentDto) {
        Payment payment = Payment
                .builder()
                .montant(paymentDto.montant())
                .date(paymentDto.date())
                .build();
        return payment;
    }
}
