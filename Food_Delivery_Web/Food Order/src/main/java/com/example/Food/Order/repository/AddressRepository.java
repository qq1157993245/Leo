package com.example.Food.Order.repository;

import com.example.Food.Order.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
