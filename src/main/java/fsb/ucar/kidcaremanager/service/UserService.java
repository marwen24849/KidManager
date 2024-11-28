package fsb.ucar.kidcaremanager.service;

import fsb.ucar.kidcaremanager.dto.UserDto;
import fsb.ucar.kidcaremanager.dto.mapping.UserGetMapping;
import fsb.ucar.kidcaremanager.dto.mapping.UserPostMapping;
import fsb.ucar.kidcaremanager.entity.User;
import fsb.ucar.kidcaremanager.exception.NotFoundException;
import fsb.ucar.kidcaremanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserGetMapping userGetMapping;
    private final UserPostMapping userPostMapping;

    public List<UserDto> findAllUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(userGetMapping)
                .collect(Collectors.toList());
    }

    public UserDto findUserById(Long id){
        return userGetMapping
                .apply(
                        findById(id)
                );
    }
    public UserDto findUserByEmail(String email){
        return userGetMapping
                .apply(
                        userRepository
                                .findUserByEmail(email)
                                .orElseThrow(
                                        ()-> new NotFoundException("User Not Found")
                                )

                );

    }



    public Map<String, String> addUser(UserDto model){
        userRepository.save(userPostMapping.apply(model));
        return Map.of("status","User Add");
    }

    public Map<String, String> updateUser(Long id, UserDto model){
        User user = findById(id);
        if(model.nom() != null)
            user.setNom(model.nom());
        if(model.prenom() != null)
            user.setPrenom(model.prenom());
        if(model.email() != null)
            user.setEmail(model.email());
        userRepository.save(user);
        return Map.of("status","User Update");
    }

    public Map<String, String> deleteUser(Long id){
        findById(id);
        userRepository.deleteById(id);
        return Map.of("status","User delete");
    }

    private User findById(Long id){
        return this.userRepository
                .findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("User Not Found")
                );
    }


}
