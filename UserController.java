package com.vikas.JpaManyToMany.Controller;

import com.vikas.JpaManyToMany.Entity.User;
import com.vikas.JpaManyToMany.Service.UserService;
import com.vikas.JpaManyToMany.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllTheUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Create User
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable long id){
        Optional<UserDTO> user = userService.findById(id);
        return user.map(u -> ResponseEntity.ok(u)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id,@RequestBody User updateUser) {
        Optional<UserDTO> user = userService.updateUser(id,updateUser);
        return user.map(u -> ResponseEntity.ok(u)).orElse(ResponseEntity.notFound().build());
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }




}
