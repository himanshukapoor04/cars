package com.inovia.cars.rest.resources;

import com.inovia.cars.rest.builder.CarBuilder;
import com.inovia.cars.rest.repository.CarRepository;
import com.inovia.cars.rest.vo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Controller Class for the REST end points.
 */
@RestController
@RequestMapping("/cars")
public class CarsRESTController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(method =  RequestMethod.GET)
    public List<Car> getCars() {
        return Optional.ofNullable(carRepository.findAll()).orElseGet(Collections::emptyList)
                .stream().map(car -> new Car(car)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value="/{name}")
    public List<Car> getCarsByName(@PathVariable String name) {
        return Optional.ofNullable(carRepository.findByName(name)).orElseGet(Collections::emptyList)
                .stream().map(car -> new Car(car)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Car createCar(@RequestBody Car car) {
        return new Car(carRepository.save(
                new CarBuilder().setDescription(car.getDescription()).setName(car.getName())
                        .setPrice(car.getPrice()).build()));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteCar(@PathVariable String id) {
        carRepository.delete(id);
    }
}
