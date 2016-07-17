package PhoneBook.search;

import PhoneBook.Contact;

public interface SearchCondition {

	/**
	 * Check if contact matches the value
	 * @param contact
	 * @param value
	 * @return
	 */
	public boolean matches(Contact contact, String value);
	
}
