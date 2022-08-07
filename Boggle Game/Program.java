/*Aryan Kedarisetty
 * boggle uses backtracking techniques and OOP to find the number 
 * of words from a given random "boggle board"
 */



import java.util.ArrayList;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 3, max = 8;
		System.out.println("Welcome to Boggle,  by Aryan Karthikeya Kedarisetty.");//announcement
		
		WordList wordlist = new WordList("WordList.txt", min, max);//instantiation of word list object
		Board b = new Board(4, wordlist);//instantiation of board
		System.out.println(b);//display board		
		display(b.find()); //call to find method and display results
		
	}

	public static void display(ArrayList<String> wordsFound) { //displays wordsFound
		
		System.out.printf("Found %d word(s)\n", wordsFound.size());
		
		int wordLengthCounter = 0;
		int wordLength = 0;
		for (int i = 0 ; i < wordsFound.size() ; i++) {
			wordLength =  wordsFound.get(i).length();
			if (wordLengthCounter > wordLength || i == 0) {
				wordLengthCounter = wordLength ;
				System.out.println("\n" + wordLengthCounter + " letter words");
			}
			System.out.println(wordsFound.get(i));
			
		}

		
	}

}
