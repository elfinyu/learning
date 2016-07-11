package PhoneBook;

public interface PhoneBook {
	
	public void addContact(Contact contact);
	public void removeContact(Contact contact);
	public void showContacts();
	public void updateContacts();
	public void addGroup(String groupType, Contact contact);
	public void removeGroup(String groupType);
	public int getTotalContacts();
	public Contact getContact(int index);
}
