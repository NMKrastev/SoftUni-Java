package com.example.A2_UserSystem.services.user;

import com.example.A2_UserSystem.entities.User;
import com.example.A2_UserSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAllByEmailLike(String host) {

        return this.userRepository.findAllByEmailLike(host).orElseThrow(NoSuchElementException::new);

    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public boolean isDataSeeded() {
        return this.userRepository.count() > 0;
    }

    @Override
    public List<User> findAllByLastTimeLoggedInBefore(LocalDate date) {
        return this.userRepository.findAllByLastTimeLoggedInBefore(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void seedUsers(List<User> users) {
        this.userRepository.saveAll(users);
    }
}
