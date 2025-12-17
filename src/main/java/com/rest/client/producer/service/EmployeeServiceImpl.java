package com.rest.client.producer.service;

import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.exception.EmployeeNotFound;
import com.rest.client.producer.model.EmployeeModel;
import com.rest.client.producer.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee add(EmployeeModel employeeModel) {
        return employeeRepository.save(prepareEmployeeEntity(employeeModel));
    }

    @Override
    public Employee update(EmployeeModel employeeModel) {
        var employee = prepareEmployeeEntity(employeeModel);
        employeeRepository.findById(employee.getId()).orElseThrow(() -> new EmployeeNotFound(
                "Employee not found for update" + employee.getId()));
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound(
                "Employee not found for delete" + id));
        employeeRepository.deleteById(id);
    }

    private Employee prepareEmployeeEntity(EmployeeModel employeeModel) {
        return Employee.builder()
                .id(employeeModel.getId())
                .name(employeeModel.getName())
                .department(employeeModel.getDepartment())
                .age(employeeModel.getAge())
                .build();
    }
}
