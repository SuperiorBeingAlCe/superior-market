package com.thesuperior.superiormarket.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesuperior.superiormarket.product.dto.category.CategoryResponse;
import com.thesuperior.superiormarket.product.dto.category.CreateCategoryRequest;
import com.thesuperior.superiormarket.product.dto.category.UpdateCategoryRequest;
import com.thesuperior.superiormarket.product.entity.Category;
import com.thesuperior.superiormarket.product.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	 private final CategoryRepository categoryRepository;

	    
	    
	    @Transactional
	    public CategoryResponse create(CreateCategoryRequest request) {

	        Category category = new Category();
	        category.setName(request.name());

	        Category savedCategory = categoryRepository.save(category);

	        return new CategoryResponse(
	            savedCategory.getId(),
	            savedCategory.getName()
	        );
	        
	    }
	    @Transactional
	    public CategoryResponse update(Long id, UpdateCategoryRequest request) {

	        Category category = categoryRepository.findById(id)
	            .orElseThrow(() ->
	                new IllegalArgumentException("Kategori bulunamadı: " + id)
	            );

	        category.setName(request.name());

	        Category updatedCategory = categoryRepository.save(category);

	        return new CategoryResponse(
	            updatedCategory.getId(),
	            updatedCategory.getName()
	        );
	    }
	    
	    @Transactional(readOnly = true)
	    public CategoryResponse findById(Long id) {

	        Category category = categoryRepository.findById(id)
	            .orElseThrow(() ->
	                new IllegalArgumentException("Kategori bulunamadı: " + id)
	            );

	        return new CategoryResponse(
	            category.getId(),
	            category.getName()
	        );
	    }
	    @Transactional(readOnly = true)
	    public List<CategoryResponse> findAll() {

	        return categoryRepository.findAll()
	            .stream()
	            .map(category -> new CategoryResponse(
	                category.getId(),
	                category.getName()
	            ))
	            .toList();
	    }
}
