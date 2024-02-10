package kz.bitlab.testcontainer.middle02testcontainer.service;

import kz.bitlab.testcontainer.middle02testcontainer.model.Car;
import kz.bitlab.testcontainer.middle02testcontainer.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    public Car createCar(Car car){
        Car newCar = carRepository.save(car);
        log.info("Created car {}", newCar);
        return newCar;
    }

    public List<Car> getAllCars(){
        List<Car> carList = carRepository.findAll();
        log.info("Retrieved all cars {}", carList.size());
        return carList;
    }

}
