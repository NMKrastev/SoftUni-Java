package com.example.sf07_thymeleafandvalidation.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotNull(message = "Birth date must not be null or empty!")
    private LocalDate birthDate;

    @NotBlank(message = "Education must not be null or empty!")
    private String educationLevel;

    @NotBlank(message = "First name must not be null or empty!")
    @Size(min = 2, message = "First name must be at least 2 symbols!")
    private String firstName;

    @NotBlank(message = "Last name must not be null or empty!")
    @Size(min = 2, message = "Last name must be at least 2 symbols!")
    private String lastName;

    @NotBlank(message = "Job title must not be null or empty!")
    private String jobTitle;

    @NotNull(message = "Salary must not be null or empty!")
    @Positive(message = "Salary must be a positive number!")
    private BigDecimal salary;

    private CompanyDTO company;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
