package com.inovia.cars.rest.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Value object which should be read from the client.
 * Validations should be done so as to avoid bad inputs from the client.
 */
public class Car {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESCRIPTION_LENGTH = 200;

    private String id;

    @NotEmpty(message = "Name Cannot be empty")
    @Size(max = MAX_NAME_LENGTH, message = "Name's length cannot be greater than " + MAX_NAME_LENGTH)
    private String name;

    @Size(max = MAX_DESCRIPTION_LENGTH, message = "Description's length cannot be greater than " + MAX_DESCRIPTION_LENGTH)
    private String description;

    @Min(value = 0L, message = "Price must be a positive value.")
    private Double price;

    /* Required for JSON transformation */
    public Car() {

    }
    
    public Car(com.inovia.cars.rest.domain.Car car) {
        this.id = car.getId();
        this.name = car.getName();
        this.description = car.getDescription();
        this.price = car.getPrice();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
