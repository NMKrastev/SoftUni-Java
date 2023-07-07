package com.example.sd18_workshopmvcproject.repositories;

import com.example.sd18_workshopmvcproject.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByAgeGreaterThan(int age);
}
