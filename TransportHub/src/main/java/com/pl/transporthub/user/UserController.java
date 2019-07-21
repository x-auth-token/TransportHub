package com.pl.transporthub.user;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.pl.transporthub.aaa.Roles.Role;
import com.pl.transporthub.util.db.EclipseLinkTestClass;

import sun.security.util.Password;

public class UserController {
	private UserRepository userRepository;
	public UserController() {
		
		
	}

	
	public Iterable<User> getAll(){
		return userRepository.getAll();
	}
	
	public User getUserByID(int id) {
		return userRepository.getByID(id);
	}
	
	public User getUser(User u) {
		return userRepository.get(u);
	}
	
	public void saveUser(User u) {
		
		
		
	}
	
	public void start() {
		userRepository = new UserRepository();
	}


	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	

}
