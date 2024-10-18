package org.example.my_java_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Homework 3
//
//Використовувати аплікацію CarService із попереднього ДЗ.
//
//Додати DTO для Car. Перенести усю логіку роботи з базою даних у сервісний рівень (котролер повинен "знати" лише про CarDto і CarService, а CarRepository і Car (entity) повинні використовуватися лише в CarService).
//
//Додати валідацію на поля авто через анотації з пакету jakarta.validation.constraints (наприклад, не порожня назва, потужність більша 0 і тд тп).
//
//Додатково: додати поле fuelType для Car і CarDto та написати власну анотацію для перевірки цього поля, щоб воно могло мати лише ті значення, які вказані у конфігурації.

@SpringBootApplication
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

}
