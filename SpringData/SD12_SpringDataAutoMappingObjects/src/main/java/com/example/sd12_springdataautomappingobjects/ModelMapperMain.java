package com.example.sd12_springdataautomappingobjects;

import com.example.sd12_springdataautomappingobjects.entities.Address;
import com.example.sd12_springdataautomappingobjects.entities.Employee;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Component
public class ModelMapperMain implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        ModelMapper modelMapper = new ModelMapper();

        //If the convention for naming is not followed we can configure how the property to be passed
        /*PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<Employee, EmployeeDTO>() {
            @Override
            protected void configure() {
                map().setCity(source.getAddress().getCity());
            }
        };
        modelMapper.addMappings(propertyMap);
        modelMapper.validate();*/

        /*TypeMap<Employee, EmployeeDTO> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeDTO.class);
        typeMap.addMappings(map -> map.map(source -> source.getAddress().getCity(),
                EmployeeDTO::setAddressCity));*/
        //typeMap.validate();

        Address address = Address.builder()
                .country("Bulgaria")
                .city("Sofia")
                .build();

        Employee employee = Employee.builder()
                .firstName("John")
                .salary(BigDecimal.TEN)
                .birthday(LocalDate.now())
                .address(address)
                .build();

        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        //EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);
    }
}
