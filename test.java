/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 09/23/19
 * Submitted:  09/24/19
 * @author: Nick Setaro
 * @version: 2019.09.23
 */

public class test {

	public static void main(String[] args) {
		
		//declare and instantiate lists of Strings to be compared
		String [] one = new String [] {"a", "t", "a", "a", "1", "1", "1", "21", "to", "%"};
		String [] two = new String [] {"A", "T", "z", "1", "A", "9", "18", "81", "top", "0"};
		
		//Iterate through each pair and compare them
		for (int i = 0; i < two.length; i++) {
			System.out.println(one[i] + " compared to " + two[i] + " :"
								+ Integer.toString(one[i].compareTo(two[i])));
		}
	}

}
