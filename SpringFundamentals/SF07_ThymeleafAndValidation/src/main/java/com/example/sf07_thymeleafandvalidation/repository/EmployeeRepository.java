package com.example.sf07_thymeleafandvalidation.repository;

import com.example.sf07_thymeleafandvalidation.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
