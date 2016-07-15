package PhoneBook;

public class ContactEmail {
	String contactEmail;
	ContactEmailType contactEmailType;
	
	public ContactEmail(String contactEmail,ContactEmailType contactEmailType){
		this.contactEmail=contactEmail;
		this.contactEmailType=contactEmailType;
	}

	public String getEmail(){
		return this.contactEmail;
	}
	
	public ContactEmailType getType(){
		return this.contactEmailType;
	}
	
}
