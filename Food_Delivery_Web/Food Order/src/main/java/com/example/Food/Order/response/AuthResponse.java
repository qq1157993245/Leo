package com.example.Food.Order.response;

import com.example.Food.Order.model.USER_ROLE;
import com.example.Food.Order.model.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private User user;
    private USER_ROLE role;
}
