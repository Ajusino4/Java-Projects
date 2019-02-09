package adj007;

//Antonio Jusino

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment07 {

	public static void main(String[] args) {
		try {
		//Setting up input from user
		System.out.print("Enter an integer m: ");
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		
		//Starting first arraylist
		ArrayList<Integer> facts = new ArrayList<>();
		
		//Running method
		getFacts(m, facts);
		
		//Running int through method 
		int smallSquare = smallSquare(facts);
		
		//Output for user
		System.out.println("The smallest number n for m * n to be a perfect square is: " + smallSquare);
		System.out.println("m * n = " + (m * smallSquare));
		
		//Closing input after everything has ended
		input.close();
		} catch (RuntimeException e) {
			System.out.println("Error with runtime");
		}
	}//End of main
	private static int smallSquare(ArrayList<Integer> facts) {
		//Running facts through copy method
		int[][] nums = copy(facts);
		for(int i : facts) {
			search(nums, i);
		}
		//Using this array to run through removing duplicates
		ArrayList<Integer> oddfacts = removeDuplicates(nums);
		
		int smallSquare = 1;
		for (int i : oddfacts) {
			smallSquare *= i;
		}
		return smallSquare;
		
	} //End of smallSquare method
	
	private static ArrayList<Integer> removeDuplicates(int[][] m ) {
		//Setting up array
		ArrayList<Integer> tempo = new ArrayList<>();
		
		//Adding correct factors
		for (int i = 0; i < m.length; i++) {
			if (m[i][1] % 2 != 0) {
				tempo.add(m[i][0]);
			}
		}
		//Setting up duplicate remove
		ArrayList<Integer> dupRemoved = new ArrayList<>();
		for (int i = 0; i < tempo.size(); i++ ) {
			if (!dupRemoved.contains(tempo.get(i))) {
				dupRemoved.add(tempo.get(i));
			}
		}
		
		return dupRemoved;
		
	}//End of removeDuplicates method 
	
	private static void getFacts(int m, ArrayList<Integer> facts) {
		
		int count = 2;
		//Getting factors through this while loop
		while (count <= m) {
			if (m % count == 0) {
				facts.add(count);
				m /= count;
			} else {
				count++;
		
			}	
		}
	}//End of getFacts method 
	private static void search (int[][] m, int number) {
		
		//Using this method and loop to go through factors of m
		for (int i = 0; i < m.length; i++) {
			if (m[i][0] == number) {
				m[i][1]++;
			}
		}
	}//End of search method
	
	private static int[][] copy(ArrayList<Integer> facts) {
		
		//Copying factors to tempo
		int[][] tempo = new int[facts.size()][2];
		
		//Using this for loop to add factors to facts
		for(int i = 0; i < tempo.length; i++) {
			tempo[i][0] = facts.get(i);
		}
		
		return tempo;
	}//End of copy method
	
	
}//End of class
