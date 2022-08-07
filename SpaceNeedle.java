/*
 This program is an ASCII art of the Space Needle. I used six static methods
  to eliminate redundancy and decompose the problem. I also used a class constant throughout 
  my code which allows the art to be scalable.
 */
public class SpaceNeedle {
	//class constant determines size of Space Needle
	public static final int CONSTANT = 5; 
	//Forms Space Needle 
	public static void main(String[] args) { 
		needle(); 
		topBase();
		lowerBase();
		needle();
		midsection();
		topBase();
	}
	//Forms the needle on top of the base
	public static void needle() { 
		for (int line = 1; line <= CONSTANT; line++) {
			for (int j = 1; j <= CONSTANT*3 ; j++) {
				System.out.print(" ");
			}
			System.out.println("||");
				
		}
	}
	//forms the top portion under the needle and the base at the bottom
	public static void topBase() {
		for (int line = 1; line <= CONSTANT; line++) { //Forms upper triangle portion with dots
			for (int space = 1; space <= -3 * line + (CONSTANT*3); space++) {
				System.out.print(" ");
			}
			
			System.out.print("__/");
			 
			for (int j = 1; j <= 3 * line - 3; j++) {
				System.out.print(":");
			}
			
			System.out.print("||");
			
			for (int j = 1; j <= 3 * line - 3; j++) {
				System.out.print(":");
			} 
			System.out.println("\\__");	
		}
		System.out.print("|");
		for (int i = 1; i <= CONSTANT*6; i++) {
			System.out.print("\"");
		}
		System.out.println("|");
	}

	public static void lowerBase() {//Creates the base under the upper triangle portion of head
		
		for (int line = 1; line <= CONSTANT; line++) {
			
			for(int space = 1; space <= 2*line - 2; space++) {
				System.out.print(" ");
				
			}
			System.out.print("\\_/");
			for (int j = 1; j <= -2*line + (CONSTANT*3); j++) { 
				System.out.print("\\/");
			}
			System.out.println("\\_/");;	
		}
		
	}
	public static void midsection() {//forms the midsection/neck of the space needle
		for (int i = 1; i <= CONSTANT * CONSTANT; i++) {
			for (int j=1; j<= CONSTANT*2 + 1; j++) {
				System.out.print(" ");
			
				
			}
			System.out.print("|");
			for (int j = 1; j <= CONSTANT-2; j++ ) {
				System.out.print("%");
				
			}
			System.out.print("||");
			for (int j = 1; j <= CONSTANT-2; j++ ) {
				System.out.print("%");
				
			}
			System.out.println("|");
			
			
		}
		
	}
	
		
				
			
}


