package org.example.my_java_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Homework 2
//
//Використовувати аплікацію CarService із попереднього ДЗ.
//
//Підключити базу даних (на вибір - PosgreSQL, MySQL чи інша)
//
//Створити сутність Car, для роботи з базою даних.
//
//Car { id, model, enginePower }
//
//За допомогою liquibase створити міграцію (changelog/changeset) на створення таблиці car у базі даних.
//
//Додати CarController з базовими CRUD операціями:
//
//GET /cars - повертає список усіх авто
//GET /cars/{id} - повертає конкретне авто по ІД
//POST /cars - створює нове авто
//PUT /cars/{id} - оновлює дані про авто по ІД
//DELETE /cars/{id} - видалити авто по ІД
//Для GET /cars реалізувати пошук за наступними параметрами (@RequestParam):
//minEnginePower - мінімальна потужність двигуна
//maxEnginePower - максимальна потужність двигуна
//
//Додати нову колонку torque до таблиці car і відповідної сутності через changeSet.

@SpringBootApplication
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

}
