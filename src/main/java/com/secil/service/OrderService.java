package com.secil.service;

import com.secil.dto.request.OrderRequestDto;
import com.secil.entity.Customer;
import com.secil.entity.EStatus;
import com.secil.entity.JoinEntities.OrderProduct;
import com.secil.entity.Order;
import com.secil.entity.Product;
import com.secil.exception.ErrorType;
import com.secil.exception.YemekSepetiException;
import com.secil.mapper.IOrderMapper;
import com.secil.repository.IOrderRepository;
import com.secil.repository.OrderProductRepository;
import com.secil.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService extends ServiceManager<Order,Integer> {
    private final IOrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderProductRepository orderProductRepository;
    public OrderService (IOrderRepository orderRepository,CustomerService customerService,ProductService productService,OrderProductRepository orderProductRepository){
        super(orderRepository);
        this.orderRepository=orderRepository;
        this.customerService=customerService;
        this.productService=productService;
        this.orderProductRepository=orderProductRepository;
    }
    public Order save(OrderRequestDto dto){
        Optional<Customer> customer=customerService.findById(dto.getCustomer_id());
        Order order= IOrderMapper.INSTANCE.toOrder(dto);
        if(customer.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        else if(customer.get().getStatus().equals(EStatus.PENDING)){
            throw new YemekSepetiException(ErrorType.USER_NOTACTIVE);
        }
        Set<Integer> restaurantId=new HashSet<>();//verileri tekrarlamaz.
        order.getProductid().forEach(id->{
            Product product=productService.findById(id).get();
            restaurantId.add(product.getProduct_id());
        });
        return save(order);
        }
       public List<Order> findAll(){
        List<Order> orders=orderRepository.findAll();
        return orders;
       }
    public List<OrderProduct> findOrders(){
        return orderProductRepository.findOrders();
    }

    }
