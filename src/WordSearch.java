
import java.util.ArrayList;
import java.util.Random;
import java.util.Random.*;

//Programmer: Quinn Murphy
//Date: 11/4/22
//Class: CS 145
//Assignment: Word Search
//References: Book, StackOverflow, class
// Here is the WordSearch class. First it makes a 
// 20x20 board of random chars to use for our game. 
// It then has methods for placing the words on the 
// board, a toString for java, and a method to check if
// we are accidently overlapping words.

public class WordSearch {

	private boolean[][] filledSpace; // if space is filled
	private char[][] letterGrid; // 2d array

	Random rand = new Random();

	// constructor
	public WordSearch() {
		// alright so this makes the randomized grid of letters,
		// it looks complex but its just a 2d array with
		// random letters added. I used a randomizer this time
		// which prints random chars on the 20 x 20 grid.
		// We can run just this and get a randomized grid.
		this.letterGrid = new char[20][20];
		this.filledSpace = new boolean[20][20];

		for (int i = 0; i < this.letterGrid.length; i++) {

			for (int j = 0; j < this.letterGrid[i].length; j++) {
				// literally just a nested for loop 20x20 converted
				// to chars
				this.letterGrid[i][j] = (char) ('A' + rand.nextInt(25));

			}
		}

	}
	
	
	
	

	public void putWords(String[] userWords) {



		// multiple words, loop through words
		for (int i = 0; i < userWords.length; i++) {
			// temp integers for java, need to pass
			// into placeword and checkOverlap
			int x;
			int y;
			int wordDirection;
			
			// set x and y positions to random, with the
			// randomizer calculating if the word will be 
			// horizontal or vertical. 

			do {
				x = rand.nextInt(this.letterGrid.length - userWords[i].length());
				y = rand.nextInt(this.letterGrid.length - userWords[i].length());

				wordDirection = rand.nextInt(2);
				
				// be sure we are not overlapping while placing words.

			} while (checkOverlap(userWords[i], wordDirection, x, y) == true);
			placeWord(userWords[i], wordDirection, x, y);

		}
		
		// for every word, print the string. 

		for (String x : userWords) {
			System.out.println(x + "\n");
		}

	}

	private void placeWord(String word, int wordDirection, int x, int y) {

		for (int i = 0; i < word.length(); i++) {
			// alright heres another thing that looks complex.
			// All we are doing is looping once again
			// through the char array, but if our random
			// number is 0, we will go y + i to print
			// the word horizontally, if its 1 we
			// go vertical.

			// horizontal
			if (wordDirection == 0) {

				if (letterGrid[x][y + i] == word.charAt(i)) {
					System.out.println("intersect.. wrong");
				}

				this.letterGrid[x][y + i] = word.charAt(i);
				this.filledSpace[x][y + i] = true; // boolean true when space is
				// filled with word

			}

			// vertical
			else {
				this.letterGrid[x + i][y] = word.charAt(i);
				this.filledSpace[x + i][y] = true;
			}

		}
	}

	public String toString() {

		// simple tostring here, took the same
		// nested loop but replaced the inside with
		// just adding the chars to a String (result)
		// again, nested for loop because we need
		// columns and rows.

		String result = "";

		for (int i = 0; i < this.letterGrid.length; i++) {

			for (int j = 0; j < this.letterGrid[i].length; j++) {
				result += this.letterGrid[i][j] + " ";

			}
			// new line after each row of letters...
			result += "\n";
		}

		return result;
	}
	
	
	// prevents overlaps from occuring, if 
	// a space is filled already and there is 
	// not a word in both vert and horizontal
	// spots, return true. otherwise false.
	private boolean checkOverlap(String word, int x, int y, int wordDirection) {
		for (int i = 0; i < word.length(); i++) {

			if (wordDirection == 0) {
				if (this.filledSpace[x][y + i] == true && this.letterGrid[x][y + i] != word.charAt(i)) {

					return true;
				}

				// filled with word
			}

			// vertical
			else {
				if (this.filledSpace[x + i][y] == true && this.letterGrid[x][y + i] != word.charAt(i)) {
					return true;
				}

			}

		}
		return false; // word doesn't overlap

	}


}
