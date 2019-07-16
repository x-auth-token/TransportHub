/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pl.transporthub.user;

import java.util.UUID;

import javax.persistence.EntityManager;
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
		if (em.contains(u)) {
			em.remove(u);
		} else {
			em.merge(u);
		}
		
	}

	


	@Override
	public User get(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User u) {
		if (u.getUserID() == null) {
			em.persist(u);
		} else {
			u = em.merge(u);
		}
		
		return u;
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
