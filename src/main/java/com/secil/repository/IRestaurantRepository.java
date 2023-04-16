package com.secil.repository;

import com.secil.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
