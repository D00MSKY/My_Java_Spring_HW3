package org.example.my_java_spring.mapper;

import org.example.my_java_spring.dto.CarDTO;
import org.example.my_java_spring.properties.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDTO mapToDTO(Car car){
        return CarDTO.builder()
                .id(car.getId())
                .model(car.getModel())
                .enginePower(car.getEnginePower())
                .torque(car.getTorque())
                .build();
    }

    public Car mapToCar(CarDTO carDTO){
        Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setEnginePower(carDTO.getEnginePower());
        car.setTorque(carDTO.getTorque());
        return car;
    }


}
