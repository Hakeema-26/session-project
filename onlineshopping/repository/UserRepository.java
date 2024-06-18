package com.batch2.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch2.onlineshopping.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
	
	public User getUserById(int id);

}
