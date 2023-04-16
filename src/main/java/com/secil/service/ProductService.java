package com.secil.service;

import com.secil.dto.request.ProductSaveDto;
import com.secil.entity.Product;
import com.secil.mapper.IProductMapper;
import com.secil.repository.IProductRepository;
import com.secil.utility.ServiceManager;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService extends ServiceManager<Product,Integer> {
    private final IProductRepository productRepository;
    public ProductService(IProductRepository productRepository){
        super(productRepository);
        this.productRepository=productRepository;
    }
    public Product save(ProductSaveDto dto){
      return productRepository.save(IProductMapper.INSTANCE.toProduct(dto));

    }
    public List<Product> findAll(){
        List<Product> product= productRepository.findAll();
        return product;
    }

}
