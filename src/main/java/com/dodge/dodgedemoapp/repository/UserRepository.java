package com.dodge.dodgedemoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dodge.dodgedemoapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("from User u where u.userName=:userName and u.password=:password")
	public User findByUserNameNPassword(@Param("userName") String userName, @Param("password") String password);

}
