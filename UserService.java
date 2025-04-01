package com.vikas.JpaManyToMany.Service;

import com.vikas.JpaManyToMany.Entity.User;
import com.vikas.JpaManyToMany.Repository.UserRepo;
import com.vikas.JpaManyToMany.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    // Convert Entity to DTO
    private UserDTO DTOConvertTo(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(user -> this.DTOConvertTo(user)).collect(Collectors.toList());
    }

    public UserDTO saveUser(User user) {
        User savedUser = userRepo.save(user);
        return DTOConvertTo(savedUser);
    }

    public Optional<UserDTO> findById(long id) {
        return userRepo.findById(id).map(user -> this.DTOConvertTo(user));
    }

    public Optional<UserDTO> updateUser(long id, User updateUser) {

        return userRepo.findById(id).map(user -> {
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            user.setEmail(updateUser.getEmail());
            user.setUpdatedTime(LocalDateTime.now());

            return DTOConvertTo(userRepo.save(user));
        });
    }

    // Delete User
    public boolean deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
