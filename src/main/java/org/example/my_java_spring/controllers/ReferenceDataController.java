package org.example.my_java_spring.controllers;

import lombok.RequiredArgsConstructor;
import org.example.my_java_spring.properties.Fuel;
import org.example.my_java_spring.properties.ReferenceDataProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ReferenceDataController {


    private final ReferenceDataProperties referenceDataProperties;

    @Value("${reference-data.engineTypes}")
    private List<String> types;

    @GetMapping("/engine-types")
    public ResponseEntity<List<String>> getEngineTypes(){
        return ResponseEntity.ok(types);
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<Fuel>> getFuelTypes(){
        return ResponseEntity.ok(referenceDataProperties.getFuels());
    }

    @GetMapping("/fuel-types/{name}")
    public ResponseEntity<Fuel> getFuelType(@PathVariable String name){
        Optional<Fuel> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(result);

    }
}
