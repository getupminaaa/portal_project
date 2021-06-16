package com.example.kcalculator.repository;

import com.example.kcalculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByToken(String token);
}