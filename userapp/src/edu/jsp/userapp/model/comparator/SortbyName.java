package edu.jsp.userapp.model.comparator;

import java.util.Comparator;

import edu.jsp.userapp.model.User;

public class SortbyName implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
