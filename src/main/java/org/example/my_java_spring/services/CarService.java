package org.example.my_java_spring.services;

import lombok.RequiredArgsConstructor;
import org.example.my_java_spring.dto.CarDTO;
import org.example.my_java_spring.dto.CarUpdateDTO;
import org.example.my_java_spring.mapper.CarMapper;
import org.example.my_java_spring.properties.Car;
import org.example.my_java_spring.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<CarDTO> getCars(Double minEnginePower, Double maxEnginePower) {
        if (minEnginePower != null && maxEnginePower != null) {
            return carRepository.findAllByEnginePowerBetween(minEnginePower, maxEnginePower)
                    .stream()
                    .map(carMapper::mapToDTO)
                    .collect(Collectors.toList());
        } else if (minEnginePower != null) {
            return carRepository.findAllByEnginePowerGreaterThan(minEnginePower)
                    .stream()
                    .map(carMapper::mapToDTO)
                    .collect(Collectors.toList());
        } else if (maxEnginePower != null) {
            return carRepository.findAllByEnginePowerLessThan(maxEnginePower)
                    .stream()
                    .map(carMapper::mapToDTO)
                    .collect(Collectors.toList());
        } else {
            return carRepository.findAll()
                    .stream()
                    .map(carMapper::mapToDTO)
                    .collect(Collectors.toList());

        }
    }

    public CarDTO getCarById (int id){
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id does not exist"));
        return carMapper.mapToDTO(car);
    }

    public CarDTO createCar(CarDTO carDTO){
        Car car = carRepository.save(carMapper.mapToCar(carDTO));
        return carMapper.mapToDTO(car);
    };

    public CarDTO updateCar(int id, CarUpdateDTO carUpdateDTO){
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id does not exist"));
        car.setModel(carUpdateDTO.getModel());
        car.setEnginePower(carUpdateDTO.getEnginePower());
        car.setTorque(carUpdateDTO.getTorque());
        Car savedCar = carRepository.save(car);
        return carMapper.mapToDTO(savedCar);
    }

    public void delete (int id){
        carRepository.deleteById(id);
    }
}
