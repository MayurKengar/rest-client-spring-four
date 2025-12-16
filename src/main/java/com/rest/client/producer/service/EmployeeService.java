package com.rest.client.producer.service;


import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee add(EmployeeModel employeeModel);

    Employee update(EmployeeModel employeeModel);

    List<Employee> getAllEmployee();

    void delete(Long id);
}
