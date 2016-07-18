package PhoneBook.search;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import PhoneBook.Contact;
import PhoneBook.ContactEmail;

public class SearchByEmail implements SearchCondition{

	@Override
	public boolean matches(Contact contact, String value) {
		// TODO Auto-generated method stub
		Map<String,ContactEmail> emails=contact.getEmails();
		Set<String> keys=emails.keySet();
		for(String key:keys){
			if(StringUtils.containsIgnoreCase(key, value)){
				return true;
			}
		}
		return false;
	}

}
