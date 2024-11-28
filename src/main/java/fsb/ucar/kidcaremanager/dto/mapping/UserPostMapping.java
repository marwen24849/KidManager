package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.UserDto;
import fsb.ucar.kidcaremanager.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

@Component
public class UserPostMapping implements Function<UserDto, User> {

    private final PasswordEncoder passwordEncoder;

    public UserPostMapping(PasswordEncoder Encoder) {
        this.passwordEncoder = Encoder;
    }

    @Override
    public User apply(UserDto userDto) {
        User user = new User();
        user.setNom(userDto.nom());
        user.setPrenom(userDto.prenom());
        user.setEmail(userDto.email());
        user.setRole(userDto.role());
        user.setMotDePasse(
                passwordEncoder
                        .encode(userDto.motDePasse())
        );
        user.setDateInscription(new Date());
        return user;
    }
}
