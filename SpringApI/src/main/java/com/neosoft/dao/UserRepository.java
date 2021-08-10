package com.neosoft.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM USERTABLE "
			+ "WHERE DELETEROW = 0 "
			+ "AND (IFNULL(FIRST_NAME,'') LIKE %?1%) "
			+ "AND (IFNULL(LAST_NAME,'') LIKE %?2%) "
			+ "AND (IFNULL(ADDRESS,'') LIKE %?3%) ", nativeQuery=true)
	public  List<User> findByNameAndAddress(String first_name, String last_name, String address);
	
	@Query(value="SELECT u from User u ORDER BY u.joiningdate DESC")
	public List<User> findAllOrderByDojDesc();
	@Query(value = "SELECT * from USERTABLE where FIRST_NAME LIKE %?1",nativeQuery=true)
	public List<User> findAllFirstNameLike(String first_name);
	
	
	@Query(value="SELECT MAX(USER_ID) FROM USERTABLE",nativeQuery=true)
	 public Integer getMax();
}