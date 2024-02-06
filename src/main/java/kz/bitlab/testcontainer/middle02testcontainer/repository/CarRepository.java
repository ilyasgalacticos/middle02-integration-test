package kz.bitlab.testcontainer.middle02testcontainer.repository;

import kz.bitlab.testcontainer.middle02testcontainer.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
