package com.kodnest.tunehubb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehubb.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

	public User findByEmail(String email);

}
