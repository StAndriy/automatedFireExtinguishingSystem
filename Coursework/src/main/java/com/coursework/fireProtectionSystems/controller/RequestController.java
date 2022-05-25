package com.coursework.fireProtectionSystems.controller;

import com.coursework.fireProtectionSystems.model.RequestOnAct;
import com.coursework.fireProtectionSystems.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/request")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestOnAct>> getAllRequest(){
        List<RequestOnAct> requestOnActs = requestService.findAllRequest();
        return new ResponseEntity<>(requestOnActs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable("id") Long id) {
        requestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<List<RequestOnAct>> getRequestsById(@PathVariable("id") Long id){
        List<RequestOnAct> requestOnActs = requestService.findById(id);
        return new ResponseEntity<>(requestOnActs, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<RequestOnAct> addRequests(@RequestBody RequestOnAct request){
        RequestOnAct requestOnAct = requestService.addRequest(request);
        return new ResponseEntity<>(requestOnAct, HttpStatus.CREATED);
    }
}
