package edu.jsp.userapp.view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import edu.jsp.userapp.controller.DbController;
import edu.jsp.userapp.model.User;
import edu.jsp.userapp.model.comparator.SortbyContact;
import edu.jsp.userapp.model.comparator.SortbyDOB;
import edu.jsp.userapp.model.comparator.SortbyEmail;
import edu.jsp.userapp.model.comparator.SortbyId;
import edu.jsp.userapp.model.comparator.SortbyName;
import edu.jsp.userapp.model.comparator.SortbyPassword;
import edu.jsp.userapp.model.exception.UserNotFoundException;

public class View {
	private DbController controller;
	private Scanner scanner;

	private void start() {
		int exit = 0;
		do {
			System.out.println("ENTER YOUR CHOICE\n" + "1.SEARCH USER\n" + "2.DISPLAY ALL USER\n" + "3.SAVE USER\n"
					+ "4.UPDATE USER\n" + "5.DELETE USER\n" + "6.EXIT\n");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: {
				searchUser();
				break;
			}
			case 2: {
				displayAllUsers();
				break;
			}
			case 3: {
				saveUser();
				break;
			}
			case 4: {
				update();
				break;
			}
			case 5: {
				deleteUser();
				break;
			}
			case 6: {
				exit = 6;
				System.out.println("THANK YOU.....");
				break;
			}

			default:
				System.out.println("INVALID CHOICE...PLEASE TRY AGAIN....");
				break;
			}

		} while (exit != 6);
	}

	private void update() {
		System.out.println("ENTER YOUR CHOICE\n" + "1.UPDATE NAME\n" + "2.UPDATE EMAIL\n" + "3.UDPATE PASSWORD\n"
				+ "4.UPDATE CONTACT\n" + "5.UPDATE DOB\n" + "6. UPDATE All\n" + "7.DONT UPDATE\n");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			updateName(); {
			break;
		}
		case 2:
			updateemail(); {
			break;
		}
		case 3:
			updatepassword(); {
			break;
		}
		case 4:
			updatecontact(); {
			break;
		}
		case 5:
			updatedob(); {
			break;
		}
		case 6:
			updateAll(); {
			break;
		}

		case 7:
			System.out.println("USER DETAILS NOT AFFECTED\n"); {
			break;
		}

		default:
			System.out.println("INVALID CHOICE "); {
			break;
		}
		}
	}

	private void updateAll() {
		System.out.println("Enter user id : ");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);

				System.out.println("ENTER NEW USER NAME:");
				String name = scanner.nextLine();

				System.out.println("ENTER NEW USER EMAIL:");
				String email = scanner.nextLine();

				System.out.println("ENTER NEW USER PASSWORD:");
				String password = scanner.nextLine();

				System.out.println("ENTER NEW USER CONTACT:");
				long contact = scanner.nextLong();
				scanner.nextLine();

				System.out.println("ENTER NEW USER DOB IN FORMAT(YYYY-MM-DD):");
				String dobString = scanner.nextLine();
				LocalDate dob = LocalDate.parse(dobString);

				User updatedUser = controller.updateAll(id, name, contact, email, password, dob);
				if (updatedUser != null) {
					System.out.println("USER DETAILS UPDATED SUCCESSFULLY:");
					displayUser(updatedUser);
				} else {
					System.out.println("FAILED TO UPDATE USER DETAILS.");
				}
			} else {
				System.out.println("USER NOT FOUND.");
			}
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void updateName() {

		System.out.println("ENTER USER ID  :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);
			} else {
				return;

			}

			System.out.println("ENTER NEW USER NAME  :\n");
			String name = scanner.nextLine();

			User user2 = controller.updateName(id, name);
			if (user2 != null) {
				System.out.println("USER NAME UPDATED\n");
				displayUser(user2);

			} else {
				System.out.println("USER NOT FOUND ... UPDATE FAILED.");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void updateemail() {

		System.out.println("ENTER USER ID :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);
			} else {
				return;

			}

			System.out.println("ENTER NEW USER EMAIL :\n");
			String email = scanner.nextLine();

			User user2 = controller.updateEmail(id, email);
			if (user2 != null) {
				System.out.println("USER EMAIL UPDATED\n");
				displayUser(user2);

			} else {
				System.out.println("USER NOT FOUND ... UPDATE FAILED.");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void updatepassword() {

		System.out.println("ENTER USER ID :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);
			} else {
				return;

			}

			System.out.println("ENTER NEW USER PASSWORD :\n");
			String password = scanner.nextLine();

			User user2 = controller.updatePassword(id, password);
			if (user2 != null) {
				System.out.println("USER PASSWORD UPDATED\n");
				displayUser(user2);

			} else {
				System.out.println("USER NOT FOUND ... UPDATE FAILED.");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void updatecontact() {

		System.out.println("ENTER USER ID :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);
			} else {
				return;

			}

			System.out.println("ENTER NEW USER CONTACT  :\n");
			Long contact = scanner.nextLong();

			User user2 = controller.updateContact(id, contact);
			if (user2 != null) {
				System.out.println("USER CONTACT UPDATED\n");
				displayUser(user2);

			} else {
				System.out.println("USER NOT FOUND ... UPDATE FAILED.");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void updatedob() {
		System.out.println("ENTER USER ID :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		try {
			User user = controller.searchUser(id);
			if (user != null) {
				displayUser(user);

				System.out.println("ENTER NEW USER DOB(YYYY-MM-DD) :\n");
				String DOB = scanner.nextLine();
				LocalDate dob = LocalDate.parse(DOB);

				User user2 = controller.updateDOB(id, dob);
				if (user2 != null) {
					System.out.println("USER DOB UPDATED\n");
					displayUser(user2);
				} else {
					System.out.println("USER DOB NOT UPDATED ... SOMETHING WENT WRONG.");
				}
			} else {
				System.out.println("USER NOT FOUND ... UPDATE FAILED.");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void saveUser() {
		System.out.println("ENTER USER ID :\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("ENTER USER NAME :\n");
		String name = scanner.nextLine();

		System.out.println("ENTER USER EMAIL :\n");
		String email = scanner.nextLine();

		System.out.println("ENTER USER PASSWORD :\n");
		String password = scanner.nextLine();

		System.out.println("ENTER USER CONTACT :\n");
		long contact = scanner.nextLong();
		scanner.nextLine();

		System.out.println("ENTER USER DOB  IN FORMAT(YYYY-MM-DD):");
		String DOB = scanner.nextLine();
		LocalDate date = LocalDate.parse(DOB);

		User user = new User(id, name, email, password, contact, date);

		if (controller.saveUser(user) != null) {
			System.out.println("USER SAVED....");
		} else {
			System.out.println("SOMETHING WENT WRONG....PLEASE TRY AGAIN....");
		}
	}

	private void deleteUser() {
		System.out.println("ENTER USER ID :");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("ENTER USER NAME :");
		String name = scanner.nextLine();

		System.out.println("ENTER USER EMAIL :");
		String email = scanner.nextLine();

		System.out.println("ENTER USER PASSWORD :");
		String password = scanner.nextLine();

		System.out.println("ENTER USER CONTACT :");
		long contact = scanner.nextLong();
		scanner.nextLine();

		System.out.println("ENTER USER DOB IN FORMATE(YYYY-MM-DD) :\n");
		String DOB = scanner.nextLine();
		LocalDate date = LocalDate.parse(DOB);

		User user = new User(id, name, email, password, contact, date);

		if (controller.deleteUser(user)) {
			System.out.println("USER DELETED SUCCESSFULLY....");
		} else {
			System.out.println("SOMETHING WENT WRONG....PLEASE TRY AGAIN....");
		}
	}

	public View(DbController controller, Scanner scanner) {

		this.controller = controller;
		this.scanner = scanner;
	}

	private void searchUser() {
		System.out.println("ENTER USER ID TO SEARCH\n");
		int id = scanner.nextInt();
		scanner.nextLine();
		try {
			displayUser(controller.searchUser(id));
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayAllUsers() {
		List<User> users = null;
		try {
			System.out.println("ENTER CHOICE\n" + "1.SORT BY ID\n" + "2.SORT BY NAME\n" + "3.SORT BY EMAIL\n "
					+ "4.SORT BY PASSWORD\n" + "5.SORT BY CONTACT\n" + "6.SORT BY DOB\n" + "7.DONT SORT\n");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: {
				users = controller.getAllUSers(new SortbyId());
				break;
			}
			case 2: {
				users = controller.getAllUSers(new SortbyName());
				break;
			}
			case 3: {
				users = controller.getAllUSers(new SortbyEmail());
				break;
			}
			case 4: {
				users = controller.getAllUSers(new SortbyPassword());
				break;
			}
			case 5: {
				users = controller.getAllUSers(new SortbyContact());
				break;
			}
			case 6: {
				users = controller.getAllUSers(new SortbyDOB());
				break;
			}
			case 7: {
				users = controller.getAllUSers();
				break;
			}
			default: {
				System.out.println("USER NOT SORTED");
				users = controller.getAllUSers();
			}
				break;
			}
			if (users != null) {

				for (User user : users) {
					System.out.println(user);
				}
			} else {
				System.out.println("USER NOT FOUND");
			}

		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void displayUser(User user) {
		System.out.println(".......................................................");
		System.out.println("User ID:" + user.getId());
		System.out.println("User Name:" + user.getName());
		System.out.println("User Email:" + user.getEmail());
		System.out.println("User Password:" + user.getPassword());
		System.out.println("User Contact:" + user.getContact());
		System.out.println("User DOB:" + user.getDOB());
		System.out.println(".......................................................");

	}

	public static void main(String[] args) {
		View view = new View(new DbController(), new Scanner(System.in));
		view.start();
	}
}