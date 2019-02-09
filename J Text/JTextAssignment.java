package adj004;
//Antonio Jusino

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JTextassignment {

	//Only using main to call JTextArea
	public static void main(String[] args) {
		JTextArea();
	}
	public static void JTextArea() {
		
		try {
		//Setting up frame
		JFrame frame = new JFrame("Testing JFieldText and JPassword");
		
		//Closing frame when pressing red X
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting up grid layout
		frame.setLayout(new GridLayout(2, 2));
		
		//Setting up JTextFields
		JTextField userNameField, defaultField, defaultField1;
		
		//Setting up default text fields for 2 and 3
		defaultField = new JTextField("Enter text here");
		defaultField1 = new JTextField("Uneditable text field");
		
		//Making them uneditable
		defaultField.setEnabled(false);
		defaultField1.setEnabled(false);
		
		//Setting up fields for use
		userNameField = new JTextField(10);
		JPasswordField passwordField = new JPasswordField();
		
		//Adding fields to frame
		frame.add(userNameField);
		frame.add(defaultField);
		frame.add(defaultField1);
		frame.add(passwordField);
		
		//Making frame visible and setting size
		frame.setVisible(true);
		frame.setSize(350, 80);
		
		//Using this method to call text when ENTER is pressed
		userNameField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	       JOptionPane.showMessageDialog(null, "textfield1: " + userNameField.getText());
	    }
		});
	}catch (RuntimeException e) {
		System.out.println("Error");
	}
	
}
}
