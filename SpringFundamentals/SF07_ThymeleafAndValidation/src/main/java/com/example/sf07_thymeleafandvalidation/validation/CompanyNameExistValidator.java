package com.example.sf07_thymeleafandvalidation.validation;

import com.example.sf07_thymeleafandvalidation.repository.CompanyRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompanyNameExistValidator implements ConstraintValidator<CompanyNameExist, String> {

    private final CompanyRepository companyRepository;

    public CompanyNameExistValidator(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        return this.companyRepository
                .findByName(name)
                .isEmpty();
    }
}
