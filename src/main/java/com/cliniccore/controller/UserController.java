package com.cliniccore.controller;

import com.cliniccore.entity.User;
import com.cliniccore.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.cliniccore.dto.UserRequest;
import com.cliniccore.dto.UserResponse;
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
    public List<UserResponse> findAll();


    @GetMapping("/{id}")
    public UserResponse findById(...);

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
