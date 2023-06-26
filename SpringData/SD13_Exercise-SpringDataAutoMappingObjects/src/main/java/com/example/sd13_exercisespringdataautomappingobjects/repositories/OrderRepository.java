package com.example.sd13_exercisespringdataautomappingobjects.repositories;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
