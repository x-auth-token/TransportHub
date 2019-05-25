package com.pl.transporthub.shared.interfaces;

import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import com.pl.transporthub.user.User;

// Generic Repository Class using Java Generics
public interface GenericRepository<T> {
	
	void add(T t );
	void remove(T t);
	T get(T t);
	Iterable <T> getAll();
	Iterable<T> find(Specification spec);
	

}
