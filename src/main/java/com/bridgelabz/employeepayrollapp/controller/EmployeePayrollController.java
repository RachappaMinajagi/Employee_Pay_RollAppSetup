package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.Exeption.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
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

/**
 *  @RestController annotation in order to simplify the creation of RESTful web services.
 */
@RestController
@RequestMapping("/employeepayrollservice")

public class EmployeePayrollController {

    /**
     * @Autowired annotation is used for dependency injection.In spring boot application,
     * all loaded beans are eligible for auto wiring to another bean.
     */
    @Autowired
    EmployeePayrollService service;

    /**
     *@GetMapping annotation maps HTTP GET requests onto specific handler methods
     * @return :Ability to display welcome message
     */
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String welcome = service.getWelcome();
        return new ResponseEntity<String>(welcome, HttpStatus.OK);
    }

    /**
     *@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
     * @return :Ability to save employee details to repository
     */
    @PostMapping("/create")
    public ResponseEntity<String> addDataToRepo(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = service.postDataToRepo(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record Added Succesfully", newEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Ability to get all employees data by findAll() method
     */

    @GetMapping("/get")
    public ResponseEntity<String> getAllDataFromRepo() {
        List<Employee> listOfEmployee = service.getAllData();
        ResponseDTO responseDTO = new ResponseDTO("Record Retrieved Successfully", listOfEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Ability to get employee data by id
     * @param : id
     * @return : ResponseEntity
     * @throws EmployeePayrollException
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getDataFromRepoById(@PathVariable Integer id) throws EmployeePayrollException {
        Employee existingEmployee = service.getDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Ability to update employee data for particular id
     * @param id
     * @param employeeDTO
     * @return :ResponseEntity
     * @throws EmployeePayrollException
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id,
                                                   @Valid @RequestBody EmployeeDTO employeeDTO)
            throws EmployeePayrollException {
        Employee updatedEmployee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record for particular ID Updated Successfully", updatedEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    /**
     * @DeleteMapping
     * Spring @DeleteMapping tutorial shows how to use @DeleteMapping annotation to map HTTP DELETE requests onto specific handler methods.
     * @param :id
     * @return: Ability to delete employee data for particular id
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) throws EmployeePayrollException {
        ResponseDTO responseDTO = new ResponseDTO
                ("Record for particular ID Deleted Successfully", service.deleteDataById(id));
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    //Ability to get employee data by department name
    @GetMapping("/getbydepartment/{department}")
    public ResponseEntity<ResponseDTO> getRecordFromRepoByDepartment(@PathVariable String department) throws EmployeePayrollException {
        List<Employee> newEmployee = service.getDataByDepartment(department);
        ResponseDTO dto = new ResponseDTO("Record for given Department Retrieved Successfully", newEmployee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}