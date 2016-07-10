

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contact {

	private String name;
	private String company;
	private String title;
	
	private Map<String,ContactNumber> contactNumbers = new HashMap<String,ContactNumber>();
	
	public Contact(String name){
		this.name = name;
	}
		
	public void addContactNumber(ContactNumberType type, String number){
		contactNumbers.put(number,new ContactNumber(number, type));
	}
	
	public void removeContactNumber(String number){
		if(contactNumbers.containsKey(number)){
			contactNumbers.remove(number);
		}
	}
	public void removeContactNumber(Contact c){

	}	
	public void updateContactNumber(){}
}
