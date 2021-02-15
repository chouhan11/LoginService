package com.yitsol;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yitsol.entity.User;
import com.yitsol.repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Login Api with JWT Security.", version = "1.0", description = "Rekareka Login service..!!"))
@SpringBootApplication
@Controller
public class EVCSLoginService {

	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	private void initUser() {

		List<User> users = Stream.of(new User(101, "user1", "user1", "mady.army@gmail.com", ""),
				new User(102, "user2", "user2", "urvashi1490@gmail.com", "")).collect(Collectors.toList());
		userRepo.saveAll(users);

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showPage() {
		return "login";
	}

	public static void main(String[] args) {
		SpringApplication.run(EVCSLoginService.class, args);
	}

}
