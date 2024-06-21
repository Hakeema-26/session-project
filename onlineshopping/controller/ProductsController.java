package com.batch2.onlineshopping.controller;



import com.batch2.onlineshopping.dto.ProductsDTO;
import com.batch2.onlineshopping.exceptions.InvalidProductDetailsException;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;
import com.batch2.onlineshopping.service.ProductsService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class ProductsController {
	@Autowired
	ProductsService productsService;

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PostMapping("/products")
	public ProductsDTO addProducts(@RequestBody ProductsDTO productdto) throws InvalidProductDetailsException {
		return productsService.addProducts(productdto);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@GetMapping("/products/{id}")
	public ProductsDTO getProducts(@PathVariable int id) throws ProductNotFoundException {

		return productsService.getProducts(id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@PutMapping("/products/{id}")
	public ProductsDTO updateProducts(@RequestBody ProductsDTO products, @PathVariable int id)
			throws ProductNotFoundException, InvalidProductDetailsException {
		
		return productsService.updateProducts(products, id);
	}
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/products/{id}")
	public String deleteProducts(@PathVariable int id) throws ProductNotFoundException {
		
		return productsService.deleteProducts(id);
	}
}



