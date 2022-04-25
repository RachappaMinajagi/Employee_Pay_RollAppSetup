package com.bridgelabz.employeepayrollapp.controller;
/**
 * import all the Class for employee PayRoll App
 */


import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *  @RestController annotation in order to simplify the creation of RESTful web services.
 */
@RestController
public class EmployeePayrollController {
    /**

     * @Autowired annotation is used for dependency injection.In spring boot application,
     * all loaded beans are eligible for auto wiring to another bean.
     */
    @Autowired
    IEmployeePayrollService service;
    /**
     *@GetMapping annotation maps HTTP GET requests onto specific handler methods
     * @return :Ability to display welcome message
     */
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    /**
     *@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
     * @param employee
     * @return :Ability to save employee details to repository
     */
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<Employee> saveDataToRepo(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    /**
     * @return :Ability to get all employees' data by findAll() method
     */
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<Employee>> getAllDataFromRepo() {
        return new ResponseEntity<List<Employee>>(service.getAllData(), HttpStatus.OK);
    }

    /**
     * Ability to get employee data by id
     */

    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<Employee> getDataFromRepoById(@PathVariable Integer id) {
        Optional<Employee> employee = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Data",employee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    /**
     * @PutMapping
     * As we know PUT HTTP method is used to update/modify the resource so @PutMapping annotation is used for mapping
     * HTTP PUT requests onto specific handler methods.
     * @param id
     * @param employeeDTO
     * @return Ability to update employee data for particular id
     */
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Employee PayrollData Successfuly:", employee);
        return new ResponseEntity(employeeDTO, HttpStatus.OK);
    }

    /**
     * @DeleteMapping
     * Spring @DeleteMapping tutorial shows how to use @DeleteMapping annotation to map HTTP DELETE requests onto specific handler methods.
     * @param :id
     * @return: Ability to delete employee data for particular id
     */
    @DeleteMapping("/employeePayrollService/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}