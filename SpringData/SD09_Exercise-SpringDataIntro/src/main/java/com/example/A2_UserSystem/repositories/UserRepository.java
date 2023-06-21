package com.example.A2_UserSystem.repositories;

import com.example.A2_UserSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<List<User>> findAllByLastTimeLoggedInBefore(LocalDate date);

    @Query(value = "FROM User AS a WHERE a.email LIKE CONCAT('%', ?1) ")
    Optional<List<User>> findAllByEmailLike(String email);

    void deleteById(Long id);
}
