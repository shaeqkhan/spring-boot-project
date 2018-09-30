package com.app.spring.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	Map <Integer,Role> userInfo = new HashMap<>();
	Role role;
	public Role addUser(Integer id, Role newRole) {
		userInfo.put(id, newRole);
		role = newRole;
		return role;
		
	}

}
