package com.hq.controller;

import com.hq.bean.Employee;
import com.hq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControllerCache {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp2/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmpById(id);
        return employee;
    }

    @GetMapping("/emp2")
    public Employee updateEmp(Employee employee) {
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
}
