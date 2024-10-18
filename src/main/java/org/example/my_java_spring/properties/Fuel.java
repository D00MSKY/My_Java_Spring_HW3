package org.example.my_java_spring.properties;

import lombok.Data;

import java.util.List;


@Data
public class Fuel {

    private String name;
    private List<String> types;

}
