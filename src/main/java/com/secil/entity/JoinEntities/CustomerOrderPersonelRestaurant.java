package com.secil.entity.JoinEntities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customerorderpersonelrestaurant")
public class CustomerOrderPersonelRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private Integer order_id;
    private String customer_name;
    private Integer customer_id;
    private String product_name;
    private String restaurant_name;

}
