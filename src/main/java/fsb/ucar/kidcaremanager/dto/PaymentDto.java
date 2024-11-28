package fsb.ucar.kidcaremanager.dto;

import java.util.Date;

public record PaymentDto(
        Double montant,
        Date date
) {
}
