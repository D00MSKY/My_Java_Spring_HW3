package org.example.my_java_spring.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorDTO {

    private String details;
    private LocalDateTime timestamp;

}
