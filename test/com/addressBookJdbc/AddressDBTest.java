package com.addressBookJdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressDBTest {
	//check all contact data in data base
	@Test
	public void checkContactsInDB() {
		AddressBook addressBook = new AddressBook();
		List<PersonInformation> dbContact = addressBook.readContactData(AddressBook.IOService.DB_IO);
		Assert.assertEquals(2, dbContact.size());
	}

}
