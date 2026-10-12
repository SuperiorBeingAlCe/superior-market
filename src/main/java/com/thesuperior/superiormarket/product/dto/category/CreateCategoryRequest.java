package com.thesuperior.superiormarket.product.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
		@NotBlank(message = "Kategori adı boş olamaz")
		String name
		) {

}
