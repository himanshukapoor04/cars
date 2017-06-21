package com.inovia.cars.rest.repository;

import com.inovia.cars.rest.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by himanshu.kapoor on 6/21/2017.
 */
@Repository
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findByName(String name);
}
