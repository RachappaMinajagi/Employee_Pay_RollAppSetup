package com.bridgelabz.employeepayrollapp.service;
/**
 *  import all  the class
 */

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
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
        return "Welcome " + name;
    }

    public String postMessage(EmployeeDTO employeeDTO) {
        return "Hello " + employeeDTO.getFirstName() + "" + employeeDTO.getLastName() + "!";
    }

    public String putMessage(String name) {
        return "How are you, " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll !!!";
    }

    public Employee postDataToRepo(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    public List<Employee> getAllData() {
        List<Employee> list = repository.findAll();
        return list;
    }

    public Optional<Employee> getDataById(Integer id) {
        Employee newEmployee = repository.getById(id);
        return Optional.of(newEmployee);
    }

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(id, employeeDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return null;
    }
}