/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
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
