package com.thesuperior.superiormarket.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesuperior.superiormarket.product.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

	public Optional<Product>findByBarcode(String barcode);
	public Optional<Product>findBySku(String sku);
}
