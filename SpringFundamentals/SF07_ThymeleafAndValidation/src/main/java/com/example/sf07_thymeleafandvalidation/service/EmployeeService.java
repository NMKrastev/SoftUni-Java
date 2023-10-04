package com.example.sf07_thymeleafandvalidation.service;

import com.example.sf07_thymeleafandvalidation.model.dto.EmployeeDTO;
import com.example.sf07_thymeleafandvalidation.model.entity.Company;
import com.example.sf07_thymeleafandvalidation.model.entity.Employee;
import com.example.sf07_thymeleafandvalidation.model.mapper.EmployeeMapper;
import com.example.sf07_thymeleafandvalidation.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyService companyService,
                           EmployeeMapper employeeMapper) {

        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
        this.employeeMapper = employeeMapper;
    }


    public List<EmployeeDTO> getAllEmployees() {

        return this.employeeRepository
                .findAll()
                .stream()
                .map(this.employeeMapper::employeeToEmployeeDto)
                .toList();
    }

    public boolean addEmployee(EmployeeDTO employeeDTO) {

        final Employee employee = this.employeeMapper.employeeDtoToEmployee(employeeDTO);

        final Company company = this.companyService.findByName(employee.getCompany().getName());

        employee.setCompany(company);

        this.employeeRepository.save(employee);

        return true;
    }

    public EmployeeDTO findEmployee(Long id) {

        return this.employeeRepository
                .findById(id)
                .map(this.employeeMapper::employeeToEmployeeDto)
                .get();
    }

    public boolean deleteEmployee(Long id) {

        final Employee employee = this.employeeRepository.findById(id).get();

        this.employeeRepository.delete(employee);

        return this.employeeRepository
                .findById(id)
                .isEmpty();
    }
}
