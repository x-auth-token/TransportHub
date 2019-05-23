package com.pl.transporthub.shared.interfaces;

// Generic Repository Class using Java Generics
public interface GenericRepository<T> {
	
	void add(T t );
	void remove(T t);
	T get(T t);
	Iterable <T> getAll();
	Iterable <T> findAll(T t);
	

}
