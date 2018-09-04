package com.dodoca.service.impl;

import com.dodoca.entity.Employee;
import com.dodoca.mapper.EmployeeMapper;
import com.dodoca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        if(id == null){
            System.out.println("传入的参数为空,日志记录抛异常");
        }
        return employeeMapper.getEmpById(id);
    }

    @Override
    public int insertEmployee(Employee employee) {
        if(employee == null){
            System.out.println("无法将空对象插入,日志记录抛异常");
        }
        return employeeMapper.insertEmp(employee);
    }
}
