package edu.jsp.userapp.model.comparator;

import java.util.Comparator;

import edu.jsp.userapp.model.User;

public class SortbyContact implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getContact()-o2.getContact());
	}

}
