package com.rest.client.producer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EmployeeModel {
    private Long id;

    private String name;
    private String department;
    private Integer age;
}
