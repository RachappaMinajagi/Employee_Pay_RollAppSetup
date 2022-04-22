package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployeePayrollService {
    String getMessage(String name);

    String postMessage(Employee employee);

    String putMessage(String name);
}