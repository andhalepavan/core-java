package edu.jsp.userapp.model.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(int id){
		 super("user id not found "+ id);
	 }
	public UserNotFoundException(){
		 super("  No user found ");
	 }
	 

}
