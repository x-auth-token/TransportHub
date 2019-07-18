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

import javax.persistence.EntityManager;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import com.pl.transporthub.shared.interfaces.GenericRepository;
import com.pl.transporthub.util.db.SQLiteJDBC;

public class UserRepository implements GenericRepository<User>{
	
	private SQLiteJDBC sqliteConneciton;
	private final String dbFolderName = "DB";
	private final String dbName = "Users"; 
	
	public UserRepository() {
		
		try {
			sqliteConneciton = new SQLiteJDBC(dbFolderName, dbName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> find(Specification spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
