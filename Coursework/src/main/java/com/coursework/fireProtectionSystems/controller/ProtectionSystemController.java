package com.coursework.fireProtectionSystems.controller;


import com.coursework.fireProtectionSystems.model.ProtectionSystem;
import com.coursework.fireProtectionSystems.service.ProtectionSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/protectionsystem")
public class ProtectionSystemController {

    private final ProtectionSystemService systemService;

    public ProtectionSystemController(ProtectionSystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/all")
    public ResponseEntity <List<ProtectionSystem>> getAllSystem(){
        List<ProtectionSystem> systems = systemService.findAllSystem();
        return new ResponseEntity<>(systems, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity <ProtectionSystem> getSystemById(@PathVariable("id") Long id){
        ProtectionSystem system = systemService.findSystemById(id);
        return new ResponseEntity<>(system, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProtectionSystem> addSystem(@RequestBody ProtectionSystem system){
        ProtectionSystem newSystem = systemService.addSystem(system);
        return new ResponseEntity<>(newSystem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProtectionSystem> updateSystem(@RequestBody ProtectionSystem system){
        ProtectionSystem updateSystem = systemService.updateSystem(system);
        return new ResponseEntity<>(updateSystem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        systemService.deleteSystem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
