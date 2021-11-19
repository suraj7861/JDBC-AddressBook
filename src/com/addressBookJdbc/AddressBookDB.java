package com.addressBookJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
	private static AddressBookDB addressBookDB;
	
	//database connection
	private Connection makeConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service_db?useSSL=false";
		String userName = "root";
		String password = "Suraj@7861";
		Connection connection;
		System.out.println("Connecting to database:" + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is successful!!!" + connection);
		return connection;
	}

	//read data using query 
	public List<PersonInformation> readData() {
		String query = "SELECT * FROM address_book_service_database";
		return getAddressBookDB(query);
	}

	//get data from data base
	public List<PersonInformation> getAddressBookDB(String query) {
		List<PersonInformation> employeePayrollList = new ArrayList<>();
		try {
			Connection connection = this.makeConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phoneNumber = result.getString("phone_no");
				String email = result.getString("email");
				employeePayrollList
						.add(new PersonInformation(firstName, lastName, address, city, state, zip, phoneNumber, email));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	//check null
	public static AddressBookDB getInstance() {
		if (addressBookDB == null)
			addressBookDB = new AddressBookDB();
		return addressBookDB;
	}
}
