package com.batch2.onlineshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.batch2.onlineshopping.dto.UserDTO;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.exceptions.InvalidUserDetailsException;
import com.batch2.onlineshopping.exceptions.UserNotFoundException;
import com.batch2.onlineshopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO saveUserDetails(UserDTO userdto) throws InvalidUserDetailsException {

		if (userdto.getPassword().equals(userdto.getConfirmPassword())) {

			User user = new User(userdto.getUsername(), userdto.getPhoneNo(), userdto.getEmailId(),
					new BCryptPasswordEncoder().encode(userdto.getPassword()), userdto.getRole());

			User user1 = userRepository.save(user);

			UserDTO userdto2 = new UserDTO(user1.getUsername(), user1.getPhoneNo(), user1.getEmailId(),
					user1.getRole());
			return userdto2;
		}
		
		throw new InvalidUserDetailsException("Password and confirm password should be same.");
	}

	@Override
	public UserDTO updateUser(UserDTO userdto, int id) throws UserNotFoundException, InvalidUserDetailsException {

		if (!userRepository.existsById(id)) {

			throw new UserNotFoundException("User not found");
		} else if (userdto.getPassword().equals(userdto.getConfirmPassword())) {

			User user = new User(id, userdto.getUsername(), userdto.getPassword(), userdto.getEmailId(),
					new BCryptPasswordEncoder().encode(userdto.getPassword()), userdto.getRole());

			User user1 = userRepository.save(user);

			UserDTO userdto2 = new UserDTO(user1.getUsername(), user1.getPhoneNo(), user1.getEmailId(),
					user1.getRole());
			return userdto2;
		}

		throw new InvalidUserDetailsException("Password and confirm password should be same.");
	}

	@Override
	public UserDTO getUserDetails(int id) throws UserNotFoundException {

		if (!userRepository.existsById(id)) {

			throw new UserNotFoundException("User not found");
		}
		Optional<User> user = userRepository.findById(id);

		UserDTO userdto = new UserDTO(user.get().getUsername(), user.get().getPhoneNo(), user.get().getEmailId(),
				user.get().getRole());
		return userdto;
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {

		if (!userRepository.existsById(id)) {

			throw new UserNotFoundException("User not found");
		}

		userRepository.deleteById(id);
	}

}