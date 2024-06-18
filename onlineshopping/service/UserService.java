package com.batch2.onlineshopping.service;

import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.exceptions.InvalidUserDetailsException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;

public interface UserService {

	UserDTO saveUserDetails(UserDTO user) throws InvalidUserDetailsException;

	UserDTO updateUser(UserDTO userDo, int id) throws UserNotFoundException, InvalidUserDetailsException;

	UserDTO getUserDetails(int id) throws UserNotFoundException;

	void deleteUser(int id) throws UserNotFoundException;

}
