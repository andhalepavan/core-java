package edu.jsp.userapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {
	@Override
	public int hashCode() {
		return Objects.hash(DOB, contact, email, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode()==obj.hashCode();
	}

	private int id;
	private String name;
	private String password;
	private String email;
	private long contact;
	
	private  LocalDate DOB;

	public User(int id, String name, String password, String email, long contact, LocalDate dOB) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
		DOB = dOB;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	

	@Override
	public String toString() {
		return " \n Id:" + id + " \n Name:" + name + " \n Password:" + password + "\n Email:" + email + "\n Contact:"
				+ contact + " \n DOB:" + DOB + "\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate doB) {
		DOB=doB;
	}
	
}