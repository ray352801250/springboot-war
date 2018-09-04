package com.dodoca.controller;

import com.dodoca.entity.Employee;
import com.dodoca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employee/{id}")
//    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee")
    public int insertEmp(Employee emp){
        return employeeService.insertEmployee(emp);
    }

    @GetMapping("/emp")
    public Employee insetEmp(Employee employee){
        return employeeService.insertEmp(employee);
    }
}
