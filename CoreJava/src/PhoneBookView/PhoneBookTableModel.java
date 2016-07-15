package PhoneBookView;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import PhoneBook.Contact;
import PhoneBook.PhoneBook;

public class PhoneBookTableModel implements TableModel{

	PhoneBook phonebook = MainFrame.phonebook;
	private final List<TableModelListener> listeners = new ArrayList<TableModelListener>();
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "contact";
	}

	@Override
	public int getRowCount() {
		return phonebook.getTotalContacts();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Contact contact = phonebook.getContact(rowIndex);
		String value = contact.getName();
		return value;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
