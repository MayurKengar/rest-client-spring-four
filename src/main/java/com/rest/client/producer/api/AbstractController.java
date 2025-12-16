package com.rest.client.producer.api;

import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.response.EmployeeResponse;
import com.rest.client.producer.util.EmployeeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class AbstractController {

    ResponseEntity<EmployeeResponse> deferredResult(List<Employee> employees) {
        EmployeeResponse response = EmployeeResponse.builder()
                .message("Employee fetched successfully!!!")
                .status(true)
                .employees(EmployeeUtil.prepareEmployeeModel(employees))
                .build();
        return ResponseEntity.ok(response);
    }

    ResponseEntity<EmployeeResponse> deferredResult(Employee employee, boolean bCreate) {
        EmployeeResponse response = EmployeeResponse.builder()
                .message(String.format("Employee %s successfully!!!", bCreate ? "Created" :
                        "Updated"))
                .status(true)
                .employeeModel(EmployeeUtil.prepareEmployeeModel(employee))
                .build();
        return ResponseEntity.status(bCreate ? HttpStatus.CREATED : HttpStatus.OK)
                .body(response);
    }

    ResponseEntity<EmployeeResponse> deferredResult() {
        EmployeeResponse response = EmployeeResponse.builder()
                .message("Employee Deleted successfully!!!")
                .status(true)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
