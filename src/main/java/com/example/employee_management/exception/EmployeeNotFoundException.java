package com.example.employee_management.exception;

public class EmployeeNotFoundException extends RuntimeException{
    
    public EmployeeNotFoundException(String role , Integer id) {
        super(role + " with ID "+id+" not found");
    }
}