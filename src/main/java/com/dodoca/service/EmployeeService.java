package com.dodoca.service;

import com.dodoca.entity.Employee;

public interface EmployeeService {

    /**
     * 根据id获取员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 新增员工信息
     * @param employee
     * @return
     */
    int insertEmployee(Employee employee);

}
