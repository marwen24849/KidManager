package fsb.ucar.kidcaremanager.dto.mapping;

import fsb.ucar.kidcaremanager.dto.UserDto;
import fsb.ucar.kidcaremanager.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserGetMapping implements Function<User, UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getNom(),
                user.getPrenom(),
                user.getEmail(),
                user.getMotDePasse(),
                user.getRole(),
                user.getDateInscription()

        );
    }
}
