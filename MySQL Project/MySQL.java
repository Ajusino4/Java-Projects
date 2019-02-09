//Antonio Jusino
package adj010;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.Scanner;

public class Assignment10 {

	public static void main(String[] args) throws MalformedURLException, IOException, SQLException, ClassNotFoundException {
		
		//Using sql credentials 
		String url = "jdbc:mysql://localhost:3306/quiz?autoReconnect=true&useSSL=false";
		String uname = "root";
		String pass = "root";
		//Using file for txt file
		File file = new File("Quiz (1).txt"); 
		Scanner input = new Scanner(file);
		
		//Creating new class for name, with drivermanager and string for connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		String queryString = "INSERT INTO quiz2" + "(questionId, question, choicea, choiceb, choicec, choiced, answer)" + "values (?, ?, ?, ?, ?, ?, ? )";
		 
		//Using while loop to continue  through the file
		while(input.hasNextLine()) {
			
			//Using preparedstatement for querystring
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			String nextLine = input.nextLine();
			
			if(nextLine.equals("")) {
				continue;
			}
			//Starting up first 2 rows of strings
			preparedStatement.setString(1, nextLine.substring(0,  nextLine.indexOf(".")));
			preparedStatement.setString(2,  nextLine.substring(nextLine.indexOf(".") + 2));
			
			//Using do loop for answers to questions
			do {
				nextLine = input.nextLine();
			} while((nextLine.length() < 2) || (!nextLine.substring(0, 2).equals("a.")));
			
			//Creating strings for txt in prepared statement
			preparedStatement.setString(3,  nextLine.substring(3));
			preparedStatement.setString(4, input.nextLine().substring(3));
			preparedStatement.setString(5, input.nextLine().substring(3));
			preparedStatement.setString(6, input.nextLine().substring(3));
			preparedStatement.setString(7, input.nextLine().substring(7));
			preparedStatement.executeUpdate();
		}
		//Closing input, and displaying queryString for myself
		input.close();
		System.out.print(queryString);
			
		}
	
}//End of class 
