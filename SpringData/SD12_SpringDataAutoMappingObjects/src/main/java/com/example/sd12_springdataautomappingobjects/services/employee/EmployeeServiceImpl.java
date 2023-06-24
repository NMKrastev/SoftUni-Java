package com.example.sd12_springdataautomappingobjects.services.employee;

import com.example.sd12_springdataautomappingobjects.entities.Address;
import com.example.sd12_springdataautomappingobjects.entities.Employee;
import com.example.sd12_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeNamesDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.ManagerDTO;
import com.example.sd12_springdataautomappingobjects.repositories.AddressRepository;
import com.example.sd12_springdataautomappingobjects.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employeeDTO) {

        Employee employee = mapper.map(employeeDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(
                employeeDTO.getAddress().getCountry(),
                employeeDTO.getAddress().getCity());

        address.ifPresent(employee::setAddress);

        return this.employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        return this.employeeRepository.findAll()
                .stream()
                .map(e -> mapper.map(e, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeNamesDTO findNamesById(long id) {
        return this.employeeRepository.findNamesById(id);
    }

    @Override
    public EmployeeDTO findEmployee(Long id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        if (employee.isPresent()) {
            return mapper.map(employee, EmployeeDTO.class);
        }

        throw new NoSuchElementException(String.format("There is no employee with id: %d", id));
    }

    @Override
    public ManagerDTO findManager(Long id) {

        Optional<Employee> employee = this.employeeRepository.findById(id);

        if (employee.isPresent()) {
            return mapper.map(employee, ManagerDTO.class);
        }

        throw new NoSuchElementException(String.format("There is no manager with id: %d", id));
    }

    @Override
    public List<ManagerDTO> findAllManagers() {
        return mapper.map(this.employeeRepository.findAll(),
                new TypeToken<ManagerDTO>() {}.getType());
    }
}
