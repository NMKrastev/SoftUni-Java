package com.example.sf07_thymeleafandvalidation.model.dto;

import com.example.sf07_thymeleafandvalidation.validation.CompanyNameExist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    @NotNull(message = "Budget cannot be null!")
    @Positive(message = "Budget must be positive number!")
    private BigDecimal budget;

    @NotNull(message = "Description cannot be null!")
    @Size(min = 10, message = "Description must be at least 10 symbols!")
    private String description;

    @NotNull(message = "Name cannot be null!")
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 symbols!")
    @CompanyNameExist(message = "Company name already exists!")
    private String name;

    @NotNull(message = "Town cannot be null!")
    @Size(min = 2, max = 10, message = "Town must be between 2 and 10 symbols!")
    private String town;
}
