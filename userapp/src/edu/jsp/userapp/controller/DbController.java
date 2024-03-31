package edu.jsp.userapp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.connectionpool.ConnectionPool3;
import edu.jsp.userapp.model.User;

public class DbController {

	private Connection connection;
	private PreparedStatement statement;
	private ResultSet set;

	public User saveUser(User user) {

		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?)");

			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setLong(4, user.getContact());
			statement.setString(5, user.getPassword());
			statement.setDate(6, Date.valueOf(user.getDOB()));

			int rows = statement.executeUpdate();

			if (rows > 0) {
				return user;

			} else {
				return null;

			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public User searchUser(int id) {

		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USERS WHERE id= ?");
			statement.setInt(1, id);
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				User user = new User();
				user.setId(set.getInt(1));
				user.setName(set.getString(2));
				user.setEmail(set.getString(3));
				user.setContact(set.getLong(4));
				user.setPassword(set.getString(5));
				user.setDOB(LocalDate.parse(set.getString(6)));

				return user;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public boolean deleteUser(User user) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("DELETE FROM USERS WHERE ID = ?");
			statement.setInt(1, user.getId());
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<User> getAllUSers() {
		List<User> users = new ArrayList<>();
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USERS ");

			set = statement.executeQuery();
			while (set.next()) {
				User user = new User();
				user.setId(set.getInt(1));
				user.setName(set.getString(2));
				user.setEmail(set.getString(3));
				user.setContact(set.getLong(4));
				user.setPassword(set.getString(5));
				user.setDOB(LocalDate.parse(set.getString(6)));

				users.add(user);
			}
			if (!users.isEmpty()) {
				return users;

			} else {
				return null;

			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				try {
					set.close();
					ConnectionPool3.recieveConnection(connection);
					statement.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	public List<User> getAllUSers(Comparator<User> comparator) {
		List<User> users = getAllUSers();

		if (users != null) {
			Collections.sort(users, comparator);
		}
		return users;
	}

	public User updateName(int id, String name) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("UPDATE USERS SET NAME=? WHERE id= ?");
			statement.setString(1, name);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {

				return searchUser(id);
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public User updateEmail(int id, String email) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("UPDATE USERS SET EMAIL=? WHERE id= ?");
			statement.setString(1, email);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {

				return searchUser(id);
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public User updateContact(int id, Long contact) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("UPDATE USERS SET CONTACT=? WHERE id= ?");
			statement.setLong(1, contact);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {

				return searchUser(id);
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public User updatePassword(int id, String password) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("UPDATE USERS SET PASSWORD=? WHERE id= ?");
			statement.setString(1, password);
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {

				return searchUser(id);
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public User updateDOB(int id, LocalDate dob) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection.prepareStatement("UPDATE USERS SET DOB=? WHERE id= ?");
			statement.setDate(1, Date.valueOf(dob));
			statement.setInt(2, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return searchUser(id);
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public User updateAll(int id, String name, Long contact, String email, String password, LocalDate dob) {
		try {
			connection = ConnectionPool3.getConnection();
			statement = connection
					.prepareStatement("UPDATE USERS SET NAME=?, CONTACT=?, EMAIL=?, PASSWORD=?, DOB=? WHERE id=?");
			statement.setString(1, name);
			statement.setLong(2, contact);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setDate(5, Date.valueOf(dob));
			statement.setInt(6, id);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return searchUser(id);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (statement != null) {
				ConnectionPool3.recieveConnection(connection);
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
