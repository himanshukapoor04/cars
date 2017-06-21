package com.inovia.cars.rest.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.inovia.cars.rest.builder.CarBuilder;
import com.inovia.cars.rest.repository.CarRepository;
import com.inovia.cars.rest.resources.CarsRESTController;
import com.inovia.cars.rest.vo.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Unit Test class for Controller
 */
@RunWith(MockitoJUnitRunner.class)
public class CarsRESTControllerTest {

    private static final String FERRARI = "ferrari";
    private static final String RED_FERRARI = "Red ferrai";
    private static final Double PRICE = new Double(120.20);
    private static com.inovia.cars.rest.domain.Car SAMPLE_FRERRAI = new CarBuilder().
            setName(FERRARI).setDescription(RED_FERRARI).setPrice(PRICE).build();

    @InjectMocks
    private CarsRESTController controller;

    @Mock
    private CarRepository repository;

    @Test
    public void shouldReturnBlankArrayWhenNoCarIsPresent() {
        doNothing().when(repository.findAll());
        List<Car> cars = controller.getCars();
        assertNotNull(cars);
        assertTrue(cars.isEmpty());
    }

    @Test
    public void shouldReturnCarsWhenCarIsPresent() {
        when(repository.findAll()).thenReturn(Arrays.asList(SAMPLE_FRERRAI));
        List<Car> cars = controller.getCars();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
        assertEquals(1, cars.size());
        assertEquals(FERRARI, cars.get(0).getName());
        assertEquals(PRICE, cars.get(0).getPrice());
    }

    


}
