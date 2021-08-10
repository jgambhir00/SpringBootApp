package com.neosoft.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.entities.User;
import com.neosoft.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody User user, 
			@RequestParam(value ="id", required = false) Integer id){
		
		user.setUser_id(id);
		return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
	}
	@GetMapping(value = "/query")
	public ResponseEntity<?> getUser(@RequestParam(value = "first_name" ,required = false) String first_name,
	                  @RequestParam(value = "last_name", required =false) String last_name,
	                  @RequestParam(value = "address", required =false) String address) {
		             System.out.print("ABCD __________________________" + first_name);
	               List<User> users=userService.searchUsers(first_name, last_name, address);
	               return new ResponseEntity<List<User>>(users, HttpStatus.OK);  
	                  }
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") Integer id,
			@RequestParam(value= "deleterow" , required = false) Boolean deleterow){
	     User user = userService.delete(id, deleterow);
	     return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping(value = "/sort")
	public ResponseEntity<?> sort(@RequestParam(value = "name", required = false) String name) {
	     return new ResponseEntity<List<User>>(userService.findAllUsers(name), HttpStatus.OK);
	}
	@GetMapping("/test")	
	public String response() {
		return "Hello";
	}

}
