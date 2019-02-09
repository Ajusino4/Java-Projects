package adj009;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClientSide extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Assigning jtextfield and streams for input for server and client
	private JTextField jtfInterest = new JTextField();
	private JTextField jtfYears = new JTextField();
	private JTextField jtfLoan = new JTextField();
	private JTextArea jta = new JTextArea();
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	//Running main through constructor
	public static void main(String[] args) {
		new ClientSide();
	}
	
    public ClientSide() {
    	
    	//Setting up jpanel to the jtextfields
		JPanel jPan = new JPanel(new GridLayout(3, 2, 2, 5));
		jPan.add(new JLabel("Annual Interest Rate"));
		jPan.add(jtfInterest);
		jPan.add(new JLabel("Number of years"));
		jPan.add(jtfYears);
		jPan.add(new JLabel("Loan amount"));
		jPan.add(jtfLoan);
		
		//Creating a new panel with a border, and setting it to the first jpanel
		JPanel jPan2 = new JPanel(new BorderLayout(5,5));
		jPan2.add(jPan, BorderLayout.CENTER);
		
		//Creating a button and assigning it to border panel
		JButton jButton = new JButton("Submit");
		jPan2.add(jButton, BorderLayout.EAST);
		
		//Setting up layout with jscrollpane for text
		setLayout(new BorderLayout());
		add(jPan2, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		jButton.addActionListener(new Listener());
		
		//Setting up prefrences for client
		setTitle("ClientChat");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		Socket socket;
		//Putting the try and catch here meant the socket would close
		//And not enable a resource leak
		try {
		
		socket = new Socket("localhost", 5000);
		fromServer = new DataInputStream(socket.getInputStream());
		toServer = new DataOutputStream(socket.getOutputStream());
		
		}catch(IOException ex) {
			jta.append(ex.toString() + '\n');
		}
		
    }

    private class Listener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    		//Starting off with try method because toserver will ask for it
    		try {
    			
    		//Getting text from classes
    		double interest = Double.parseDouble(jtfInterest.getText());
    		int year = Integer.parseInt(jtfYears.getText());
    		double loanAmount = Double.parseDouble(jtfLoan.getText());
    		
    		//Sending information to server
    		toServer.writeDouble(interest);
    		toServer.writeInt(year);
    		toServer.writeDouble(loanAmount);
    		toServer.flush();
    		
    		//Reading information from server
    		double monthlyPayment = fromServer.readDouble();
    		double totalPayment = fromServer.readDouble();
    		
    		//Text for the panel
    		
    		jta.append("Annual Interest Rate: " + interest + "\n");
    		jta.append("Number of years: " + year + "\n");
    		jta.append("Loan amount: " + loanAmount + "\n");
    		jta.append("monthlyPayment: " + monthlyPayment + "\n");
    		jta.append("totalPayment: " + totalPayment + "\n");
    		}catch(IOException ex) {
    			System.out.println("Caught an error");
    		}
    	}
    }
}//End of class
    

