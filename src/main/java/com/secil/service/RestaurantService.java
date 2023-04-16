package com.secil.service;

import com.secil.dto.request.RestaurantServiceDto;
import com.secil.entity.JoinEntities.ProductRestaurant;
import com.secil.entity.JoinEntities.RestaurantOrderProduct;
import com.secil.entity.Restaurant;
import com.secil.exception.ErrorType;
import com.secil.exception.YemekSepetiException;
import com.secil.mapper.IRestaurantMapper;
import com.secil.repository.IRestaurantRepository;
import com.secil.repository.ProductRestaurantRepository;
import com.secil.repository.RestaurantOrderProductRepository;
import com.secil.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RestaurantService extends ServiceManager<Restaurant,Integer> {
    private final IRestaurantRepository restaurantRepository;
    private final RestaurantOrderProductRepository restaurantOrderProductRepository;
    private final ProductRestaurantRepository productRestaurantRepository;
    public RestaurantService(IRestaurantRepository restaurantRepository,RestaurantOrderProductRepository restaurantOrderProductRepository,ProductRestaurantRepository productRestaurantRepository){
        super(restaurantRepository);
        this.restaurantRepository=restaurantRepository;
        this.restaurantOrderProductRepository=restaurantOrderProductRepository;
        this.productRestaurantRepository=productRestaurantRepository;
    }
    public Restaurant save(RestaurantServiceDto dto){
        List<Restaurant> restaurantList=restaurantRepository.findAll();
        restaurantList.forEach(item->{
            if(item.getAddress().equals(dto.getAddress()))
                throw new YemekSepetiException(ErrorType.RESTAURANT_ALREADY_FOUND);
        });
        return restaurantRepository.save(IRestaurantMapper.INSTANCE.toRestaurant(dto));
    }
    public List<Restaurant> findAll(){
        List<Restaurant> restaurants= restaurantRepository.findAll();
        return restaurants;
    }
    public List<RestaurantOrderProduct> fromRestaurantsFindOrders(Integer restaurantId){
        return restaurantOrderProductRepository.fromRestaurantsFindOrders(restaurantId);
    }
    public List<ProductRestaurant> fromRestaurantFindProduct(Integer restaurantId){
        return productRestaurantRepository.fromRestaurantFindProduct(restaurantId);
    }

}
