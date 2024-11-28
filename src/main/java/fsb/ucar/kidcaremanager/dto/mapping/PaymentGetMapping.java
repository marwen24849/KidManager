package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.PaymentDto;
import fsb.ucar.kidcaremanager.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PaymentGetMapping implements Function<Payment, PaymentDto> {
    @Override
    public PaymentDto apply(Payment payment) {
        return new PaymentDto(
                payment.getMontant(),
                payment.getDate()
        );
    }
}
