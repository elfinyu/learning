package PhoneBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ContactManagement implements PhoneBook {

	final Collection<Contact> contactList;
	final HashMap<String,Collection<Contact>> contactGroupsHashMap;
	public ContactManagement(){
		this.contactList = new ArrayList<Contact>();
		this.contactGroupsHashMap = new HashMap<String,Collection<Contact>>();
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

	@Override
	public void updateContacts() {
		// TODO Auto-generated method stub
		
	}

	public void addGroup(String groupType) {
		Collection<Contact> grpList=new ArrayList<Contact>();
		contactGroupsHashMap.put(groupType, grpList);
	}
	public void addGroup(String groupType, Contact contact){
		if(contactGroupsHashMap.containsKey(groupType)){
			contactGroupsHashMap.get(groupType).add(contact);
		}else{
			addGroup(groupType);
			addGroup(groupType, contact);
		}
	}
	public String getGroupList(){
		return contactGroupsHashMap.toString();
	}
	public int getGroupListSize(){
		return contactGroupsHashMap.size();
	}
	public void removeGroup(String groupType){
		if(contactGroupsHashMap.containsKey(groupType)){
			contactGroupsHashMap.remove(groupType);
		}else{	
			System.out.println("No such group exists!");
		}	
	}

	@Override
	public int getTotalContacts() {
		return this.contactList.size();
	}

	@Override
	public Contact getContact(int index) {
		Contact[] array = this.contactList.toArray(new Contact[this.contactList.size()]);
		return array[index];
	}
}
