package com.neosoft;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.neosoft.dao.UserRepository;
import com.neosoft.entities.User;
import com.neosoft.services.UserService;

@SpringBootTest
public class UserServiceTesting {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	/**
	 * Validates the newly added user
	 * 
	 * @throws ParseException
	 */
	@Test
	
	void checkNewUser() throws ParseException {
		String filterDate = "12-04-2019";
		 DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = dateFormatter.parse(filterDate);
		User user=new User("yashsivtt","Shas","690467890","9387",date);
		User result=userService.update(user);
		int maxId=userRepository.getMax();
		
		assertThat(result.getUser_id()).isEqualTo(maxId);
	}
	@Test
	
     void checkDeleteUser() {
    	 Integer id=5;
    	   boolean exitBeforeDelete = userRepository.findById(id).isPresent();
    	    userRepository.deleteById(id);
    	    boolean exitAfterDelete = userRepository.findById(id).isPresent();
    	    assertTrue(exitBeforeDelete);
    	    assertFalse(exitAfterDelete);
     }
	@Test
	void checkForAUser() {
		 // Integer id=13;
		  String first_name="Priya";
		  String last_name="Sharma";
		  String address="4332";
		  boolean recordExists = userRepository.findByNameAndAddress(first_name, last_name, address).isEmpty();
		  System.out.println(recordExists);
		  assertTrue(recordExists);
	}
	
}
