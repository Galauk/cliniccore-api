package com.cliniccore.controller;

import com.cliniccore.entity.User;
import com.cliniccore.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.cliniccore.dto.UserRequest;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

@PostMapping
public User create(@Valid @RequestBody UserRequest dto) {

    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    user.setRole(dto.getRole());

    return userService.save(user);
}

}
