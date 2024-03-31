package edu.jsp.userapp.model.comparator;

import java.util.Comparator;

import edu.jsp.userapp.model.User;

public class SortbyPassword implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getPassword().compareTo(o2.getPassword());
	}

}
