package com.neosoft.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.dao.UserRepository;
import com.neosoft.entities.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepositiory;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * @param updated
	 * @return
	 */
	public User update(User updated) {
		
		if(updated.getUser_id() == null) {
			//Create
			updated = userRepositiory.save(updated);
		}
		
		else{
			
			// update
			User original = userRepositiory.findById(updated.getUser_id()).orElseThrow(() -> new RuntimeException("Invalid Id"));
			original.setFirst_name(updated.getFirst_name());
			original.setLast_name(updated.getLast_name());
			original.setMobile_no(updated.getMobile_no());
			original.setAddress(updated.getAddress());
			updated = userRepositiory.save(original);
		}
		
		return updated;
	}
	public User delete(Integer id, Boolean permanent)
	{
		User user=userRepositiory.findById(id).orElseThrow(() -> new RuntimeException("Invalid ID"));
		
		if(permanent != null && permanent)
		        userRepositiory.delete(user);
		else
		{
			user.setDeleterow(true);
			user = userRepositiory.save(user);
		}
		
		return user;
		
	}
	public List<User> searchUsers(String first_name, String last_name, String address){
		System.out.println("________________0");
		if((first_name == null || first_name.isBlank())
			&& (last_name == null || last_name.isBlank())
			&& (address == null || address.isBlank()))
		throw new RuntimeException("Missing search parameters");
		System.out.println("__________1");
	logger.debug("Find Customer by first_name {} , last_name {} or address {} ", first_name, last_name, address);
	return userRepositiory.findByNameAndAddress(first_name, last_name, address);
		
	}
	
	public List<User> findAllUsers(String name) {
		
		  if(name != null && !name.isEmpty())
		  {
			  return userRepositiory.findAllFirstNameLike(name);
		  }
		return userRepositiory.findAllOrderByDojDesc();
		
	}

}
