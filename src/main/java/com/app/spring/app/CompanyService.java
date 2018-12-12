package com.app.spring.app;


import java.util.List;

import org.springframework.stereotype.Service;


public interface CompanyService {
	
	List<User> getAllUsers();
	List<UserDepartment> getAllUserDepartment();
	
	User addUser(User user);
	
	void updateUser(User user);
	
	User deleteUser(User optional);
	
	User findUserById(Long Id);

}
