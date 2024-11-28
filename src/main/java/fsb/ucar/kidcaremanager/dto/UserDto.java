package fsb.ucar.kidcaremanager.dto;


import java.util.Date;

public record UserDto(
        String nom,
        String prenom,
        String email,
        String motDePasse,
        String role,
        Date dateInscription
) {
}
