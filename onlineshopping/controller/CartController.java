package com.batch2.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.batch2.onlineshopping.entity.Products;
import com.batch2.onlineshopping.exceptions.ProductNotFoundException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;
import com.batch2.onlineshopping.service.CartService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
public class CartController {
	@Autowired
	CartService cartService;

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_CUSTOMER')")
	@PostMapping("/addCart")
	public String addCart(@RequestParam int userId, @RequestParam int productId)
			throws ProductNotFoundException, UserNotFoundException {

		return cartService.addCart(userId, productId);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_CUSTOMER')")
	@GetMapping("/getCart/{id}")
	public List<Products> getCart(@PathVariable Integer id) throws UserNotFoundException {

		return cartService.getCart(id);

