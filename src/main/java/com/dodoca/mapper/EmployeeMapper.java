package com.dodoca.mapper;

import com.dodoca.entity.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Delete("delete from employee where id=#{id}")
    int deleteById(Integer id);

    @Insert("insert into employee(name, age) values(#{name},#{age})")
    int insertEmp(Employee employee);

    @Update("update employee set name = #{name} age = #{age} where id = #{id}")
    int updateById(Employee emp);
}
