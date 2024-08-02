package com.agendapro.service.impl;

import com.agendapro.domain.Product;
import com.agendapro.repository.ProductRepository;
import com.agendapro.service.ProductService;
import com.agendapro.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    private StatisticsService statisticsService;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        if(product.getId() != null){
            throw new RuntimeException("To create a record, you cannot have an ID");
        }
        statisticsService.updateStatistics(product.getCategory());
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if(product.getId() == null){
            throw new RuntimeException("To update a record, you must have an ID");
        }
        statisticsService.updateStatistics(product.getCategory());
        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(productDetails.getName());
            product.setCategory(productDetails.getCategory());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
