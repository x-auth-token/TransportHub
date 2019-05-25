package com.pl.transporthub.user;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Expression;

import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import com.pl.transporthub.shared.interfaces.GenericRepository;

public class UserRepository implements GenericRepository<User>{
	
	private EntityManager em;
	
	public UserRepository(EntityManager em) {
		
		this.em = em;
	}

	@Override
	public void add(User u) {
		
		if (u.getUsername() == null) {
			em.persist(u);
		} else {
			u = em.merge(u);
		}
		
	}

	@Override
	public void remove(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getAll() {
		
		return em.createQuery("SELECT * from Users u", User.class).getResultList();
	}

	@Override
	public Iterable<User> find(Specification spec) {
		
		return null;
	}


}
