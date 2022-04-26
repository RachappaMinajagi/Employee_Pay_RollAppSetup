package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollapp.Exeption.EmployeePayrollException;
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

// create a class name as EmployeePayrollController
public class EmployeePayrollController {

    /**
     * 3) @AutoMapping :-
     *          @Autowiring feature of spring framework enables you to inject the object dependency implicitly.
     *          It internally uses setter or constructor injection.
     */

    @Autowired
    IEmployeePayrollService service;

    /**
     *@GetMapping annotation maps HTTP GET requests onto specific handler methods.
     *           It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. GET)
     * @return :- welcome Messages
     */
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String welcome = service.getWelcome();
        return new ResponseEntity<String>(welcome, HttpStatus.OK);
    }

    /**
     *   @PostMapping annotation maps HTTP POST requests onto specific handler methods.
     *   It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST)
     * @apiNote- accepts the employee data in JSON format and stores it in DB
     * @param employeeDTO - employee data
     * @return :- newemployee data
     */
    @PostMapping("/create")
    public ResponseEntity<String> addDataToRepo(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = service.postDataToRepo(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record Added Succesfully", newEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    /**
     * - To get all employees' data by findAll() method
     * @return :- Display all data in DataBase
     */
    @GetMapping("/get")
    public ResponseEntity<String> getAllDataFromRepo() {
        List<Employee> listOfEmployee = service.getAllData();
        ResponseDTO responseDTO = new ResponseDTO("Record Retrieved Successfully", listOfEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     *@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable.
     * It has the following optional elements: name - name of the path variable to bind to.
     * required - tells whether the path variable is required.
     * @param id - employee id
     * @return -employee information with same empId in JSON format
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getDataFromRepoById(@PathVariable Integer id) throws EmployeePayrollException {
        Employee existingEmployee = service.getDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     *@PutMapping Annotation for mapping HTTP PUT requests onto specific handler methods.
     *Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).
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
     * - Ability to delete employee data for particular id
     * @apiNote - accepts the empId and deletes the data of that employee from DB
     * @return -  empId and Acknowledgment message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) throws EmployeePayrollException {
        ResponseDTO responseDTO = new ResponseDTO
                ("Record for particular ID Deleted Successfully", service.deleteDataById(id));
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }
}