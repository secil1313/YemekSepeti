package com.secil.repository;

import com.secil.entity.JoinEntities.ProductRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRestaurantRepository extends JpaRepository<ProductRestaurant,Integer> {
    @Query(value="select p.product_id,r.restaurant_id,r.restaurant_name,p.product_name from tblproduct as p\n" +
            "inner join restaurant_product_id as rp on rp.product_id=p.product_id\n" +
            "inner join tblrestaurant as r on r.restaurant_id=rp.restaurant_restaurant_id where r.restaurant_id=?1",nativeQuery = true)
    List<ProductRestaurant> fromRestaurantFindProduct(Integer restaurantId);
}
