package com.bridgelabz.employeepayrollapp.DTO;
/**
 * import java.time.LocalDate;
 */

import java.time.LocalDate;

/**
 * create class EmployeeDTO
 */

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String profilePic;
    private String department;
    private Long salary;
    private LocalDate date;
    private String notes;

    public EmployeeDTO() {
        /**
         * The super() in Java is a reference variable that is used to refer parent class constructors.
         * super can be used to call parent class' variables and methods.
         */
        super();
    }

    /**
     * Create Constructor EmployeeDTO and passing the Parameter
     * @param : firstName
     * @param :lastName
     * @param :profilePic
     * @param :department
     * @param :salary
     * @param :date
     * @param :notes
     */

    public EmployeeDTO(String firstName, String lastName, String profilePic, String department, Long salary,
                       LocalDate date, String notes) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.notes = notes;
    }

    /**
     * create method getFirstName()
     * @return : firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * create method getlaststName()
     * @return : getlaststname
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * create method getProfilePic()
     * @return : profilePic
     */

    public String getProfilePic() {
        return profilePic;
    }
    /**
     * create method getDepartment()
     * @return : department
     */

    public String getDepartment() {
        return department;
    }

    /**
     * create method getSalary()
     * @return : department
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * create method getDate()
     * @return : date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * create method Notes()
     * @return : note
     */
    public String getNotes() {
        return notes;
    }

}