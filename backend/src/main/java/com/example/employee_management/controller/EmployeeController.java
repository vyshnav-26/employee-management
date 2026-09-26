package com.example.employee_management.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
class EmployeeController{

    //creating employeeService object -- spring does this automatically by @service
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //GetMapping ----------------------------------------------------------------------------------------
    
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.search(id));
    }

    @GetMapping("/employees/search")
    public List<Employee> searchEmployees(@RequestParam String name){
        return employeeService.searchEmployees(name);
    }
    
    //PostMapping ----------------------------------------------------------------------------------------
    
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.status(201).body(employeeService.addEmployee(employee));
    }

    //PutMapping ----------------------------------------------------------------------------------------
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }

    //DeleteMapping ----------------------------------------------------------------------------------------
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(204).build();
    }
}