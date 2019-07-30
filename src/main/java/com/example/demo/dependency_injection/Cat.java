package com.example.demo.dependency_injection;

import com.example.demo.interfaces.Nameable;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Nameable {
    @Override
    public String getName() {
        return "CAT";
    }
}
