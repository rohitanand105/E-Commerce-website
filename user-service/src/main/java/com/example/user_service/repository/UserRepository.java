package com.example.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.user_service.entity.Users;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);  // Return Optional for better error handling
}
