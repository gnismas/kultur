package com.example.kultur.userservice;

import com.example.kultur.model.User;
import com.example.kultur.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
// gør at Spring "ser" denne klasse
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User save(User object) {
        return userRepository.save(object);
    }

}