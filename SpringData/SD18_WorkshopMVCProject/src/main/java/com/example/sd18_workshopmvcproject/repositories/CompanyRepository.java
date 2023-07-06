package com.example.sd18_workshopmvcproject.repositories;

import com.example.sd18_workshopmvcproject.entities.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
