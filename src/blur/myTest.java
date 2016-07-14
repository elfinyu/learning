package blur;

import org.junit.Before;
import org.junit.Test;

import PhoneBook.Contact;
import PhoneBook.ContactEmailType;
import PhoneBook.ContactManagement;
import PhoneBook.ContactNumberType;


public class myTest {
	ContactManagement contactManagement;
	Contact contact1, contact2, contact3, contact4, contact5, contact6;

	@Before
	public void init() {

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
		contactManagement = new BlurContactManagement();
		contactManagement.addContact(contact1);
		contactManagement.addContact(contact2);
		contactManagement.addContact(contact3);
		contactManagement.addContact(contact4);
		contactManagement.addContact(contact5);
		contactManagement.addContact(contact6);

	}

	@Test
	public void test() {
		System.out.println(contactManagement.sortContactByName());
		
	}
}
