package com.dodoca.controller;

import com.dodoca.entity.Employee;
import com.dodoca.mapper.EmployeeMapper;
import com.dodoca.service.EmployeeService;
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
    EmployeeService employeeService;

    @GetMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from design_feature");
        return maps.get(0);
    }
}
