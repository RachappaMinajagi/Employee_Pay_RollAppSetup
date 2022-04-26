package com.bridgelabz.employeepayrollapp.DTO;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class EmployeeDTO {
    /**
     * Regex validation pattern for firstName
     * [A-Z]{1} - Starting capital letter
     * [a-zA-Z]{2,} - other letter is 2 or more times
     */
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee firstName is Invalid")
    private String firstName;
    /**
     * Regex validation pattern for lastname
     * [A-Z]{1} - Starting capital letter
     * [a-zA-Z]{2,} - other letter is 2 or more times
     */
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message = "ProfilePic cannot be null")
    private String profilePic;

    @NotEmpty(message = "Department name cannot be null")
    private String department;

    @Min(value = 500, message = "Salary should be more than 500")
    private Long salary;

    @PastOrPresent(message = "Date should be past or today date")
    private LocalDate date;
    private String notes;

    public EmployeeDTO() {
        super();
    }
}