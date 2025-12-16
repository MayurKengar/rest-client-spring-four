package com.rest.client.producer.api;


import com.rest.client.producer.entity.Employee;
import com.rest.client.producer.model.EmployeeModel;
import com.rest.client.producer.response.EmployeeResponse;
import com.rest.client.producer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController extends AbstractController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<EmployeeResponse> getAllEmployee() {
        List<Employee> employee = employeeService.getAllEmployee();
        return deferredResult(employee);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody
                                                        EmployeeModel employeeModel) {
        Employee employee = employeeService.add(employeeModel);
        return deferredResult(employee, true);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody
                                                           EmployeeModel employeeModel) {
        Employee employee = employeeService.update(employeeModel);
        return deferredResult(employee, false);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return deferredResult();
    }
}
