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
	private EntityManagerFactory factory;
	private EntityManager em;
	private EntityTransaction transaction;
	
	public UserController() {
		initEM();
		userRepository = new UserRepository(em);
	}
	
	public void initEM() {
		factory = Persistence.createEntityManagerFactory("UsersPU");
		em = factory.createEntityManager();
		transaction = em.getTransaction();
	}
	
	public void printResult() {
		TypedQuery<Passenger> q = em.createQuery("select c from Passenger c", Passenger.class);
		List<Passenger> results = q.getResultList();
		for (Passenger thing : results) {
		  System.out.println(thing.getUserID() + ": " + thing.getUsername());
		}
	}

	

	
	
	public void end() {
		em.close();
		factory.close();
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
		
		transaction.begin();
		userRepository.save(u);
		transaction.commit();
		
	}
	
	public static void main(String args[]) {
		LocalDate date = LocalDate.of(2019, 12, 31);
		final char[] pass = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
		Passenger passenger = new Passenger("user", pass, date, false);
		passenger.setRole(Role.ADMIN);
		passenger.setAuthenticated(true);
		
		UserController controller = new UserController();
		controller.saveUser(passenger);
		controller.printResult();
		controller.end();
	}

}
