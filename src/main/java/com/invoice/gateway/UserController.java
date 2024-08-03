package com.invoice.gateway;

import com.invoice.users.UserDTO;
import com.invoice.users.UserExternalAPI;
import com.invoice.users.UserRoleDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserExternalAPI userExternalAPI;

    public UserController(UserExternalAPI userExternalAPI) {
        this.userExternalAPI = userExternalAPI;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userExternalAPI.getUserById(id));
    }
    @GetMapping
    public List<UserDTO> all(){
        return userExternalAPI.getAllUser();
    }
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userExternalAPI.saveUser(userDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userExternalAPI.updateUser(id, userDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(userExternalAPI.deleteUser(id));
    }
    @GetMapping("/{user_id}/{role_id}")
    public ResponseEntity<UserDTO> userRol(@PathVariable("user_id") Long user_id, @PathVariable("role_id") Long role_id){
        return ResponseEntity.ok(userExternalAPI.userRol(user_id, role_id));
    }
}