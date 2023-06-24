package com.example.sd12_springdataautomappingobjects.repositories;

import com.example.sd12_springdataautomappingobjects.entities.Employee;
import com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeNamesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.sd12_springdataautomappingobjects.entities.dtos.EmployeeNamesDTO(e.firstName, e.lastName) " +
            "FROM Employee AS e WHERE e.id = ?1")
    EmployeeNamesDTO findNamesById(long id);
}
