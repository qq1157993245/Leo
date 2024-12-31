package com.example.Food.Order.repository;

import com.example.Food.Order.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    public User findByEmail(String username);
}
