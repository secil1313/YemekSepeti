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
@Table(name = "tblrestaurantorderproduct")
public class RestaurantOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.
    private Integer restaurant_id;
    private String restaurant_name;
    private Integer order_id;
    private String product_name;
}
