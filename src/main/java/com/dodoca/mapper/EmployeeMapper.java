package com.dodoca.mapper;

import com.dodoca.entity.Employee;
import org.apache.ibatis.annotations.*;

public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Delete("delete from employee where id=#{id}")
    int deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") //指定开启主键自增,并指定自增主键字段
    @Insert("insert into employee(name, age) values(#{name},#{age})")
    int insertEmp(Employee employee);

    @Update("update employee set name = #{name} age = #{age} where id = #{id}")
    int updateById(Employee emp);
}
