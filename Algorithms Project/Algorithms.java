package adj002;
import java.util.*;

import javax.management.RuntimeErrorException;

public class Algorithms {

	public static void main(String[] args) {
		
		//Setting up String with letters and list for string
		String[] letters = {"P", "C", "M" };
		List<String> list1 = new ArrayList<String>();
		
		//Creating string for list
		for (String x: letters) {
			list1.add(x);
		}
		
		//Setting up reverseList and reversing it
		List<String> reverseList = new ArrayList<String>(list1);
		Collections.reverse(reverseList);
		
		//Using copyList to copy the reverseList
		List<String> copyList = new ArrayList<String>(reverseList);
		
		//Creating fillList and filling it with "R"
		List<String> fillList = new ArrayList<String>(list1);
		Collections.fill(fillList, "R");
		
		//Setting up collection max
		Collections.max(list1);
		Collections.max(reverseList);
		Collections.max(fillList);
		Collections.max(copyList);
		
		//Setting up collection min
		Collections.min(list1);
		Collections.min(reverseList);
		Collections.min(fillList);
		Collections.min(copyList);
		
		//Using try and catch to catch errors
		try { 
			List<String> reverseList1 = new ArrayList<String>(list1);
			Collections.reverse(reverseList1);
			
			//Using copyList to copy the reverseList
			List<String> copyList1 = new ArrayList<String>(reverseList1);
			
			//Creating fillList and filling it with "R"
			List<String> fillList1 = new ArrayList<String>(list1);
			Collections.fill(fillList1, "R");
		}
			catch (RuntimeErrorException e) {
			System.out.println("Caught Runtime exception");
			}
		
	
		//Setting up output with the four lists I created
		output(list1, copyList, reverseList, fillList);
		
	}//End of main
	
	public static void output(List<String> list1, List<String> copyList, List<String> reverseList, List<String> fillList) {
			//Printing info for original list
			System.out.print("The list contains: =3\n\n");
			System.out.printf("The list is: %s\n ", list1);
			System.out.printf("\nMax: %s",  Collections.max(list1));
			System.out.printf(" Min: %s\n",  Collections.min(list1));
			
			//Printing info for reverse list
			System.out.print("\nAfter calling reverse, list contains:\n");
			System.out.printf("\nThe list is: %s\n", reverseList);
			System.out.printf("\nMax: %s",  Collections.max(reverseList));
			System.out.printf(" Min: %s\n",  Collections.min(reverseList));
			
			//Printing info for copy list
			System.out.print("\nAfter copying, copyList contains:\n");
			System.out.printf("\nThe list is: %s\n", copyList);
			System.out.printf("\nMax: %s",  Collections.max(copyList));
			System.out.printf(" Min: %s\n",  Collections.min(copyList));
			
			//Printing info for fill list 
			System.out.print("\nAfter calling reverse, list contains:\n");
			System.out.printf("\nThe list is: %s\n", fillList);
			System.out.printf("\nMax: %s",  Collections.max(fillList));
			System.out.printf(" Min: %s\n",  Collections.min(fillList));
	}//End of output method
}//End of class
