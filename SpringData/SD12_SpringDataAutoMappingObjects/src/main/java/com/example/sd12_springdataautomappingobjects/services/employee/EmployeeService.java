package com.example.sd12_springdataautomappingobjects.services.employee;

import com.example.sd12_springdataautomappingobjects.entities.Employee;
import com.example.sd12_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeNamesDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.ManagerDTO;

import java.util.List;

public interface EmployeeService {

    Employee create(CreateEmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();

    EmployeeNamesDTO findNamesById(long id);

    EmployeeDTO findEmployee(Long id);

    ManagerDTO findManager(Long id);

    List<ManagerDTO> findAllManagers();

}
