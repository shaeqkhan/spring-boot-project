package com.app.spring.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	Map <Integer,Role> userInfo = new HashMap<>();
	
	public Role addUser(Integer id, Role newRole) {
		Role role;
		userInfo.put(id, newRole);
		role = newRole;
		return role;
		
	}

}
