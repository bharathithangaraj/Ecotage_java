package com.ecotage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecotage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByMobileNumber(String mobileNo);
	
	public Optional<User> findByEmail(String email);
	
	public Optional<User> findByLoginId(String loginId);

}
