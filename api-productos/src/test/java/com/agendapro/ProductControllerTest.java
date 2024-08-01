package com.agendapro;

import com.agendapro.controller.ProductController;
import com.agendapro.domain.Product;
import com.agendapro.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setCategory("Test Category");
        product.setPrice(100.0);

        when(productService.create(any(Product.class))).thenReturn(product);

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        ResponseEntity<Product> response = (ResponseEntity<Product>) productController.create(product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Updated Product");
        product.setCategory("Updated Category");
        product.setPrice(200.0);

        when(productService.updateProduct(anyLong(), any(Product.class))).thenReturn(product);

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        ResponseEntity<Product> response = productController.updateProduct(1L, product);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteProduct() {
        ResponseEntity<Void> response = productController.deleteProduct(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).delete(1L);
    }



    @Test
    void getAllProducts() {
        productController.listAll();
        verify(productService, times(1)).listAll();
    }

    @Test
    void getProductById() {
        productController.getProductById(1L);
        verify(productService, times(1)).getProductById(1L);
    }

}
