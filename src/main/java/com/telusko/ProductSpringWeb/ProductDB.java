package com.telusko.ProductSpringWeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
