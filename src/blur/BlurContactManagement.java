package blur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import PhoneBook.Contact;
import PhoneBook.ContactManagement;

public class BlurContactManagement extends ContactManagement {

	public static final Comparator CONTACT_NAME_COMPARATOR = new ContactNameComparator();
	public static final Comparator CONTACT_NAME_COMPARATOR_USING_STRING = new ContactNameComparatorUsingStringComparator();
	
	@Override
	public Collection<Contact> sortContactByName() {
		List<Contact> copy = null;
		if(this.contactList instanceof List){
			List<Contact> mycastLst = (List) this.contactList;
			copy =new ArrayList<Contact>(mycastLst);
			
			System.out.println(copy);
			Collections.sort(copy, CONTACT_NAME_COMPARATOR);
			return copy;
		}
		
		return copy;
	}
	

private static class ContactNameComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

private static class ContactNameComparatorUsingStringComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
	}
	
}
	
}
