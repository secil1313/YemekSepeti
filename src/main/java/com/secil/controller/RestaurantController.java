package com.secil.controller;

import com.secil.dto.request.ProductSaveDto;
import com.secil.dto.request.RestaurantServiceDto;
import com.secil.entity.JoinEntities.ProductRestaurant;
import com.secil.entity.JoinEntities.RestaurantOrderProduct;
import com.secil.entity.Product;
import com.secil.entity.Restaurant;
import com.secil.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.secil.constants.EndPointList.*;
@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(RestaurantServiceDto dto){
        return  ResponseEntity.ok(restaurantService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
    @GetMapping("/from-restaurant-find-orders")
    public ResponseEntity<List<RestaurantOrderProduct>> fromRestaurantsFindOrders(Integer restaurantId){
        return ResponseEntity.ok(restaurantService.fromRestaurantsFindOrders(restaurantId));
    }
    @GetMapping("/from-restaurant-find-product")
    public ResponseEntity<List<ProductRestaurant>> fromRestaurantFindProduct(Integer restaurantId){
        return ResponseEntity.ok(restaurantService.fromRestaurantFindProduct(restaurantId));
    }
}
