package com.example.Food.Order.service;

import com.example.Food.Order.model.Category;
import com.example.Food.Order.model.Food;
import com.example.Food.Order.model.Restaurant;
import com.example.Food.Order.request.CreateFoodRequest;

import java.util.List;

public interface FoodService{
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    public void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegetarian,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory);
    public List<Food> searchFoods(String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food updateAvailabilityStatus(Long foodId) throws Exception;
}
