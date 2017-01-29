package com.websystique.springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.websystique.springboot.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users;
	private int counter;
	
	@PostConstruct
	public void init() {
		
		System.out.println( "Initializing User Service" );
		
		users = new ArrayList<User>();
		counter = 1;
		
		User mike 	= new User( "Michael", 	65000 );
		
		this.saveUser( mike );
		
		User olivia = new User( "Olivia", 	60000 );
		
		this.saveUser( olivia );
		
		User jack 	= new User( "Jack", 	1000  );
		
		this.saveUser( jack );
	}
	
	public List<User> findAll() {
		
		return users;
	}

	public User findById(long id) {
		
		for ( User user : users ) {
			
			if ( id == user.getId() ) {
				
				return user;
			}
		}
		
		return null;
	}

	public boolean isUserExist(User newUser) {
		
		if ( newUser.getId() == 0 ) {
			
			return false;
		}
		
		User user = this.findById( newUser.getId() );
		
		return user != null;
	}

	public void saveUser(User newUser) {
		
		newUser.setId( counter++ );
		users.add( newUser );
	}

	public void updateUser(User newUser) {
		
		User user = this.findById( newUser.getId() );
		
		if ( user != null ) {
			
			user.setName( newUser.getName() );
			user.setSalary( newUser.getSalary() );
		}
	}

	public void deleteById(long id) {
		
		User user = this.findById(id);
		
		if ( user != null ) {
			
			users.remove( user );
		}
		
	}

	public void deleteAll() {
		
		users.clear();
		
	}
	
	
}
