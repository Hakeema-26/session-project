package com.batch2.onlineshopping.controller;







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



