package com.coursework.fireProtectionSystems.controller;

import com.coursework.fireProtectionSystems.model.CheckUser;
import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.model.Users;
import com.coursework.fireProtectionSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PutMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Users user) {
        Boolean newUser = userService.checkLogin(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/check/username")
    public ResponseEntity<Boolean> checkUsername(@RequestBody CheckUser user) {
        Boolean newUser = userService.checkUsername(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/registration/{id}")
    public ResponseEntity<Users> registration(@RequestBody Users user, @PathVariable("id") Long id) {
        Users newUser = userService.registration(user);
        userService.saveUser(newUser, id);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PutMapping("/check/role")
    public ResponseEntity<Boolean> checkRole(@RequestBody CheckUser user) {
        Boolean newUser = userService.checkRole(user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
