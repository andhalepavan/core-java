package edu.jsp.userapp.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.userapp.model.User;
import edu.jsp.userapp.model.comparator.SortbyContact;
import edu.jsp.userapp.model.comparator.SortbyDOB;
import edu.jsp.userapp.model.comparator.SortbyEmail;
import edu.jsp.userapp.model.comparator.SortbyId;
import edu.jsp.userapp.model.comparator.SortbyName;
import edu.jsp.userapp.model.comparator.SortbyPassword;
import edu.jsp.userapp.model.exception.UserNotFoundException;

public class UserController {

	private List<User> users = new  ArrayList<>();
	
	
	public User saveUser(User user) {
		try {
			users.add(user);
			return user;
		} catch (Exception e) {
			return null;
		}
	}
	public User searchUser(int id) {
		for (User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		throw new UserNotFoundException(id);
	}
	
	public List<User> getAllUSers(Comparator<User> comparator){
		if(users!=null && !users.isEmpty()) {
			return sortUsers(users,comparator);
		
		}
		else {
			throw new UserNotFoundException();
		}
	}
	public boolean deleteUser(User user) {
		for (User user1 : users) {
			if(user.equals(user1)) {
				users.remove(user);
				return true;
			}
		}
		   return false;
	}
	
	public List<User> sortUsers(List<User> users,Comparator<User> comparator){
		if (comparator instanceof SortbyId) {
			Collections.sort(users, comparator);
			}
		else if(comparator instanceof SortbyName) {
			Collections.sort(users, comparator);
			
		}
		else if(comparator instanceof SortbyContact) {
			Collections.sort(users, comparator);
			
		}
		else if(comparator instanceof SortbyEmail) {
			Collections.sort(users, comparator);
			
		}
		else if(comparator instanceof SortbyPassword) {
			Collections.sort(users, comparator);
			
		}
		else if(comparator instanceof SortbyDOB) {
			Collections.sort(users, comparator);
			
		}
		
		
		return users;
		
	}
	public List<User> getAllUSers(){
		return users;
	}
	
}
