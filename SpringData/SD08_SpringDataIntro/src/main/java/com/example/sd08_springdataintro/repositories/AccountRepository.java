package com.example.sd08_springdataintro.repositories;

import com.example.sd08_springdataintro.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
