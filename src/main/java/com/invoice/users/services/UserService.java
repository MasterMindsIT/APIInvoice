package com.invoice.users.services;

import com.invoice.roles.RoleDTO;
import com.invoice.roles.mappers.RoleMapper;
import com.invoice.roles.repositories.RoleRepository;
import com.invoice.roles.services.RoleService;
import com.invoice.users.UserDTO;
import com.invoice.users.UserExternalAPI;
import com.invoice.users.exceptions.UserNotFoundException;
import com.invoice.users.mappers.UserMapper;
import com.invoice.users.models.User;
import com.invoice.users.models.UserRole;
import com.invoice.users.repositories.UserRepository;
import com.invoice.users.repositories.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserExternalAPI{
    private UserRepository userRepository;
    private RoleService roleService;
    private UserMapper userMapper;
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.userToUserDTO(user))
                .toList();

    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        Object[] roles = userDTO.roles().stream().map(RoleDTO::id).toArray();
        User newUser = new User(null,userDTO.username(),userDTO.email(),userDTO.password(),true,true,true,true,null);
        newUser =  userRepository.save(newUser);
        for (Object role : roles) {
            userRoleRepository.save(new UserRole( null,newUser.getId(),(Long)role));
        }
        //return userMapper.userToUserDTO(userRepository.save(userMapper.userDTOToUser(userDTO)));
        return getUserById(newUser.getId());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userMapper.userDTOToUser(getUserById(id));
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO deleteUser(Long id) {
        User user = userMapper.userDTOToUser(getUserById(id));
        UserDTO userDTO = userMapper.userToUserDTO(user);
        userRepository.delete(user);
        return userDTO;
    }

    @Override
    public UserDTO userRol(Long user_id, Long rol_id) {
        User user = userMapper.userDTOToUser(getUserById(user_id));
        RoleDTO roleDTO = roleService.getRoleById(rol_id);
        userRoleRepository.save(new UserRole(null,user_id,rol_id));
        return userMapper.userToUserDTO(user);
    }
}
