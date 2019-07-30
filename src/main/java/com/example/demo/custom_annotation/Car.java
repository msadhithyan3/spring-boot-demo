package com.example.demo.custom_annotation;

public class Car {
    @JsonField(key = "manufacturer")
    private String make;
    @JsonField
    private String model;
    private String year;

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    @JsonMethod
    private void initNames() {
        this.make = this.make.substring(0, 1).toUpperCase()
                + this.make.substring(1);
        this.model = this.model.substring(0, 1).toUpperCase()
                + this.model.substring(1);
    }
}
