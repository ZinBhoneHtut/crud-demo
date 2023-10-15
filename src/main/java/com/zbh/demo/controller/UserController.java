package com.zbh.demo.controller;

import com.zbh.demo.entity.User;
import com.zbh.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody User user) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id = " + id));
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setGender(user.getGender());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        oldUser.setAddress(user.getAddress());
        User updatedUser = userRepository.save(oldUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
