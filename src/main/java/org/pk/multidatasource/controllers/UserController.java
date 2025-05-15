package org.pk.multidatasource.controllers;

import org.pk.multidatasource.entities.User;
import org.pk.multidatasource.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<?> getUsersList() {
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(Long userId) {
        return ResponseEntity.ok(this.userRepository.findById(userId));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userRepository.save(user));
    }

    @PostMapping("/save")
    public ResponseEntity<?> addMultipleUser(@RequestBody List<User> user) {
        return ResponseEntity.ok(this.userRepository.saveAll(user));
    }

}
