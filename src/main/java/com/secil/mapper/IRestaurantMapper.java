package com.secil.mapper;

import com.secil.dto.request.RestaurantServiceDto;
import com.secil.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE= Mappers.getMapper(IRestaurantMapper.class);
    Restaurant toRestaurant(RestaurantServiceDto dto);
}
