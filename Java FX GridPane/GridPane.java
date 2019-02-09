//Antonio Jusino
package adj008;

//Importing everything needed
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;    
import java.util.Random;


//Creating class with JavaFX app
public class Assignment08 extends Application {
	
	//Creating stage
	public void start (Stage primaryStage) {
		
		try {
		//Setting up size of stage
		int SIZE = 10;
		int length = SIZE;
		int width = SIZE;
		
		//Creating new gridpane
		GridPane root = new GridPane();
		
		//Using two for loops for the length and width of the pane
		for(int x=0; x < length; x++) {
			for (int y=0; y<width; y++) {
				
				//Creating random generator, and assigning 
				//randy to use only 1's or 2's
				Random rand = new Random();
				int randy = rand.nextInt(2);
				
				//Creating textfield and assigning height and weight
				//I found it easier to put the int.tostring method 
				//Instead of using set text, I hope that is okay
				TextField lit = new TextField(Integer.toString(randy));
				lit.setPrefHeight(50);
				lit.setPrefWidth(50);
				lit.setAlignment(Pos.CENTER);
				lit.setEditable(false);
				
				//Assigning gridpane
				root.setRowIndex(lit, x);
				root.setColumnIndex(lit, y);
				root.getChildren().add(lit);
				
			}
		}
		//Creating scene for stage with root and height and width
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("Matrix");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}catch(RuntimeException e) {
			System.out.println("Did not run");
		}
	}
	//Launching stage above through main
	public static void main(String[] args) {
		launch(args);
	}
}
