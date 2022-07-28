package com.example.crud.service;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return this.repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return this.repository.findAll();
    }


    public Employee getEmployeesById(int id) {
        return this.repository.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        this.repository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return this.repository.save(employee);
    }
}