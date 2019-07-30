package com.example.demo.dependency_injection;

import com.example.demo.interfaces.Nameable;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Nameable {
    @Override
    public String getName() {
        return "DOG";
    }
}
