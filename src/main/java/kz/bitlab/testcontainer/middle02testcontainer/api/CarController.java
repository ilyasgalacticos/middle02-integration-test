package kz.bitlab.testcontainer.middle02testcontainer.api;

import kz.bitlab.testcontainer.middle02testcontainer.model.Car;
import kz.bitlab.testcontainer.middle02testcontainer.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car){
        Car newCar = carService.createCar(car);
        return newCar;
    }

}
