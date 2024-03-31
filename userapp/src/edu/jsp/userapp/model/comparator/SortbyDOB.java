package edu.jsp.userapp.model.comparator;

import java.util.Comparator;

import edu.jsp.userapp.model.User;

public class SortbyDOB implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getDOB().hashCode()-o2.getDOB().hashCode();
	}

}
