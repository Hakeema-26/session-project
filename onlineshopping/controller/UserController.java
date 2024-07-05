package com.batch2.onlineshopping.controller;



import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.exceptions.InvalidUserDetailsException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;
import com.batch2.onlineshopping.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController

public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public UserDTO userRegistration(@RequestBody UserDTO userdto) throws InvalidUserDetailsException {

		return userService.saveUserDetails(userdto);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@PutMapping("/updateUser/{id}")
	public UserDTO updateUser(@RequestBody UserDTO userdto, @PathVariable int id)
			throws UserNotFoundException, InvalidUserDetailsException {

		return userService.updateUser(userdto, id);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@GetMapping("/getUser/{id}")
	public UserDTO getUser(@PathVariable int id) throws UserNotFoundException {

		return userService.getUserDetails(id);
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_CUSTOMER')")
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) throws UserNotFoundException {

		userService.deleteUser(id);
	}

}
