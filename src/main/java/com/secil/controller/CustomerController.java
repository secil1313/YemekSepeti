package com.secil.controller;

import com.secil.dto.request.ActivateRequestDto;
import com.secil.dto.request.LoginRequestDto;
import com.secil.dto.request.RegisterRequestDto;
import com.secil.dto.request.UpdateEmailOrPasswordRequestDto;
import com.secil.dto.response.RegisterResponseDto;
import com.secil.entity.Customer;
import com.secil.entity.JoinEntities.CustomerOrderPersonelRestaurant;
import com.secil.repository.CustomerOrderPersonelRestaurantRepository;
import com.secil.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static com.secil.constants.EndPointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
@PostMapping(REGISTER)
public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto) {
return ResponseEntity.ok(customerService.register(dto));
}
    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){

        return ResponseEntity.ok(customerService.findAll());
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody UpdateEmailOrPasswordRequestDto dto){
        return ResponseEntity.ok(customerService.update(dto));
    }
    @GetMapping("/find-by-name")
    public ResponseEntity<List<String>> findByName(){
        return ResponseEntity.ok(customerService.findByName());
    }
    @GetMapping("/find-orders")
    public ResponseEntity<List<CustomerOrderPersonelRestaurant>> findOrders(Integer customerId){
        return ResponseEntity.ok(customerService.findOrders(customerId));
    }
}
