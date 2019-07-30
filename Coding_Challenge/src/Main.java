import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Reverse a string without using String inBuilt function

public class Main {
	
	private static boolean hasDuplicate = false;
	public final static String FILE_NAME = "TestExcel.xlsx";

	public static void main(String arg[]) {
		String s = "Pepper pick a pack of peppers";
		
		question1("Hello");
		question3(52, 24);
		question4(52, 24);
		
		HashMap <String, Integer> hashmap = question5(s);
		question6(hashmap);
		question7();
		System.out.println("Question 8: |Palindrome:| " + question8(13576531));
		question9(0, 1);
		question10();
		question15(s);
		
		int [] example = {1, 5, 2, 10, 7, 8 , 3};
		question16(example);
		question17(153);
		question18(s);
		question19(s);
		try {
			question20();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	/* Q #1) Write a Java Program to reverse a string without using String inbuilt function. */
	public static void question1(String word){
		char[] wordArray = word.toCharArray();
		String newWord = "";
		
		for (int i = wordArray.length - 1; i >= 0; i--) {
			newWord += String.valueOf(wordArray[i]);
			
		}
		System.out.println("Question 1: " + newWord);
	}
	
	/* Q #3) Write a Java Program to swap two numbers with using the third variable.  */
	public static void question3(int x, int y){
		int temp = x;
		x = y;
		y = temp;
		
		System.out.print("Question 3: ");
		System.out.print("x = " + x);
		System.out.print(" : ");
		System.out.println("y = " + y);
	}

	/* Q #4) Write a Java Program to swap two numbers without using the third variable. */
	public static void question4(int x, int y) {
		x = x - y;
		y = y + x;
		x = y - x;
		
		System.out.print("Question 4: ");
		System.out.print("x = " + x);
		System.out.print(" : ");
		System.out.println("y = " + y);
	}
	
	/* Q #5) Write a Java Program to count the number of words in a string using HashMap. */
	public static HashMap<String, Integer> question5(String pharse) {
		String [] words = pharse.split(" ");
		HashMap<String, Integer> hashmap = new HashMap<>();
		int counter = 1;
				
		for(String word: words) {
			hashmap.put(word, counter);
			counter++;
		}
		
		System.out.println("Question 5: Hashmap word count: " + counter); // hashmap.size() would work as well;
		
		return hashmap;
	}
	
	/* Q #6) Write a Java Program to iterate HashMap using While and advance for loop. */
	public static void question6(HashMap <String, Integer> hMap) {
		Iterator<Map.Entry<String, Integer>> i = hMap.entrySet().iterator();
		
	
		System.out.print("Question 6: |While loop| ");
		while(i.hasNext()) {
			Map.Entry<String, Integer> entry = i.next(); 
             System.out.print(entry.getKey() + " "); 
		}
		System.out.println();
		
		System.out.print("	    |Advance for loop| ");
		for(String word: hMap.keySet()) {
			System.out.print(word + " ");
		}
		System.out.println();


		
	}
	
	/* Q #7) Write a Java Program to find whether a number is prime or not. */
	public static void question7() {
		boolean prime = true;
		int n = 23;
		
		// Cases where we can't calculate but know
		if (n <= 1 ) {
			prime = false;
		} else if (n <= 3 ) { 
			prime = true; 
		}
		
		// Skips the first 5 numbers
		if (n % 2 == 0 || n % 3 == 0) {
			prime = true;
		}
		
		// Checks the rest of the numbers for prime
		for (int i = 5; i * i <= n; i +=6 ) {
			if(n % i == 0 || n % (i + 2) == 0) {
				prime = false;
			}
		}
		
		System.out.println("Question 7: |Prime number: " + n + " | " + prime);
		
			
	}
	
	/* Q #8) Write a Java Program to find whether a string or number is palindrome or not. */
	public static < E > boolean question8(E input) {
		String s = input.toString();
		char[] c = s.toCharArray();
		int end;
		
		if (c.length % 2 == 0) {
			
			end = c.length - 1;
			for(int i = 0; i <= end / 2 + 1; i++) {
				if (c[i] != c[end]) {
					return false;
				}
				end--;
			}
			return true;
		} else {
			end = c.length - 1;
			for(int i = 0; i <= end / 2; i++) {
				if (c[i] != c[end]) {
					return false;
				}
				end--;
			}
			return true;
		}
		
	}
	
	/* Q #9) Write a Java Program for Fibonacci series. */
	public static void question9(int first, int second) {
		int temp;
		int numOfSequence = 20;
		
		System.out.print("Question 9: |Fibonacci| " + first + ", " + second);
		for(int i = 0; i < numOfSequence; i++) {
			temp = first + second;
			first = second;
			second = temp;
			
			System.out.print(", " + temp);
		}
		
		System.out.println(", ....");
	}
	
	/* Q #10) Write a Java Program to iterate ArrayList using for-loop, while-loop, and advance for-loop. */
	public static void question10() {
		ArrayList <String> names = new ArrayList<>();
		names.add("John");
		names.add("Jim");
		names.add("James");
		names.add("Jason");
		names.add("Jeff");
		
		System.out.print("Question 10: ");
		
		System.out.print("for-loop: ");
		for(int i = 0; i < names.size(); i++) {
			System.out.print(names.get(i));
			if (i != names.size()- 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		
		
		System.out.print("	     while-loop: ");
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext()) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		
		int i = 0;
		System.out.print("	     for-loop: ");
		for(String name: names) {
			System.out.print(name);
			if (i != names.size() - 1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println();
	}
	
	/* Q #11) Write a Java Program to demonstrate explicit wait condition check. */
	public static void question11() {
		

		/*****************************************************************/	
		/*****  													******/
		/*****      	Run the Wait_Demonstration.java	      		******/
		/*****  													******/
		/*****************************************************************/
		
		
	}
	
	/* Q #12) Write a Java Program to demonstrate Scroll up/ Scroll down. */
	public static void question12() {
		
		
		/*****************************************************************/	
		/*****  													******/
		/*****      	Run the Scrolling_Demonstration.java	    ******/
		/*****  													******/
		/*****************************************************************/
		
				/*   Scrolling_To_Demonstration.java is a bonus   */
		
		
	}
	
	/* Q #13) Write a Java Program to open all links of gmail.com. */
	public static void question13() {
		
		
		/*****************************************************************/	
		/*****  													******/
		/*****      		Run the OpenAllLinks.java	    		******/
		/*****  													******/
		/*****************************************************************/
		
		
	}
	
	/* Q #14) Write a Selenium code to switch to the previous tab. */
	public static void question14() {
		
		
		/*****************************************************************/	
		/*****  													******/
		/*****      	Run the SwitchToPreviousTab.java	    	******/
		/*****  													******/
		/*****************************************************************/
		
		
	}
	
	/* Q #15) Write a Java Program to find the duplicate characters in a string. */
	public static void question15(String s) {
		// Make all characters lowercase and gets rid of white spaces
		s = s.toLowerCase().replaceAll("\\s", "");
		
		// Converts to character array
		char[] c = s.toCharArray();
		ArrayList<Character> duplicate = new ArrayList<Character>();
		
		
		// Check each character 
		for (int i = 0; i < c.length; i++) {
			hasDuplicate = false;
			
			// Check to see if character is in duplicate array
			for (int k = 0; k < duplicate.size(); k++) {
				
				if (c[i] == duplicate.get(k)) {
					hasDuplicate = true;
				}
				
			}
			
			// If character is not in duplicate array then check if it has a duplicate in String
			if(hasDuplicate == false) {
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] == c[j]) {
						duplicate.add(c[j]);
						break;
					}
					
				}
			}	
		}
		
		// Concatenate all characters in duplicate array to display
		String duplicateCharacters = "";
		for(int i = 0; i < duplicate.size(); i++) {
			if (i == duplicate.size() - 1) {
				duplicateCharacters += duplicate.get(i);
			} else {
				duplicateCharacters += duplicate.get(i) + ", ";
			} 
		}
		
		System.out.println("Question 11: |Duplicate charcters| " + duplicateCharacters);
	}
	
	/* Q #16) Write a Java Program to find the second highest number in an array.*/
	public static void question16(int [] e) {
		int highest = 0;
		int secondHighest = 0;
		
		
		for (int i = 0; i < e.length; i++) {
			
			// Replaces highest number
			if (e[i] > highest) {
				highest = e[i];
			}
			
			// Replaces second highest if still lower than highest number
			if(e[i] > secondHighest && e[i] < highest) {
				secondHighest = e[i];
			}
			
			
		}
		
		System.out.println("Question 16: |Second Highest| " + secondHighest);
		
	}
	
	/* Q #17) Write a Java Program to check Armstrong number.*/
	public static void question17(int num) {
		int c = 0;
		int a;
		int temp = num;
		
		// Breaks up each number and multiplies it 3 times then adds all numbers together
		while (num > 0) {
			a = num % 10;
			num = num / 10;
			c += (a * a * a);
		}
		
		
		if(temp == c) {
			System.out.println("Question 17: |Armstrong| " + temp + " is an Armstrong number");
		} else {
			System.out.println("Question 17: |Armstrong| " + temp + " is NOT an Armstrong number");
		}
		
	}
	
	/* Q #18) Write a Java Program to remove all white spaces from a string with using replace().*/
	public static void question18(String s){
		s = s.replace(" ","");
		System.out.println("Question 18: |Yes replace()|" + s);
	}
	
	/* Q #19) Write a Java Program to remove all white spaces from a string without using replace().*/
	public static void question19(String s) {
		String [] splitString = s.split(" ");
		String newString = "";
		
		
		for (int i = 0; i < splitString.length; i++) {
			newString += splitString[i];
		}
		
		
		System.out.println("Question 19: |No replace()| " + newString);
	}
	
	/* Q #20) Write a Java Program to read an excel.*/
	public static void question20() throws IOException {
	
		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		Workbook wb = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = wb.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();
		
		System.out.println("Question 20: |Reading Excel File|");
		
		while (iterator.hasNext()) {
			
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			
			while (cellIterator.hasNext()) {
				
				Cell currentCell = cellIterator.next();
				
				if(currentCell.getCellType() == CellType.STRING) {
					System.out.print(currentCell.getStringCellValue() + "		");
				} else if (currentCell.getCellType() == CellType.NUMERIC) {
					System.out.print(currentCell.getNumericCellValue() + "		");
				}
			}
			
			System.out.println();
		}
		
	}

}
