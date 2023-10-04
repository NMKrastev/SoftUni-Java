package com.example.sf07_thymeleafandvalidation.model.mapper;

import com.example.sf07_thymeleafandvalidation.model.dto.EmployeeDTO;
import com.example.sf07_thymeleafandvalidation.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO employeeToEmployeeDto(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
}
