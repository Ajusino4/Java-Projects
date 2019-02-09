//Antonio Jusino
package adj009;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import javax.swing.*;


public class Assignment09 extends JFrame {
	
	//Declaring a default serial version
	private static final long serialVersionUID = 1L;
	
	//Creating jtextarea
	private JTextArea jtext = new JTextArea();

	//Running main through constructor
	public static void main(String[] args) {
		new Assignment09();
	}
	
	public Assignment09() {
		 
		//Creating server size and frame, JScrollPane is what you need 
		//To see the text, too me too long to figure out..
		setLayout(new BorderLayout());
		add(new JScrollPane(jtext), BorderLayout.CENTER);
		setTitle("ServerChat");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ServerSocket serverSocket = null;
		
		//Putting the try catch method here instead of in the 
		//Beginning so the socket can "close"
		//Creating serversocket and data stream for socket
		try {
		serverSocket = new ServerSocket(5000);
		jtext.append("Server started at " + new Date() + '\n');
		
		Socket socket = serverSocket.accept();
		
		DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());	
		DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
		
		//Using a while loop to read input from client and 
		//Output for server
		while(true) {
			
			//Getting input from client
			double interest = inputFromClient.readDouble();
			int year = inputFromClient.readInt();
			double loanAmount = inputFromClient.readDouble();
			
			//Setting up loan class and getting monthly and total payment
			Loan loan = new Loan(interest, year, loanAmount);
			double monthlyPayment = loan.getMonthlyPayment();
			double totalPayment = loan.getTotalPayment();
			
			//Output to client
			outputToClient.writeDouble(monthlyPayment);
			outputToClient.writeDouble(totalPayment);
			
			//Creating output for server
			jtext.append("Client connected at " + new Date() + '\n');
			jtext.append("Annual Interest Rate: " + interest + "\n");
			jtext.append("Number of years: " + year + "\n");
			jtext.append("Loan amount: " + loanAmount + "\n");
			jtext.append("monthlyPayment: " + monthlyPayment + "\n");
			jtext.append("totalPayment: " + totalPayment + "\n");
			
		}
		}catch(IOException e) {
			System.err.println(e);
		}
		
	}

}//End of class
