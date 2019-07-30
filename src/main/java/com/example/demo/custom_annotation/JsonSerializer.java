package com.example.demo.custom_annotation;

import com.example.demo.exception.JsonSerializeException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class JsonSerializer {
    public String serialize(Object object) throws JsonSerializeException {
        try {
            initializeObject(object);
            return toJsonString(convertToJson(object));
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        } catch (InvocationTargetException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }

    private Map<String, String> convertToJson(Object object) throws IllegalAccessException {
        Class<?> objectClass = requireNonNull(object).getClass();
        Map<String, String> jsonElements = new HashMap<>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class))
                jsonElements.put(getSerializedKey(field), (String) field.get(object));
        }
        return jsonElements;
    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(JsonMethod.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap
                .entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    private String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).key();
        if (annotationValue.isEmpty())
            return field.getName();
        else
            return annotationValue;
    }
}
