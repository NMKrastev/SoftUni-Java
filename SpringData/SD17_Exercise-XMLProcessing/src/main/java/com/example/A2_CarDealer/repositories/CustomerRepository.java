package com.example.A2_CarDealer.repositories;

import com.example.A2_CarDealer.entities.Customer;
import com.example.A2_CarDealer.entities.dto.customer.CustomerWithTotalSalesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<List<Customer>> findAllByOrderByBirthDateAscIsYoungDriverAsc();

    @Query("""
            SELECT NEW com.example.A2_CarDealer.entities.dto.customer.CustomerWithTotalSalesDTO(cu.name, COUNT(DISTINCT s.car.id), SUM(p.price))
            FROM Sale AS s
                     JOIN Customer cu ON cu.id = s.customer.id
                     JOIN Car ca ON ca.id = s.car.id
                     JOIN ca.parts AS p
            WHERE cu.id IN (SELECT DISTINCT s2.customer.id FROM Sale AS s2)
            GROUP BY cu.id
            ORDER BY SUM(p.price) DESC, COUNT(DISTINCT s.id) DESC
            """)
    List<CustomerWithTotalSalesDTO> findAllCustomersByTotalSalesCountAndMoneySpent();
}
