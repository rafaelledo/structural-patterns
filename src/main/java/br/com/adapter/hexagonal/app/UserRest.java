package br.com.adapter.hexagonal.app;

import br.com.adapter.hexagonal.core.usercases.UserService;
import br.com.adapter.hexagonal.infrastructure.UserMemoryDatabaseAdapter;

import java.util.List;
import java.util.Map;

import br.com.adapter.hexagonal.core.model.User;
import br.com.adapter.hexagonal.core.ports.UserRepository;

public class UserRest {
	private UserService userService;

	public UserRest() {
		UserRepository userRepo = new UserMemoryDatabaseAdapter();
		userService = new UserService(userRepo);
	}

	public Integer post(Map<String, String> values) {
		try {
			User user = new User(values.get("name"), values.get("email"), values.get("password"));
			userService.saveUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 400;
		}	
		return 201;
	}

	public Integer get() {
		List<User> users = userService.getUsers();
		users.stream().forEach(user -> {
			System.out.println(user);
		});
		return 200;
	}
}
