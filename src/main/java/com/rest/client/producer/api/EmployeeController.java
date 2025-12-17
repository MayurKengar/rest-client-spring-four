package com.rest.client.producer.api;


import com.rest.client.producer.model.EmployeeModel;
import com.rest.client.producer.response.EmployeeResponse;
import com.rest.client.producer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController extends AbstractController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<EmployeeResponse> getAllEmployee() {
        return deferredResult(employeeService.getAllEmployee());
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody
                                                        EmployeeModel employeeModel) {
        return deferredResult(employeeService.add(employeeModel), true);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody
                                                           EmployeeModel employeeModel) {
        return deferredResult(employeeService.update(employeeModel), false);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeResponse> deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.delete(id);
        return deferredResult();
    }
}
