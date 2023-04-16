package com.secil.repository;

import com.secil.entity.JoinEntities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {
    @Query(value = "select o.order_id,p.product_id,p.product_name from tblproduct as p\n" +
            "inner join order_productid as op on op.productid=p.product_id\n" +
            "inner join tblorder as o on o.order_id=op.order_order_id",nativeQuery = true)
    List<OrderProduct> findOrders();
}
