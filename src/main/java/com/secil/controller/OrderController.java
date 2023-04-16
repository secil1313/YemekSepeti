package com.secil.controller;

import com.secil.dto.request.OrderRequestDto;
import com.secil.dto.request.ProductSaveDto;
import com.secil.entity.JoinEntities.CustomerOrderPersonelRestaurant;
import com.secil.entity.JoinEntities.OrderProduct;
import com.secil.entity.Order;
import com.secil.entity.Product;
import com.secil.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.secil.constants.EndPointList.*;
@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping(SAVE)
    public ResponseEntity<Order> save(@RequestBody @Valid OrderRequestDto dto){

        return  ResponseEntity.ok(orderService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll(){

        return ResponseEntity.ok(orderService.findAll());
    }
    @GetMapping("/find-all-orders")
    public ResponseEntity<List<OrderProduct>> findOrders(){
        return ResponseEntity.ok(orderService.findOrders());
    }
}
