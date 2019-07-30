package com.example.demo.dependency_injection;

import com.example.demo.interfaces.Nameable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NameHelper {
    private Nameable cat;
    private Nameable dog;

    public String getName(String type) {
        switch (type) {
            case "cat":
                return cat.getName();
            case "dog":
                return dog.getName();
            default:
                return "UNKNOWN";
        }
    }

    @Autowired
    @Qualifier("cat")
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Autowired
    @Qualifier("dog")
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
