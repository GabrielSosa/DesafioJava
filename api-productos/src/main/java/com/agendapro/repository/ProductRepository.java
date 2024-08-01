package com.agendapro.repository;

import com.agendapro.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT u FROM Product u WHERE u.name LIKE %:name%")
    List<Product> findByNameContaining(String name);
}
