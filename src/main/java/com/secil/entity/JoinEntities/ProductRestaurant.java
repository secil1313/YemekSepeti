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
@Table(name = "tblproductrestaurant")
public class ProductRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//idyi otomatik arttırıyordu.
    private Integer product_id;
    private Integer restaurant_id;
    private String product_name;
    private String restaurant_name;


}
