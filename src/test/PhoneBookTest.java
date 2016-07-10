package test;

import PhoneBook.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhoneBookTest {
	
	ContactManagement contactManagement;
	Contact contact1;
	Contact contact2;
	Contact contact3;
	Contact contact4;
	@BeforeTest
	public void createPhonebook(){
		contact1 = new Contact("YuDan");
		contact1.addContactNumber(ContactNumberType.Main, "84484508");
		contact1.addContactNumber(ContactNumberType.Mobile, "84484513");
		contact1.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		contact2 = new Contact("ElfinYu");
		contact2.addContactNumber(ContactNumberType.Main, "84484588");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyudan@gmail.com");
		contact3 = new Contact("Ellan");
		contact3.addContactNumber(ContactNumberType.Main, "12345678");
		contact3.addContactEmail(ContactEmailType.Other, "wewqrw@gmail.com");
		contact3.addContactEmail(ContactEmailType.Other, "asfsdw@gmail.com");
		contact3 = new Contact("Aaron");
		contact3.addContactNumber(ContactNumberType.Main, "54643123");
		contact3.addContactEmail(ContactEmailType.Other, "54643123@gmail.com");
		contact3.addContactEmail(ContactEmailType.Other, "aaron@gmail.com");
		contactManagement=new ContactManagement();
		contactManagement.addContact(contact1);
		contactManagement.addContact(contact2);
		contactManagement.addContact(contact3);
		contactManagement.addContact(contact4);
	}
	@Test
	public void testAdd(){
		//contactManagement.showContacts();
		System.out.println();
		Assert.assertEquals(contactManagement.getContactList(), "[YuDan, ElfinYu, Aaron, null]");
		Assert.assertEquals(contactManagement.getContactNumbers(contact1), "[84484513, 84484508]");
		Assert.assertEquals(contactManagement.getContactNumbers(contact2), "[84484588]");
		Assert.assertEquals(contactManagement.getContactEmails(contact2), "[elfinyudan@gmail.com, elfinyu88@gmail.com]");
	}
	
	@Test
	public void testGroup(){
		contactManagement.addGroup("Friends", contact1);
		contactManagement.addGroup("Friends", contact2);
		contactManagement.addGroup("Friends", contact3);
		contactManagement.addGroup("Collgues",contact4);
		contactManagement.addGroup("Stragers");
		contactManagement.addGroup("Kins");
		Assert.assertEquals(contactManagement.getGroupListSize(), 4);
		Assert.assertEquals(contactManagement.getGroupList(), "{Stragers=[], Collgues=[null], Friends=[YuDan, ElfinYu, Aaron], Kins=[]}");
		contactManagement.removeGroup("Stragers");
		Assert.assertEquals(contactManagement.getGroupListSize(), 3);
	}
}
