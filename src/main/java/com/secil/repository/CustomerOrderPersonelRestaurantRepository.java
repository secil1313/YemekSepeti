package com.secil.repository;

import com.secil.entity.JoinEntities.CustomerOrderPersonelRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderPersonelRestaurantRepository extends JpaRepository<CustomerOrderPersonelRestaurant,Integer> {
    @Query(value = "select p.product_id,cu.customer_id,cu.customer_name ,o.order_id ,p.product_name,r.restaurant_name from tblorder as o\n" +
            "inner join tblcustomer as cu on cu.customer_id=o.customerid\n" +
            "inner join order_productid as op on op.order_order_id=o.order_id\n" +
            "inner join tblproduct as p on p.product_id=op.productid\n" +
            "inner join restaurant_product_id as rp on rp.product_id=p.product_id\n" +
            "inner join tblrestaurant as r on r.restaurant_id=rp.restaurant_restaurant_id where cu.customer_id=?1",nativeQuery = true)
    List<CustomerOrderPersonelRestaurant> findOrders(Integer customerId);

}
