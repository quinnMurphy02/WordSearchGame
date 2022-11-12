import java.util.Scanner;

//Programmer: Quinn Murphy
//Date: 11/4/22
//Class: CS 145
//Assignment: Word Search
// References: Book, StackOverflow, class
// Alright so here is the WordSearchMain class.
// It has the main method with the switch case for the
// user input, with the initialization of the userWords
// string array. We also call a WordSearch object to use
// for our main method.

public class WordSearchMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] userWords = new String[5];
		WordSearch puzzle = new WordSearch();

		String userchoice = "";

		boolean quit = true;

		// simple while loop/switch case as always here
		// copied and pasted on of my old ones
		// from another program and changed
		// the methods. It works.

		while (quit) {

			switch (userchoice) {
			// used a switch case here, for fun.
			case "g":
				generate(scan, puzzle);
				break;

			case "p":
				print(puzzle);

				break;
			case "s":
			print(puzzle);

				break;

			case "q":
				System.out.println("Thanks for using the Word Search Game!");
				System.exit(0); // will just leave program
				quit = false;
				break;

			}

			printIntro();
			userchoice = scan.next();

		}

	}

	public static void printIntro() {

		System.out.println("Welcome to my word search generator!");
		System.out.println("This program will allow you to generate your own word search puzzle.");
		System.out.println("Please select an option:");
		System.out.println("Generate a new word search (g)");
		System.out.println("Print out your word search (p)");
		System.out.println("Show solution to your word search (s)");
		System.out.println("Quit the program.");

	}
	
	// generate. This will take a string array and let the 
	// user input words to use for their word search. It then
	// uses the wordSearch object puzzle to place the 
	// words randomly on the 20x20 board of chars. It is 
	// quite simple.

	public static void generate(Scanner scan, WordSearch puzzle) {
		String[] userWords = new String[6];
		
		// allows user to input 5 words. 
		System.out.println("Please enter 5 words?");

		for (int i = 0; i < userWords.length; i++) {
			userWords[i] = scan.nextLine();
		}

		// Just to test
		System.out.println(userWords[0]);

//		WordSearch puzzle = new WordSearch();
		puzzle.putWords(userWords);

	}
	
	// Sadly I could not figure out how to make the 
	// board print the words with the random chars as
	// 'x' to show the solution. As a placeholder I just 
	// printed the board again. 
	
	public static void printSolution(WordSearch puzzle) {
		System.out.println();
	}
	
	// simply prints the WordSearch with a println.

	public static void print(WordSearch puzzle) {
		System.out.println(puzzle);
	}
	
	
	

}
