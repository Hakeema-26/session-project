package com.batch2.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;
import com.batch2.onlineshopping.repository.ProductsRepository;
import com.batch2.onlineshopping.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductsRepository productRepository;

	public String addCart(int userId, int productId) throws ProductNotFoundException, UserNotFoundException {

		if (!productRepository.existsById(productId)) {

			throw new ProductNotFoundException("Product not found");
		} else if (!userRepository.existsById(userId)) {

			throw new UserNotFoundException("User not Found");
		} else {
			Products products = productRepository.getProductsById(productId);
			User user = userRepository.getUserById(userId);
			user.getProducts().add(products);
			products.getUsers().add(user);
			userRepository.save(user);
			return "Product added to cart Successfuly";
		}
	}

	@Override
	public List<Products> getCart(Integer id) throws UserNotFoundException {

		if (!userRepository.existsById(id)) {

			throw new UserNotFoundException("User not Found");
		} 
		List<Products> products = userRepository.getUserById(id).getProducts();
		return products;
	}

}
