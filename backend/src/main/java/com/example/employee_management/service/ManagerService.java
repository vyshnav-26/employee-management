package com.example.employee_management.service;

import com.example.employee_management.repository.ManagerRepository;
import com.example.employee_management.model.Manager;
import com.example.employee_management.exception.EmployeeNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService{

    private ManagerRepository managerRepository;
    public ManagerService(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers(){
        return managerRepository.findAll();
    }

    public Manager search(Integer id){
        Optional<Manager> manager = managerRepository.findById(id);
        if(manager.isEmpty()){
            throw new EmployeeNotFoundException("Manager" , id);
        }
        return manager.get();
    }

    public Manager addManager(Manager manager){
        return managerRepository.save(manager);
    }

    public Manager updateManager(Integer id, Manager manager){
        Manager temp = search(id);
        temp.setName(manager.getName());
        temp.setEmail(manager.getEmail());
        managerRepository.save(temp);
        return temp;
    }

    public Manager deleteManager(Integer id){
        Manager manager = search(id);
        managerRepository.deleteById(id);
        return manager;
    }
}