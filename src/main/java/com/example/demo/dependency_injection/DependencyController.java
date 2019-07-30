package com.example.demo.dependency_injection;

import com.example.demo.interfaces.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DependencyController {
    @Autowired
    private GreetingService greetingService;
    @Autowired
    private NameHelper nameHelper;

    @GetMapping("/greetingService")
    public ResponseEntity greetingService() {
        String greet = greetingService.greet();
        return new ResponseEntity(greet, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity name(@RequestParam String type) {
        String name = nameHelper.getName(type);
        return new ResponseEntity(name, HttpStatus.OK);
    }
}
