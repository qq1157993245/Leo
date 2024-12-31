package com.example.Food.Order.controller;

import com.example.Food.Order.model.Food;
import com.example.Food.Order.model.Restaurant;
import com.example.Food.Order.model.User;
import com.example.Food.Order.request.CreateRestaurantRequest;
import com.example.Food.Order.service.FoodService;
import com.example.Food.Order.service.RestaurantService;
import com.example.Food.Order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFoods(@RequestParam String name,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Food> foods = foodService.searchFoods(name);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFoods(@RequestParam boolean vegetarian,
                                                         @RequestParam boolean seasonal,
                                                         @RequestParam boolean nonveg,
                                                         @RequestParam(required = false) String food_category,
                                                         @PathVariable Long restaurantId,
                                                         @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        List<Food> foods = foodService.getRestaurantsFood(restaurantId, vegetarian, seasonal, nonveg, food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
