package com.example.sd14_jsonprocessing.repositories;

import com.example.sd14_jsonprocessing.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
