package com.rest.client.producer.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_seq", strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String department;
    private Integer age;
}
