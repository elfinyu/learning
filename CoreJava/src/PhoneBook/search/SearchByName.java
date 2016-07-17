package PhoneBook.search;

import org.apache.commons.lang3.StringUtils;

import PhoneBook.Contact;

public class SearchByName implements SearchCondition{

	@Override
	public boolean matches(Contact contact, String value) {
		if(StringUtils.containsIgnoreCase(contact.getName(), value)){
			return true;
		}
		return false;
	}

}
