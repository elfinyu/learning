package PhoneBook.search;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import PhoneBook.Contact;
import PhoneBook.ContactNumber;

public class SearchByContactNo implements SearchCondition {

	@Override
	public boolean matches(Contact contact, String value) {
		Map<String, ContactNumber> phoneNumbers = contact.getPhoneNumbers();
		Set<String> numbers = phoneNumbers.keySet();
		for(String aNumber: numbers){
			if(StringUtils.containsIgnoreCase(aNumber, value)){
				return true;
			}
		}
		return false;
	}

}
