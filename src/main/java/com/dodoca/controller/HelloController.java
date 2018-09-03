package com.dodoca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    public Map<String, Object> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from design_feature");
        return maps.get(0);
    }

}
