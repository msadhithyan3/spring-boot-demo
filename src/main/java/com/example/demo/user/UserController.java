/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.user;

import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author adithyan
 */
@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        List<User> users = userDaoService.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable Integer id) throws ResourceNotFoundException {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new ResourceNotFoundException("user not found " + id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping("/users/addUser")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        return new ResponseEntity(savedUser, HttpStatus.CREATED);
    }
}
