package com.nabin.cms.service;

import com.nabin.cms.model.User;
import com.nabin.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nabin
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        // You might want to perform additional validation or business logic here
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        // You might want to perform additional validation or business logic here
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        // You might want to check if the user exists before deleting
        userRepository.deleteById(id);
    }

    // Other methods as needed
}