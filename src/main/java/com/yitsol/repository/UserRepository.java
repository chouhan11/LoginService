package com.yitsol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yitsol.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String name);

	//User findByEmail(String email);

	Optional<User> findByEmail(String email);

	Optional<User> findByResetToken(String resetToken);
}
