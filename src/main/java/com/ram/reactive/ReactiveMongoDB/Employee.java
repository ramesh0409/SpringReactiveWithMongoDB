package com.ram.reactive.ReactiveMongoDB;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String empName;
}
