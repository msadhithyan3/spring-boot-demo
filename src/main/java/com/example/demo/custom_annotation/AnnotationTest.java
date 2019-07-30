package com.example.demo.custom_annotation;

import com.example.demo.exception.JsonSerializeException;

public class AnnotationTest {
    public static void main(String[] args) {
        Car car = new Car("ford", "basic", "2019");
        JsonSerializer serializer = new JsonSerializer();
        try {
            String serialize = serializer.serialize(car);
            System.out.println("serialize : " + serialize);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }
    }
}
