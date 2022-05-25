package com.coursework.fireProtectionSystems.controller;

import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.model.UserSystem;
import com.coursework.fireProtectionSystems.model.Users;
import com.coursework.fireProtectionSystems.service.UserSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usersystem")
public class UserSystemController {

    private final UserSystemService userSystemService;

    public UserSystemController(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @GetMapping("/find/{username}")
    public ResponseEntity<UserSystem> getUserSystemBy(@PathVariable("username") String username ){
        UserSystem userSystem = userSystemService.getUserSystem(username);
        return new ResponseEntity<>(userSystem, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserSystem> updateUserSystem(@RequestBody UserSystem userSystems){
        UserSystem updateSystem = userSystemService.updateUserSystem(userSystems);
        return new ResponseEntity<>(updateSystem, HttpStatus.OK);
    }

    @PutMapping("/update/username")
    public ResponseEntity<Users> updateUserName(@RequestBody Users user){
        Users user1 = userSystemService.updateUserName(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") Long id ){
        Users user = userSystemService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        userSystemService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
