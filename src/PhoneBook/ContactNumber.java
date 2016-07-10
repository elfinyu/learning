package PhoneBook;

public class ContactNumber {

	private final String contactNumber;
	final ContactNumberType type;
	
	public ContactNumber(String contactNumber, ContactNumberType type){
		this.contactNumber=contactNumber;
		this.type=type;
	}

	public String getContactNumber() {
		return contactNumber;
	}
	
	public ContactNumberType type(){
		return this.type;
	}
	
}
