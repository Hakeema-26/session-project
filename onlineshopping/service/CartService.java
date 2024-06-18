package com.batch2.onlineshopping.service;

import java.util.List;

import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;

public interface CartService {
	List<Products> getCart(Integer id) throws UserNotFoundException;

//	String addCart(Cart cart);

	String addCart(int userId, int productId) throws ProductNotFoundException, UserNotFoundException;
}
