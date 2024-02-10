package kz.bitlab.testcontainer.middle02testcontainer;

import kz.bitlab.testcontainer.middle02testcontainer.model.Car;
import kz.bitlab.testcontainer.middle02testcontainer.repository.CarRepository;
import kz.bitlab.testcontainer.middle02testcontainer.service.CarService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void createCarTest(){

        Car car = new Car();
        car.setName("Mercedes");
        car.setManufacturer("Germany");
        car.setId(1L);
        car.setPrice(20000);
        when(carRepository.save(any(Car.class))).thenReturn(car);

        Car testingCar = new Car();
        testingCar.setName("Mercedes");
        testingCar.setManufacturer("Germany");
        testingCar.setPrice(20000);

        Car createdCar = carService.createCar(testingCar);

        assertNotNull(createdCar);
        assertEquals(testingCar.getName(), createdCar.getName());
        assertEquals(testingCar.getPrice(), createdCar.getPrice());
        assertEquals(testingCar.getManufacturer(), createdCar.getManufacturer());

        verify(carRepository).save(testingCar);

    }

    @Test
    void getAllCarsTest(){

        List<Car> cars = Arrays.asList(
                new Car(1L, "Mercedes", 20000, "Germany"),
                new Car(2L, "Toyota", 15000, "Japan"),
                new Car(3L, "Mazda", 10000, "Japan")
        );

        when(carRepository.findAll()).thenReturn(cars);

        List<Car> carList = carService.getAllCars();
        assertNotNull(carList);
        assertTrue(carList.size() > 0);
        verify(carRepository).findAll();

    }

}
