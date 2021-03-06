package com.educative.ecommerce.service;

import com.educative.ecommerce.model.Product;
import com.educative.ecommerce.dto.product.ProductDto;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public static Product getProductFromDto(ProductDto productDto, Category category){
        Product product = new Product();
        product.setCategory(category);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImgUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());

        return product;

    }
}
