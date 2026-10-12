package com.thesuperior.superiormarket.product.dto.product;

public record ProductResponse(
		
		 Long id,
		    String name,
		    String sku,
		    String barcode,
		    Long categoryId,
		    String categoryName
		    ) {

}
