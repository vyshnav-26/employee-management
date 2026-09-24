package com.example.employee_management.controller;

import com.example.employee_management.service.ManagerService;
import com.example.employee_management.model.Manager;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import java.util.List;

@RestController
class ManagerController{

    private ManagerService managerService;
    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    @GetMapping("/managers")
    public List<Manager> getManagers(){
        return managerService.getManagers();
    }
    
    @GetMapping("/managers/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable Integer id){
        return ResponseEntity.ok(managerService.search(id));
    }

    @PostMapping("/managers")
    public ResponseEntity<Manager> addManager(@Valid @RequestBody Manager manager){
        return ResponseEntity.status(201).body(managerService.addManager(manager));
    }

    @PutMapping("/managers/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Integer id,@Valid @RequestBody Manager manager){
        return ResponseEntity.ok(managerService.updateManager(id,manager));
    }

    @DeleteMapping("/managers/{id}")
    public ResponseEntity<Manager> deleteManager(@PathVariable Integer id){
        return ResponseEntity.ok(managerService.deleteManager(id));
    }
}