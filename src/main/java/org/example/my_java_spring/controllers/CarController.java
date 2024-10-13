package org.example.my_java_spring.controllers;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.my_java_spring.properties.Car;
import org.example.my_java_spring.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ){
        if (minEnginePower !=null && maxEnginePower!=null){
            return ResponseEntity.ok(carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower));
        } else if (minEnginePower!= null) {
            return ResponseEntity.ok(carRepository.findAllByEnginePowerGreaterThan(minEnginePower));
        } else if (maxEnginePower != null){
            return ResponseEntity.ok(carRepository.findAllByEnginePowerLessThan(maxEnginePower));
        } else {
            return ResponseEntity.ok(carRepository.findAll());
        }

    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        return ResponseEntity.of(carRepository.findById(id));
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(name = "id") Long carId, @RequestBody Car car){
        return ResponseEntity.of(
                carRepository
                        .findById(carId)
                        .map(oldCar -> {
                            oldCar.setModel(car.getModel());
                            oldCar.setEnginePower(car.getEnginePower());
                            oldCar.setTorque(car.getTorque());
                            return carRepository.save(oldCar);
                        })
        );
    }
    @Transactional
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") Long carId){
        carRepository.deleteById(carId);
        return ResponseEntity.ok().build();
    }

}
