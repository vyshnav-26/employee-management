package com.example.employee_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String role;
    @NotBlank
    private String name;
    @Email
    private String email;
    public Integer getId(){
        return id;
    }
    public String getRole(){
        return role;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Employee(){
    }
    public Employee(Integer id,String role,String name,String email){
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
    }
}