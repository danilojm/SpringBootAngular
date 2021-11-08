package com.danilo.angular.service;

import com.danilo.angular.exception.UserNotFoundException;
import com.danilo.angular.model.Employee;
import com.danilo.angular.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return repo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }

}
