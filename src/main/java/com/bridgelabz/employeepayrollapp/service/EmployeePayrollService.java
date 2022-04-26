package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.Exeption.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *  import all  the class
 */

@Service

//Created EmployeePayrollService class to serve api calls done by controller layer
public class EmployeePayrollService implements IEmployeePayrollService {

    //Autowired EmployeePayrollRepository interface to inject its dependency here
    @Autowired
    EmployeePayrollRepository repository;

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

    public Employee getDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isPresent()) {
            return newEmployee.get();
        } else throw new EmployeePayrollException("Employee id not found");
    }

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isPresent()) {
            Employee employee = new Employee(id, employeeDTO);
            repository.save(employee);
            return employee;
        } else {
            throw new EmployeePayrollException("Employee Not found");
        }
    }

    public String deleteDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isEmpty()) {
            throw new EmployeePayrollException("Employee Details not found");
        } else {
            repository.deleteById(id);
        }
        return null;
    }

    //Abilty to serve controller class api to retrieve data having particular department
    public List<Employee> getDataByDepartment(String department) {
        List<Employee> newEmp = repository.findByDepartment(department);
        if (newEmp.isEmpty()) {
            throw new EmployeePayrollException("Employee Not Found");
        }
        return newEmp;
    }
}