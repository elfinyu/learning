package PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Contact {

	private String name;
	private String company;
	private String title;
	//private String email;
	
	private Map<String,ContactNumber> contactNumbers = new HashMap<String,ContactNumber>();
	private Map<String,ContactEmail> contactEmails = new HashMap<String,ContactEmail>();
	
	public Contact(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}		
	public void addContactNumber(ContactNumberType type, String number){
		contactNumbers.put(number,new ContactNumber(number, type));
	}
	
	public void removeContactNumber(String number){
		if(contactNumbers.containsKey(number)){
			contactNumbers.remove(number);
		}
	}
	
	//add and remove email which store in HashMap data structure
	public void addContactEmail(ContactEmailType type, String email){
		contactEmails.put(email, new ContactEmail(email,type));
	}
	
	public void removeContactEmail(String email){
		if(contactEmails.containsKey(email)){
			contactEmails.remove(email);
		}
	}

	public String getPhoneNumbers(){
		Set<String> contactNoSet=contactNumbers.keySet();
		return contactNoSet.toString();
	}		
	public void showDetailedPhoneNumbers(){
		Set<String> contactNoSet=contactNumbers.keySet();
		for(String contactNo:contactNoSet){
			System.out.println("ConactNo:" + contactNo + " Type:" + contactNumbers.get(contactNo));
		}
	}	
	public String getEmails(){
		return contactEmails.keySet().toString();
	}
	
	public void addContactToGroup(){
		
	}
	
	
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	
	public void setCompany(String company){
		this.company=company;
	}
	public String getCompany(){
		return this.company;
	}	

	public String toString(){
		return this.name;
	}
}
