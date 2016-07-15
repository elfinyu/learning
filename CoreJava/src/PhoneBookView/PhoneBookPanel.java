package PhoneBookView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PhoneBookPanel extends JPanel{

	public PhoneBookPanel(){
		super();
		this.setLayout(new BorderLayout());
		JTextField field = new JTextField();
		this.add(field, BorderLayout.NORTH);
		JButton addContactButton = new JButton("(+)");
		addContactButton.setToolTipText("Add new Contact");
		this.add(addContactButton, BorderLayout.SOUTH);
		
		JTable table = new JTable(new PhoneBookTableModel());
		
		this.add(table, BorderLayout.CENTER);
	}
	
	
}
