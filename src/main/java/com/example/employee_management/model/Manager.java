package com.example.employee_management.model;

import com.example.employee_management.model.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
public class Manager{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Email
    private String email;
    
    public Integer getId(){
        return id;
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
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public Manager(){
    }
    
    public Manager(Integer id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}