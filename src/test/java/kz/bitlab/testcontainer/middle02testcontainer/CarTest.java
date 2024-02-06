package kz.bitlab.testcontainer.middle02testcontainer;

import kz.bitlab.testcontainer.middle02testcontainer.api.CarController;
import kz.bitlab.testcontainer.middle02testcontainer.model.Car;
import kz.bitlab.testcontainer.middle02testcontainer.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Sql(scripts = {"classpath:/database/car/insert.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"classpath:/database/car/clean.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CarTest extends AbstractTestCar {

    @Autowired
    private CarController carController;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testCarCreate() {

        Car car = new Car();
        car.setName("Zeekr 001");
        car.setPrice(21000000);
        car.setManufacturer("China");

        Car createdCar = carController.createCar(car);
        assertNotNull(createdCar);
        assertNotNull(createdCar.getId());
        assertEquals(car.getPrice(), createdCar.getPrice());
        assertEquals(car.getManufacturer(), createdCar.getManufacturer());
        assertEquals(car.getName(), createdCar.getName());

    }

    @Test
    public void testCarGetList() {

        List<Car> carList = carController.getCars();
        assertNotNull(carList);

        int carSizeBefore = carList.size();

        Car newCar = new Car();
        newCar.setName("Hyundai");
        newCar.setPrice(777777);
        newCar.setManufacturer("South Korea");
        carRepository.save(newCar);

        List<Car> allCarListAfter = carController.getCars();
        assertNotNull(allCarListAfter);
        assertNotEquals(0, allCarListAfter.size());
        assertEquals(carSizeBefore + 1, allCarListAfter.size());

    }
}
