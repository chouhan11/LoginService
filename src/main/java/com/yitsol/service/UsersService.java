package com.yitsol.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.yitsol.entity.User;

@Component
public interface UsersService extends UserDetailsService {

	public Optional<User> getUserByEmail(String email);
	
	public Optional<User> findUserByResetToken(String resetToken);
	
	 public void save(User user);
}
