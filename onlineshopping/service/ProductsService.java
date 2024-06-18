package com.batch2.onlineshopping.service;

import com.batch2.onlineshopping.dto.ProductsDTO;
import com.batch2.onlineshopping.exceptions.InvalidProductDetailsException;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;

public interface ProductsService {
	ProductsDTO addProducts(ProductsDTO productsdto) throws InvalidProductDetailsException;

	ProductsDTO getProducts(int id) throws ProductNotFoundException;

	ProductsDTO updateProducts(ProductsDTO productsdto, int id)
			throws ProductNotFoundException, InvalidProductDetailsException;

	String deleteProducts(int id) throws ProductNotFoundException;

	}
