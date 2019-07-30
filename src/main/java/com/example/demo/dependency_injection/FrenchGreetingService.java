package com.example.demo.dependency_injection;

import com.example.demo.interfaces.GreetingService;

public class FrenchGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Bonjour Monde!";
    }
}
