package com.example.demo.controller;

import com.example.demo.service.EngineService;
import org.bonitasoft.engine.identity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class EngineController {
    private EngineService engineService;

    public EngineController(EngineService engineService){
        this.engineService = engineService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<List<User>>(this.engineService.getUsers(), HttpStatus.OK);
    }
}
