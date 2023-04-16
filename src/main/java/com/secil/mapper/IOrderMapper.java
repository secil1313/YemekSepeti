package com.secil.mapper;

import com.secil.dto.request.OrderRequestDto;
import com.secil.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE=Mappers.getMapper(IOrderMapper.class);
    Order toOrder(final OrderRequestDto dto);
}
