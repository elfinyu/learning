package test;

import PhoneBook.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneBookTest {
	
	ContactManagement contactManagement;
	@Test
	public void TestAdd(){
		Contact contact1 = new Contact("YuDan");
		contact1.addContactNumber(ContactNumberType.Main, "84484508");
		contact1.addContactNumber(ContactNumberType.Mobile, "84484513");
		contact1.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		Contact contact2 = new Contact("ElfinYu");
		contact2.addContactNumber(ContactNumberType.Main, "84484588");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyudan@gmail.com");
		contactManagement=new ContactManagement();
		contactManagement.addContact(contact1);
		contactManagement.addContact(contact2);
		//contactManagement.showContacts();
		System.out.println();
		Assert.assertEquals(contactManagement.getContactList(), "[YuDan, ElfinYu]");
		Assert.assertEquals(contactManagement.getContactNumbers(contact1), "[84484513, 84484508]");
		Assert.assertEquals(contactManagement.getContactNumbers(contact2), "[84484588]");
		Assert.assertEquals(contactManagement.getContactEmails(contact2), "[elfinyudan@gmail.com, elfinyu88@gmail.com]");
	}
}
