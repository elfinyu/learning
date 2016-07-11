package PhoneBookView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import PhoneBook.Contact;
import PhoneBook.ContactEmailType;
import PhoneBook.ContactManagement;
import PhoneBook.ContactNumberType;
import PhoneBook.PhoneBook;

public class MainFrame extends JFrame{

	public static final PhoneBook phonebook = new ContactManagement();;
	
	public MainFrame(){
		
		Contact contact1 = new Contact("YuDan");
		contact1.addContactNumber(ContactNumberType.Main, "84484508");
		contact1.addContactNumber(ContactNumberType.Mobile, "84484513");
		contact1.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		Contact contact2 = new Contact("ElfinYu");
		contact2.addContactNumber(ContactNumberType.Main, "84484588");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyu88@gmail.com");
		contact2.addContactEmail(ContactEmailType.Other, "elfinyudan@gmail.com");
		Contact contact3 = new Contact("Ellan");
		contact3.addContactNumber(ContactNumberType.Main, "12345678");
		contact3.addContactEmail(ContactEmailType.Other, "wewqrw@gmail.com");
		contact3.addContactEmail(ContactEmailType.Other, "asfsdw@gmail.com");
		
		
		phonebook.addContact(contact1);
		phonebook.addContact(contact2);
		phonebook.addContact(contact3);
	}
	
	public static void main(String[] args){
		
		
		MainFrame panel = new MainFrame();
		panel.setLayout(new BorderLayout());
		
		panel.add(new PhoneBookPanel(), BorderLayout.CENTER);
		
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(true);
		
		panel.setSize(320, 600);
		
			
		
	}
}
