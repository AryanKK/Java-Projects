/*
 Aryan Kedarisetty 
 
 The following program utilizes conditionals, iterative loops, 
 methods, files & scanner objects and primarily arrays. To solve the problem of being able to produce the 
 sum of integers that exceed the storage limit of java, each digit is split through an integer array that 
 uses carry forward algorithm to output the sum of each line to the console.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Sum {
	public static final int LIMIT = 25; //changeable limit of digits

	public static void main(String[] args) throws FileNotFoundException {
		//feeds file object of sum.txt to console
		File f = new File("sum.txt");
		Scanner console = new Scanner(f);
		computeFile(console); 
	}

	//reads through whole file producing output
	public static void computeFile(Scanner console)  {
		
		int lineCount = 0;
		while (console.hasNextLine()) {
			Scanner line = new Scanner(console.nextLine());
			int[] finalSum = computeLineSum(line); 
			
			printSum(finalSum);
			lineCount++;
		}
		System.out.println("Total lines: " + lineCount);
		console.close();
	}

	//finds and prints the equation and sum of one line
	public static int[] computeLineSum(Scanner line) {
		int [] valueArr = new int [LIMIT]; //creates array for numbers to be stored and added to
		
		String value = eliminateZeroes(addToSum(line, valueArr));	
		System.out.print(value);
		while(line.hasNext()) {
			
			value = eliminateZeroes(addToSum(line, valueArr));	
			System.out.print(" + " + value);
		}
		return valueArr;
	}
	
	//eliminates any leading zeroes of summands
	public static String eliminateZeroes(String s) {
		int i = 0;
		while (s.charAt(i) == '0') {
			if (i == s.length() - 1 && s.charAt(i) == '0') {
				return "0";
			}
			i++;
		}
		return s.substring(i, s.length());
	}
	
	//adds to array every new token
	public static String addToSum(Scanner line, int[] valueArr) {
		//default values will be 0's, therefore any untouched spaces in the array will be leading zero
		String value = line.next();
		int startingPos = LIMIT - value.length();
		for (int i = LIMIT-1; i >= 0; i--) { //starts adding numbers from end of array
			
			if (i >= startingPos)  //adds to corresponding spot in array
				//string tokens are split into integer digits and added to corresponding array position
			valueArr[i] += Character.getNumericValue((value.charAt(i- startingPos))); 
			
			//if the number exceeds 10 after addition, it will carry forward the ten's place
			if (valueArr[i] >= 10) {// carry forward algorithm
				valueArr[i-1] += valueArr[i] / 10;
				valueArr[i] = valueArr[i] % 10;			
			}	
		}
		return value;
	}
	
	//prints the sum in number form from the array
	public static void printSum(int[] valueArr) {
		System.out.print(" = ");
		String sum = "";
		for (int i = 0; i < LIMIT; i++) {
			sum += Integer.toString(valueArr[i]);
		}
		System.out.println(eliminateZeroes(sum));
	}

}
