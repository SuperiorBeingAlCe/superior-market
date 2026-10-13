package com.thesuperior.superiormarket.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesuperior.superiormarket.product.entity.Category;

public interface CategoryRepository
extends JpaRepository<Category, Long>{
}
