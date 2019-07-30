/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author adithyan
 */
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "ram", new Date()));
        users.add(new User(2, "jhon", new Date()));
        users.add(new User(3, "smith", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
