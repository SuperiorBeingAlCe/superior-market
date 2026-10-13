package com.thesuperior.superiormarket.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesuperior.superiormarket.product.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
