package com.app.spring.app;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static Role role = new Role();
    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/user/{userId}/addrole", method = RequestMethod.POST)
    public ResponseEntity<?>  addUser(@PathVariable Integer userId,@RequestBody Role newRole){
		
		 role = userService.addUser(userId, newRole);
		if (role == null) {
			return ResponseEntity.noContent().build();
		}
		
		
    	
    	 return new ResponseEntity<Role>(role, HttpStatus.OK);
    	
    }
    @RequestMapping(value="user/{userId}/roles")
    public Role getRoles(@PathVariable Long userId) {
		return role;
    	
    }
}