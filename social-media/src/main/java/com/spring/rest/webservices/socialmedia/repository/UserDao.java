package com.spring.rest.webservices.socialmedia.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.spring.rest.webservices.socialmedia.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	private static List<User> users =  new ArrayList<>();
	private static Integer usersCount = 3;
	
	static {
		users.add(new User(1, "John", new Date(), "Newyork", "NY", "10005"));
		users.add(new User(2, "Helen", new Date(), "Chicago", "IL", "60176"));
		users.add(new User(3, "Alan", new Date(), "San Francisco", "CA", "94105"));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null)
			user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findById(Integer id) {
		for(User user : users) {
			if(user.getId().equals(id))
				return user;
		}
		return null;
	}
	
	public User deleteById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId().equals(id)) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
