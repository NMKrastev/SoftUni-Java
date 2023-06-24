package com.example.sd12_springdataautomappingobjects.entities.dtos;

import com.example.sd12_springdataautomappingobjects.entities.Employee;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ManagerDTO {

    private List<Employee> inChargeOfEmployee;

    public ManagerDTO() {
        this.inChargeOfEmployee = new ArrayList<>();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        if (!inChargeOfEmployee.isEmpty()) {

            sb.append(super.toString())
                    .append(String.format(" | Employees: %d", inChargeOfEmployee.size()))
                    .append(System.lineSeparator());

            this.inChargeOfEmployee
                    .forEach(employeeDTO -> sb.append(String.format("    - %s", employeeDTO.toString()))
                    .append(System.lineSeparator()));
        }

        return sb.toString().trim();
    }
}
