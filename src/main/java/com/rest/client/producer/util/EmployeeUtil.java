package com.rest.client.producer.util;

import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.model.EmployeeModel;

import java.util.List;

public class EmployeeUtil {

    public static List<EmployeeModel> prepareEmployeeModel(List<Employee> employees) {
        return employees.stream()
                .map(employee -> EmployeeModel.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .age(employee.getAge())
                        .department(employee.getDepartment())
                        .build())
                .toList();
    }

    public static EmployeeModel prepareEmployeeModel(Employee employee) {
        return EmployeeModel.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .department(employee.getDepartment())
                .build();
    }
}
