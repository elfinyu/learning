package PhoneBook;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PhoneBook.search.SearchByContactNo;
import PhoneBook.search.SearchByEmail;
import PhoneBook.search.SearchByName;

public class PhoneBookTest {
	
	ContactManagement contactManagement;
	Contact contact1,contact2,contact3,contact4,contact5,contact6;
	
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
		contact4 = new Contact("Aaron");
		contact4.addContactNumber(ContactNumberType.Main, "54643123");
		contact4.addContactEmail(ContactEmailType.Other, "54643123@gmail.com");
		contact4.addContactEmail(ContactEmailType.Other, "aaron@gmail.com");
		contact5 = new Contact("yudAn");
		contact6 = new Contact("YudAn");
		contactManagement=new ContactManagement();
		contactManagement.addContact(contact1);
		contactManagement.addContact(contact2);
		contactManagement.addContact(contact3);
		contactManagement.addContact(contact4);
		contactManagement.addContact(contact5);
		contactManagement.addContact(contact6);
	}
	@Test
	public void testAdd(){
		//contactManagement.showContacts();
		System.out.println();
		String expectedStr="[YuDan, ElfinYu, Ellan, Aaron, yudAn, YudAn]";
		Assert.assertEquals(contactManagement.getContactList(),expectedStr);
		Assert.assertEquals(contactManagement.getContactNumbers(contact1), "[84484513, 84484508]");
		Assert.assertEquals(contactManagement.getContactNumbers(contact2), "[84484588]");
		Assert.assertEquals(contactManagement.getContactEmails(contact2), "[elfinyudan@gmail.com, elfinyu88@gmail.com]");
	}
	
	@Test
	public void testGroup(){
		contactManagement.addGroup("Friends", contact1);
		contactManagement.addGroup("Friends", contact2);
		contactManagement.addGroup("Friends", contact3);
		contactManagement.addGroup("Colleagues",contact4);
		contactManagement.addGroup("Strangers");
		contactManagement.addGroup("Kins");
		Assert.assertEquals(contactManagement.getGroupListSize(), 4);
		Assert.assertEquals(contactManagement.getGroupList(), "{Strangers=[], Colleagues=[Aaron], Friends=[YuDan, ElfinYu, Ellan], Kins=[]}");
		contactManagement.removeGroup("Strangers");
		Assert.assertEquals(contactManagement.getGroupListSize(), 3);
	}
	
	@Test
	public void testSearchByName(){
		System.out.println(contactManagement.searchContact(new SearchByName(), ("YuDan")));
	}

	@Test
	public void testSearchByContact(){
		System.out.println(contactManagement.searchContact(new SearchByContactNo(), "1234"));
	}
	
	@Test
	public void testSearchByEmail(){
		System.out.println(contactManagement.searchContact(new SearchByEmail(), "elfinyu88"));
	}
	
	@Test
	public void testSortByName(){
		System.out.println("Before sort");
		System.out.println(contactManagement.getContactList());
		contactManagement.sortPhoneBook(ContactManagement.CONTACT_NAME_ASCENDING_COMPARATOR);
		System.out.println("After sort");
		System.out.println(contactManagement.getContactList());
		
	}
	
}
