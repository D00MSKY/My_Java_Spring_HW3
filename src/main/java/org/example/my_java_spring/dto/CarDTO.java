package org.example.my_java_spring.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CarDTO {

    private int id;

    @NotBlank
    private String model;
    @Min(value = 0, message = "Engine power min 0")
    @Max(value = 1_000, message = "Engine power max 1000")
    private int enginePower;
    @Min(value = 100, message = "Torque min 100")
    @Max(value = 1000, message = "Torque max 1000")
    private Integer torque;
}
