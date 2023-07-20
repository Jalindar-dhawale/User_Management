package com.jalindar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalindar.model.UserDtls;

public interface UsercrudRepository extends JpaRepository<UserDtls, Integer>{
	

	
}
