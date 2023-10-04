package com.example.sf07_thymeleafandvalidation.model.mapper;

import com.example.sf07_thymeleafandvalidation.model.dto.CompanyDTO;
import com.example.sf07_thymeleafandvalidation.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO companyToCompanyDTO(Company company);

    Company companyDtoToCompany(CompanyDTO companyDTO);
}
