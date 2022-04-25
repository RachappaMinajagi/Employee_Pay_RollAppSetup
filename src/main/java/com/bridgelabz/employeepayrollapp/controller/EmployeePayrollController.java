package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * import all the Class for employee PayRoll App
 */


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        String message = service.getMessage(name);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage(@Valid @RequestBody EmployeeDTO employeeDTO) {
        String message = service.postMessage(employeeDTO);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PutMapping("/putMessage/{name}")
    public ResponseEntity<String> putMessage(@PathVariable String name) {
        String message = service.putMessage(name);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    //Ability to display welcome message
    @GetMapping("")
    public ResponseEntity<String> getWelcome() {
        String welcome = service.getWelcome();
        return new ResponseEntity<String>(welcome, HttpStatus.OK);
    }

    //Ability to save employee data to repo
    @PostMapping("/create")
    public ResponseEntity<String> addDataToRepo(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = service.postDataToRepo(employeeDTO);
        ResponseDTO dto = new ResponseDTO("Record Added Succesfully", newEmployee);
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    //Ability to get all employees' data by findAll() method
    @GetMapping("/get")
    public ResponseEntity<String> getAllDataFromRepo() {
        List<Employee> listOfEmployee = service.getAllData();
        ResponseDTO dto = new ResponseDTO("Record Retrieved Successfully", listOfEmployee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to get employee data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getDataFromRepoById(@PathVariable Integer id) {
        Optional<Employee> existingEmployee = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to update employee data for particular id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = service.updateDataById(id, employeeDTO);
        ResponseDTO dto = new ResponseDTO("Record for particular ID Updated Successfully", updatedEmployee);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record for particular ID Deleted Successfully", service.deleteDataById(id));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }
}