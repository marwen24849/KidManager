package fsb.ucar.kidcaremanager.controller;

import fsb.ucar.kidcaremanager.dto.UserDto;
import fsb.ucar.kidcaremanager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> doFindAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> doFindUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> doFindUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> doAddUser(@RequestBody UserDto model){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        this.userService.addUser(model)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> doUpdateUser(@PathVariable Long id, @RequestBody UserDto model){
        return ResponseEntity.ok(userService.updateUser(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> doDeleteUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
