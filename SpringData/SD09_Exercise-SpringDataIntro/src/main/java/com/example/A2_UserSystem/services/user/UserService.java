package com.example.A2_UserSystem.services.user;


import com.example.A2_UserSystem.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    void seedUsers(List<User> users);

    List<User> findAllByLastTimeLoggedInBefore(LocalDate date);

    List<User> findAllByEmailLike(String host);

    void deleteById(Long id);

    boolean isDataSeeded();
}
