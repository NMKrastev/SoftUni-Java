package com.example.sd12_springdataautomappingobjects;

import com.example.sd12_springdataautomappingobjects.entities.Address;
import com.example.sd12_springdataautomappingobjects.entities.Employee;
import com.example.sd12_springdataautomappingobjects.entities.dtos.AddressDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.CreateEmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeDTO;
import com.example.sd12_springdataautomappingobjects.entities.dtos.ManagerDTO;
import com.example.sd12_springdataautomappingobjects.services.address.AddressService;
import com.example.sd12_springdataautomappingobjects.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {

    private final Scanner scanner;

    private final AddressService addressService;
    private final EmployeeService employeeService;

    @Autowired
    public AppMain(Scanner scanner, AddressService addressService, EmployeeService employeeService) {
        this.scanner = scanner;
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        //createAddress();
        //createEmployee();
        //printAllEmployees();
        //printEmployeeNames();
        printLabTask();

    }

    private void printLabTask() {

        EmployeeDTO employee = this.employeeService.findEmployee(1L);
        System.out.println(employee);

        ManagerDTO manager = this.employeeService.findManager(1L);
        System.out.println(manager);

        List<String> managers = this.employeeService.findAllManagers()
                .stream()
                .map(ManagerDTO::toString)
                .toList();

        managers.forEach(System.out::println);
    }

    private void printEmployeeNames() {
        System.out.println(this.employeeService.findNamesById(1L));
    }

    private void printAllEmployees() {
        this.employeeService.findAll()
                .forEach(System.out::println);
    }

    private void createEmployee() {

        System.out.print("Enter first name: ");
        final String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        final String lastName = scanner.nextLine();

        System.out.print("Enter salary: ");
        final BigDecimal salary = new BigDecimal(scanner.nextLine());

        System.out.print("Enter birthdate: ");
        final LocalDate birthday = LocalDate.parse(scanner.nextLine());

        //Long addressId  = Long.parseLong(scanner.nextLine());
        System.out.print("Enter country: ");
        final String country = scanner.nextLine();
        System.out.print("Enter city: ");
        final String city = scanner.nextLine();

        final AddressDTO address = new AddressDTO(country, city);

        final CreateEmployeeDTO employeeDTO =
                new CreateEmployeeDTO(firstName, null, salary, birthday, address);

        final Employee employee = this.employeeService.create(employeeDTO);

        System.out.println(employee);
    }

    private void createAddress() {
        System.out.print("Enter country: ");
        final String country = scanner.nextLine();
        System.out.print("Enter city: ");
        final String city = scanner.nextLine();

        final AddressDTO data = new AddressDTO(country, city);

        final Address address = this.addressService.create(data);

        System.out.println(address);
    }
}
