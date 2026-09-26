package com.example.employee_management.service;

import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService{

    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //Getting stuff ----------------------------------------------------------------------------------------

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee search(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee" , id);
        }
        return employee.get();
    }

    public List<Employee> searchEmployees(String name){

        return employeeRepository.findByName(name);
    }

    //adding stuff ----------------------------------------------------------------------------------------

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //updating stuff ----------------------------------------------------------------------------------------

    public Employee updateEmployee(Integer id, Employee employee){
        Employee response = search(id);
        response.setRole(employee.getRole());
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        return employeeRepository.save(response);
    }

    //deleting stuff ----------------------------------------------------------------------------------------

    public Employee deleteEmployee(Integer id){
        Employee employee = search(id);
        employeeRepository.deleteById(employee.getId());
        return employee;
    }
}