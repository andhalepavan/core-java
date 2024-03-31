package edu.jsp.connectionpool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.print.event.PrintJobAttributeEvent;
import javax.sql.ConnectionPoolDataSource;

public class ConnectionPool3 {
	private static final int POOL_SIZE=10;
  private static List<Connection> connections= new ArrayList<Connection>();
  private static  Properties properties;
  
  private static FileInputStream stream;
  
  static {
	  try {
		stream=new FileInputStream("C:\\A.ADV\\userapp\\src\\edu\\jsp\\connectionpool\\config.properties");
		
		properties = new Properties();
		properties.load(stream);
		
		Class.forName(properties.getProperty("driverpath"));
		
		for(int i=0;i<POOL_SIZE;i++) {
			if(connections.size()<=POOL_SIZE) {
			connections.add(createConnection(properties));
			}
		}
		System.out.println("CONNECTION POOL INITILISED CURRENT SIZE :" + connections.size());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
	private static Connection  createConnection(Properties properties) {
		Connection connection;
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"),properties);
			
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
    }
	
	public static Connection getConnection() {
		if (connections.isEmpty()) {
			System.out.println("POOL IS EMPTY CREATING CONNECTION PLEASE WAITE.....");
			return createConnection(properties);
			
		} else {
			System.out.println("CONNECTION  PROVIDE CURRENT SIZE: " +(connections.size()-1));
			return connections.remove(0);

		}
	}
	
	public static void recieveConnection(Connection connection) {
		
		if (connections.size()<POOL_SIZE) {
			connections.add(connection);
			System.out.println("CONNECTION RECEIVED CURRENT SIZE :"+connections.size());
			
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("POOL IS ...CLOSING CONNECTION");

		}
		
	}

}
