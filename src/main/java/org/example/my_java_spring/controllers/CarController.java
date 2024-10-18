package org.example.my_java_spring.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.my_java_spring.dto.CarDTO;
import org.example.my_java_spring.dto.CarUpdateDTO;
import org.example.my_java_spring.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getCars(
            @RequestParam(name = "minEnginePower", required = false) Double minEnginePower,
            @RequestParam(name = "maxEnginePower", required = false) Double maxEnginePower
    ){
        return ResponseEntity.ok(carService.getCars(minEnginePower, maxEnginePower));

    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Object> getCar(@PathVariable int id){
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO carDTO){
        return ResponseEntity.ok(carService.createCar(carDTO));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable(name = "id") int carId, @Valid @RequestBody CarUpdateDTO carUpdateDTO){
        return ResponseEntity.ok(carService.updateCar(carId, carUpdateDTO));
    }
    @Transactional
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") int carId){
        carService.delete(carId);
        return ResponseEntity.noContent().build();
    }

}
