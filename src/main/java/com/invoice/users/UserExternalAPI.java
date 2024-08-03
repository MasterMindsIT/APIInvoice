package com.invoice.users;

import java.util.List;

public interface UserExternalAPI {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUser();
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUser(Long id);
    UserDTO userRol(Long user_id, Long rol_id);
}
