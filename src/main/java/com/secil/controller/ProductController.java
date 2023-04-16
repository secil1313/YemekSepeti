package com.secil.controller;

import com.secil.dto.request.ProductSaveDto;
import com.secil.entity.Product;
import com.secil.repository.IProductRepository;
import com.secil.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.secil.constants.EndPointList.*;
@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping(SAVE)
    public ResponseEntity<Product> save(ProductSaveDto dto){
      return  ResponseEntity.ok(productService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}
