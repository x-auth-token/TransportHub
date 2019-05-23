package com.pl.transporthub.shared.interfaces;


public interface GenericUnitOfWork<T> {
	
	void beginTransaction();
	void commit();
	void rollback();
}

