package com.example.Food.Order.repository;

import com.example.Food.Order.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
