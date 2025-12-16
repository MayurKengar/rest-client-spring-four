package com.rest.client.producer.response;


import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.model.EmployeeModel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class EmployeeResponse {
    private EmployeeModel employeeModel;
    private Boolean status;
    private String message;
    private List<EmployeeModel> employees;
}
