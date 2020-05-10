package com.hq.mapper;

import com.hq.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastName = #{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastname,email,gender,d_id) VALUES(#{lastname}, #{email}, #{gender}, #{dId})")
    public void insertEmployee(Employee employee);
}
