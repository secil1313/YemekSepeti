package com.secil.mapper;

import com.secil.dto.request.ProductSaveDto;
import com.secil.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE= Mappers.getMapper(IProductMapper.class);
    Product toProduct(final ProductSaveDto dto);
}
