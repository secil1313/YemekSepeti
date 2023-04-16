package com.secil.repository;

import com.secil.entity.JoinEntities.CustomerOrderPersonelRestaurant;
import com.secil.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Integer> {

}
