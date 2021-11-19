package com.addressBookJdbc;

import java.util.List;

public class AddressBook {
	private AddressBookDB addressBookDB;
	private List<PersonInformation> contacts;

	
	public enum IOService {
		DB_IO
	}

	public AddressBook() {
		addressBookDB = AddressBookDB.getInstance();
	}

	public List<PersonInformation> readContactData(IOService ioService) {
		if (ioService.equals(IOService.DB_IO))
			this.contacts = addressBookDB.readData();
		System.out.println(this.contacts);
		return this.contacts;
	}

}
