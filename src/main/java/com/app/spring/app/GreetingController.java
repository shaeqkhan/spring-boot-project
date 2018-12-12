package com.app.spring.app;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring.app.entity.User;
import com.app.spring.app.service.CompanyService;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static Role role = new Role();
	@Autowired
	private UserService userService;

	@Autowired
	private CompanyService companyServiceImpl;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping(value = "/user/{userId}/addrole", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@PathVariable Integer userId, @RequestBody Role newRole) {

		role = userService.addUser(userId, newRole);
		if (role == null) {
			return ResponseEntity.noContent().build();
		}

		return new ResponseEntity<Role>(role, HttpStatus.OK);

	}

	@RequestMapping(value = "user/{userId}/roles")
	public Role getRoles(@PathVariable Long userId) {
		return role;

	}

	@RequestMapping("/users")
	public List<User> getUsers() {
		return companyServiceImpl.getAllUsers();
	}

	@PostMapping(value = "/user/addUser")
	public String addUserInfo(@RequestBody User user) {
		if (companyServiceImpl.addUser(user)!=null) {
			return "user saved succesfully";
		}else {
			return "error saving user";
		}
	}
	
	@DeleteMapping(value="/user/deleteUser")
	public String deleteUserInfo(@RequestParam(value="userId") Long userId) {
		if (companyServiceImpl.findUserById(userId)!=null) {
			companyServiceImpl.deleteUser(companyServiceImpl.findUserById(userId));
			return "user Deleted succesfully";
		}else {
			return "error Deleting user";
		}
	}
}