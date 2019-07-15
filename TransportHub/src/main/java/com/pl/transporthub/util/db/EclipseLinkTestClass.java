package com.pl.transporthub.util.db;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Entity
public class EclipseLinkTestClass {
	
	@Id @GeneratedValue
	
	private int id;
	private String text;
	
	public EclipseLinkTestClass() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public static void main(String args[]) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		EntityManager em = factory.createEntityManager();
		
		EclipseLinkTestClass t = new EclipseLinkTestClass();
		t.setText("Test");
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		em.persist(t);
		trans.commit();
		// Fetch them
		TypedQuery<EclipseLinkTestClass> q = em.createQuery("select c from EclipseLinkTestClass c", EclipseLinkTestClass.class);
		List<EclipseLinkTestClass> results = q.getResultList();
		for (EclipseLinkTestClass thing : results) {
		  System.out.println(thing.getId() + ": " + thing.getText());
		}
		// Close the entity manager
		em.close();
		factory.close();
	}

}
