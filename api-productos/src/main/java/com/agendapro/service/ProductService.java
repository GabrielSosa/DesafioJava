package com.agendapro.service;

import com.agendapro.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAll();
    Product create(Product product);
    Product update(Product product);
    Product updateProduct(Long id, Product product);
    void delete(Long id);
    Optional<Product> getProductById(Long id);
    List<Product> searchProductsByName(String name);
}
