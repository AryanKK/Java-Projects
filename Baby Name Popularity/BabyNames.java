/*
 Aryan K. Kedarisetty APCS Peterson P3
 Programming Assignment Chp 6 project Baby Names, 1/6/2020
 
 The following program utilizes line and token based processing 
 along with conditional and iterative statements to 
 allow users to gain info about popular baby names from 1900-2000
*/
import java.io.*;
import java.util.*;
public class BabyNames {

	public static void main(String[] args) throws FileNotFoundException { 
		Scanner console = new Scanner(System.in);
		checkAndRun(console); //method call for whole program

	}
	
	//method that checks user's request and returns data
	public static void checkAndRun (Scanner console) throws FileNotFoundException {
		boolean run = true;
		System.out.println("** Popularity of a baby name since year 1900 **");
		do {
			Scanner names = new Scanner (new File("names.txt"));
			boolean found = false;
			System.out.println("name?");
			String inputName = console.next();
			
			while(names.hasNextLine() && !found) { //line-based processing
				Scanner line = new Scanner(names.nextLine());
				while(line.hasNext()) { //scans name line
					String nameFromFile = line.next();
					if (nameFromFile.equalsIgnoreCase(inputName)) {
						saveFilePlusOutput(line, inputName, nameFromFile);
						found = true;
					}	
				}
				if(!names.hasNext() && !found) {
					System.out.println("name not found.");
				}
			}
		run = searchAgain(console);
		} while(run);
	}
	
	//check to see if user wants to search again
	public static boolean searchAgain(Scanner console) { 
		System.out.println("Would you like to search another name? ");
		String input = console.next();
		if (Character.toLowerCase(input.charAt(0)) == 'y')
			return true;
		else 
			return false;
	}
	
	//Creates new file with data and outputs to console
	public static void saveFilePlusOutput (Scanner line, String inputName, String nameFromFile) throws FileNotFoundException{
		PrintStream nameOutput = new PrintStream(new File(inputName + ".txt"));
		nameOutput.println("name? \n" + inputName);
		int i = 0;
		while(line.hasNext()) {
			int rank = line.nextInt();
			nameOutput.println(1900 + i + ": " + rank );
			System.out.println(1900 + i + ": " + rank);
			i += 10;
		}
		
	}

}
