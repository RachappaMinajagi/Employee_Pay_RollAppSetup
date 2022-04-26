package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {

    public String getWelcome();

    public Employee postDataToRepo(EmployeeDTO employeeDTO);

    public List<Employee> getAllData();

    public Employee getDataById(Integer id);

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO);

    public String deleteDataById(Integer id);
}