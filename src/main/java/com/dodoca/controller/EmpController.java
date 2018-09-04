package com.dodoca.controller;

import com.dodoca.entity.Employee;
import com.dodoca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600) //解决请求跨域问题
public class EmpController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employee/{id}")
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
