package PhoneBook;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ContactManagement implements PhoneBook {

	public static final Comparator CONTACT_NAME_ASCENDING_COMPARATOR = new NameAscending();
	
	final protected Collection<Contact> contactList;
	final HashMap<String,Collection<Contact>> contactGroupsHashMap;
	public ContactManagement(){
		this.contactList = new ArrayList<Contact>();
		this.contactGroupsHashMap = new HashMap<String,Collection<Contact>>();
	}
	
	@Override
	public void addContact(Contact contact){
		contactList.add(contact);
	}
	@Override
	public void removeContact(Contact contact){
		contactList.remove(contact);
	}
	@Override
	public void showContacts(PrintStream out){
		for(Contact c:contactList){
			out.println("Contact "+((ArrayList<Contact>)contactList).indexOf(c)+" :"+ c
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
	
	@Override
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
	
	@Override
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
	
	@Override
	public Collection<Contact> searchContactByName(String contactName) {
		Collection<Contact> matchList=new ArrayList<Contact>();
		for (Contact contact:contactList){
			if(contact.toString().equalsIgnoreCase(contactName)){
				matchList.add(contact);
			}
		}
		return matchList;
//		Contact[] contactArray = this.contactList.toArray(new Contact[this.contactList.size()]);
//		Arrays.binarySearch(contactArray, contactName);		
	}

	@Override
	public void sortPhoneBook(Comparator<Contact> comparator){
		ArrayList<Contact> list = (ArrayList<Contact>) this.contactList;
		Collections.sort(list, comparator);
	}
	
	
	private static class NameAscending implements Comparator<Contact>{

		@Override
		public int compare(Contact o1, Contact o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
}
