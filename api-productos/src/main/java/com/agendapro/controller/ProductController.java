package com.agendapro.controller;

import com.agendapro.domain.Product;
import com.agendapro.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public ResponseEntity<List<Product>> listAll(){
        List<Product> products = productService.listAll();
        return ResponseEntity.ok(products);
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        return ResponseEntity.ok(productService.create(product));
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@Valid @RequestBody Product productDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");

        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<Product> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }
}
