package com.example.crud.controller;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/employee/v3")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findALLEmployee() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return this.employeeService.getEmployeesById(id);
    }


    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        try {
            this.employeeService.deleteEmployee(id);
            return new ResponseEntity<>("delete done", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("delete not done", HttpStatus.BAD_REQUEST);
        }
    }
}