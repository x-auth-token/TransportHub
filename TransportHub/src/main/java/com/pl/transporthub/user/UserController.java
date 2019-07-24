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
package com.pl.transporthub.user;

import java.time.LocalDate;
import java.util.List;


import com.pl.transporthub.aaa.Roles.Role;


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
	
	public void addUser(User u) {
		
		userRepository.add(u);
		
	}
	
	public void start() {
		userRepository = new UserRepository();
	}


	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	

}
