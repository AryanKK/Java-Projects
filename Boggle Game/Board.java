import java.util.ArrayList;
import java.util.Collections;

public class Board {
	
	private String[][] boggleBoard;
	private WordList wordList;
	
	public Board(int boardSize, WordList wordList)//constructs board and populates board
	{
		boggleBoard = new String[boardSize][boardSize];
		this.wordList = wordList;
	        for (int i = 0; i < boggleBoard.length; i++) {
	            for (int j = 0; j < boggleBoard[i].length; j++) {
	            	boggleBoard[i][j] = Character.toString(getRandomCharacter());
	            }
	        }		
	}

	private String getRandomWord(){//gets random word
		String randomWord = wordList.get((int)(Math.random()*wordList.size())); 
		return randomWord;
	}
	
	private char getRandomCharacter(){//gets random char 
		
		String s = getRandomWord();	
		char c = s.charAt((int)(Math.random()*s.length()));
		return c;
	}	
	
	private boolean isWord(String str) //returns whether word is a word according to list
	{
		
		return wordList.contains(str);
	}
	

		private void findWordsRecursively(boolean traversed[][], int i,
								int j, String str, ArrayList<String> wordsFound)
		{
			// Mark current cell as traversed and append current character
			// to str
			traversed[i][j] = true;
			str = str + boggleBoard[i][j];

			// If str is present in dictionary, then print it
			if (isWord(str) && !wordsFound.contains(str)) {
				
				wordsFound.add(str);
			}

			if (str.length() < wordList.getLongestWordLength()) {
			// Traverse (longest word length) adjacent cells of boggle[i][j]
			for (int row = i - 1; row <= i + 1 && row < boggleBoard.length; row++)
				for (int col = j - 1; col <= j + 1 && col < boggleBoard.length; col++)
					if (row >= 0 && col >= 0 && !traversed[row][col])
						findWordsRecursively(traversed, row, col, str, wordsFound);
			}
			// Erase current character from string and mark traversed
			// of current cell as false
			str = "" + str.charAt(str.length() - 1);
			traversed[i][j] = false;
		}

		// Return all words present in wordList.
		public ArrayList<String> find()
		{
		
			// Mark all characters as not traversed
			boolean traversed[][] = new boolean[boggleBoard.length][boggleBoard.length];
			ArrayList<String> wordsFound = new ArrayList<String>();

			// Initialize current string
			String str = "";

			// Consider every character and look for all words
			// starting with this character
			for (int i = 0; i < boggleBoard.length; i++)
				for (int j = 0; j < boggleBoard.length; j++)
					findWordsRecursively(traversed, i, j, str, wordsFound);
			Collections.sort(wordsFound, new WordComparator());
			return wordsFound;
		}
	
	public String toString() {//gives string representation of board
		
		String board = "";

        for (int i = 0; i < boggleBoard.length; i++) {
            for (int j = 0; j < boggleBoard[i].length; j++) {
            	board += boggleBoard[i][j] + "   ";
            }
            
        	board += "\n";
        }
		return board;
		
	}
	
}
