package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {
    String getMessage(String name);

    String postMessage(EmployeeDTO employee);

    String putMessage(String name);

    String getWelcome();

    public Employee postDataToRepo(EmployeeDTO employee);

    public List<Employee> getAllData();

    public Optional<Employee> getDataById(Integer id);

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO);

    public String deleteDataById(Integer id);
}