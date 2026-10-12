package com.thesuperior.superiormarket.product.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProductRequest(
		 @NotBlank(message = "Ürün adı boş olamaz")
		    String name,

		    @NotBlank(message = "SKU boş olamaz")
		    String sku,

		    @NotBlank(message = "Barkod boş olamaz")
		    String barcode,

		    @NotNull(message = "Kategori seçilmelidir")
		    @Positive(message = "Kategori ID pozitif olmalıdır")
		    Long categoryId) {

	
}
