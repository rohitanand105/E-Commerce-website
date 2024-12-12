package com.example.user_service.service;

import com.example.user_service.dto.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_service.entity.Users;
import com.example.user_service.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users users) {
        Optional<Users> existingUser = userRepository.findByUsername(users.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(users);
    }

    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Users saveUser(Users users){
        return userRepository.save(users);
    }

    public String login(UserLoginRequest loginRequest) {
        Optional<Users> users = findByUsername(loginRequest.getUsername());
        if (users.isPresent() && users.get().getPassword().equals(loginRequest.getPassword())) {
            // Here you should generate a JWT token or some form of session management
            return "dummy-jwt-token"; // Replace with actual JWT logic
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
