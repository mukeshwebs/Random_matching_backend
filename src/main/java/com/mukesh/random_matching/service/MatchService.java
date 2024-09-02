package com.mukesh.random_matching.service;

import com.mukesh.random_matching.entity.User;
import com.mukesh.random_matching.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private UserRepository userRepository;

    public User addUserToPool(String name) {
        User user = new User(name, false);
        return userRepository.save(user);
    }

    public Optional<User> findMatch(Long userId) {
        return userRepository.findById(userId);
    }
}
