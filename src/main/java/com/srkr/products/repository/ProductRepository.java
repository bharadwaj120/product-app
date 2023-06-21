package com.srkr.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srkr.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
