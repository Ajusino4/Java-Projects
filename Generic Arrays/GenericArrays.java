package adj003;


import javax.management.RuntimeErrorException;



public class GenericArrays {

	public static void main(String[] args) {
		
		//Setting up numbers, characters, and circles,
		//and running them through max
		Integer[] numbers = {1,2,3};
		System.out.println(max(numbers));
		
		String[] characters = {"red","blue","green"};
		System.out.println(max(characters));
		
		Circle[] circles = {new Circle(3), new Circle (2.9), new Circle(5.9)};
		System.out.println(max(circles));
		
		//Using try and catch to discover errors
		try {
			Integer[] numbers1 = {1,2,3};
			
			String[] characters1 = {"red","blue","green"};
			
			Circle[] circles1 = {new Circle(3), new Circle (2.9), new Circle(5.9)};
			
		} catch (RuntimeErrorException e) { 
			System.out.println("Caught Runtime Error");
			
		}
	}//End of main
	
	//Setting up class for array of circles
	public static class Circle implements Comparable<Circle> {
		
		//sets value of radius from main method for radius
		 double radius;
		 public Circle (double radius){
	            this.radius = radius; 
	            }
		 
		 //Comparing radius
		 public int compareTo(Circle c) {
			 
		   if(radius < c.radius){
		   return -1;
		   }
		   else {
			   return 1;
		   }
		 }
		 //returning radius
		 public String toString() {
	            return  "Circle radius " + radius;
		 }
	}//end of Circle class
		   
	

	
	//Generic array list
	public static <E extends Comparable<E>> E max (E [] list) {
		//Setting up max with list
		E max = list[0];
		
		//For loop going through list and setting up max
		for(int i = 1; i < list.length; i++) {
			if(list[i].compareTo(max) > 0) {
				max = list[i];
			}
		}
		//Returning max
		return max;
					
	}
	
	
	
	
}//End of class
