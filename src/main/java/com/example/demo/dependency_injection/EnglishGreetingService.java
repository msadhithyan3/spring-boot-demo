package com.example.demo.dependency_injection;

import com.example.demo.interfaces.GreetingService;

public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet()    {
        return "Hello World!";
    }
}
