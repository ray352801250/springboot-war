package com.dodoca.controller;

import com.dodoca.entity.Employee;
import com.dodoca.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/hello")
    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    public Map<String, Object> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from design_feature");
        return maps.get(0);
    }


    @GetMapping("/emp/{id}")
    @ResponseBody
//    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp")
    @ResponseBody
    public int insertEmp(Employee emp){
        return employeeMapper.insertEmp(emp);
    }
}
