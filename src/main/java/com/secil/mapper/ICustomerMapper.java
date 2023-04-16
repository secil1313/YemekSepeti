package com.secil.mapper;

import com.secil.dto.request.RegisterRequestDto;
import com.secil.dto.response.RegisterResponseDto;
import com.secil.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ICustomerMapper {
    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);
    Customer toCustomer(final RegisterRequestDto dto);
    RegisterResponseDto toDto(final Customer customer);
}
