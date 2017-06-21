package com.inovia.cars.rest.builder;

import com.inovia.cars.rest.domain.Car;

/**
 * Builder class for building the Cars.
 * Bit of over- engineering but Building domain classes with long number of argument with builder
 * is the best approach.
 *
 * @author himanshu.kapoor
 */
public class CarBuilder {

    private Car car = new Car();

    public CarBuilder setDescription(String description) {
        car.setDescription(description);
        return this;
    }

    public CarBuilder setName(String name) {
        car.setName(name);
        return this;
    }

    public CarBuilder setPrice(Double price) {
        car.setPrice(price);
        return this;
    }

    public Car build() {
        return car;
    }
}
