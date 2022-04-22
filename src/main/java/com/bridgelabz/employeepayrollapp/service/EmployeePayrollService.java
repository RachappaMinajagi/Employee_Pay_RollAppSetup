package com.bridgelabz.employeepayrollapp.service;


import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository repository;

    public String getMessage(String name) {
        return "Welcome To Employee Program " + name;
    }

    public Employee postMessage(Employee employee) {
        Employee newemployee =new Employee(employee);
        return repository.save(newemployee);
    }

    public String putMessage(String name) {
        return "Hey Dude , " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll App.....!";
    }

    @Override
    public Employee postDataToRepo(Employee employee) {
        repository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllData() {
        List<Employee> list = repository.findAll();
        return list;
    }

    @Override
    public Optional<Employee> getDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        return newEmployee;
    }

    public Employee updateDataById(Integer id, Employee employee) {
        Employee newEmployee = new Employee(id, employee.getFirstName(), employee.getLastName(), employee.getProfilePic(), employee.getDepartment(), employee.getSalary(), employee.getDate(), employee.getNotes());
        repository.save(newEmployee);
        return newEmployee;
    }

    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return "Employee with ID:" + id + " got deleted";
    }


}