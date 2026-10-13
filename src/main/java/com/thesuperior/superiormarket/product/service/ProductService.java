package com.thesuperior.superiormarket.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesuperior.superiormarket.product.dto.product.CreateProductRequest;
import com.thesuperior.superiormarket.product.dto.product.ProductResponse;
import com.thesuperior.superiormarket.product.dto.product.UpdateProductRequest;
import com.thesuperior.superiormarket.product.entity.Category;
import com.thesuperior.superiormarket.product.entity.Product;
import com.thesuperior.superiormarket.product.repository.CategoryRepository;
import com.thesuperior.superiormarket.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ProductResponse create(CreateProductRequest request) {

        Category category = categoryRepository.findById(request.categoryId())
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Kategori bulunamadı: " + request.categoryId()
                )
            );

        Product product = new Product();

        product.setName(request.name());
        product.setSku(request.sku());
        product.setBarcode(request.barcode());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return toResponse(savedProduct);
    }
    
    @Transactional
    public ProductResponse update(Long id, UpdateProductRequest request) {

        Product product = productRepository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Ürün bulunamadı: " + id)
            );

        Category category = categoryRepository.findById(request.categoryId())
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Kategori bulunamadı: " + request.categoryId()
                )
            );

        product.setName(request.name());
        product.setSku(request.sku());
        product.setBarcode(request.barcode());
        product.setCategory(category);

        return toResponse(product);
    }
    
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {

        Product product = productRepository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Ürün bulunamadı: " + id)
            );

        return toResponse(product);
    }
    
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {

        return productRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }
    
    private ProductResponse toResponse(Product product) {

        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getSku(),
            product.getBarcode(),
            product.getCategory().getId(),
            product.getCategory().getName()
        );
    }
    
    @Transactional
    public void delete(Long id) {

        Product product = productRepository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Ürün bulunamadı: " + id)
            );

        productRepository.delete(product);
    }
}
