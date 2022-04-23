package com.bridgelabz.employeepayrollapp.service;



import com.bridgelabz.employeepayrollapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeePayrollService {
    String getMessage(String name);

    String postMessage(Employee employee);

    String putMessage(String name);

    String getWelcome();

    public Employee postDataToRepo(Employee employee);

    public List<Employee> getAllData();

    public Employee getDataById(Integer id);

    public Employee updateDataById(Integer id, Employee employee);

    public String deleteDataById(Integer id);
}