package PhoneBook;

import java.util.ArrayList;
import java.util.Collection;

public class ContactManagement implements PhoneBook {

	final Collection<Contact> contactList;
	public ContactManagement(){
		this.contactList = new ArrayList<Contact>();
	}
	
	public void addContact(Contact contact){
		contactList.add(contact);
	}
	public void removeContact(Contact contact){
		contactList.remove(contact);
	}
	public void showContacts(){
		for(Contact c:contactList){
			System.out.println("Contact "+((ArrayList<Contact>)contactList).indexOf(c)+" :"+ c
					+" ContactNo.:"+ c.getPhoneNumbers()
					+" ContactEmail:"+ c.getEmails());
		}
	}
	public String getContactList(){
		return contactList.toString();
	}
	public String getContactNumbers(Contact contact){
		return contact.getPhoneNumbers();
	}
	public String getContactEmails(Contact contact){
		return contact.getEmails();
	}

}
