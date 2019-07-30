/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author adithyan
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public ResponseEntity helloWorld() {
        return new ResponseEntity("hello world", HttpStatus.OK);
    }

    @GetMapping(path = "/hello-world-bean")
    public ResponseEntity helloWorldBean() {
        HelloWorldBean hello_world = new HelloWorldBean("hello world");
        return new ResponseEntity(hello_world, HttpStatus.OK);
    }

    @GetMapping(path = "/hello-world-path-variable/{name}")
    public ResponseEntity helloWorldPathVariable(@PathVariable String name) {
        HelloWorldBean hello_world = new HelloWorldBean(name);
        return new ResponseEntity(hello_world, HttpStatus.OK);
    }
}
