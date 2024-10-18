package org.example.my_java_spring.repository;


import org.example.my_java_spring.properties.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Optional<Car> findById(Long id);

    List<Car> findAllByEnginePowerBetween(Double minEnginePower, Double maxEnginePower);

    List<Car> findAllByEnginePowerGreaterThan(Double minEnginePower);

    List<Car> findAllByEnginePowerLessThan(Double maxEnginePower);

    void deleteById(Long carId);
}
