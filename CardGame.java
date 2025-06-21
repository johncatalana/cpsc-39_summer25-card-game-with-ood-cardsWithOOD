// John Catalana
// June 20, 2025
// Card Game with OOD


// package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	private static ArrayList<Card> deckOfCards = new ArrayList<Card>(); // Stores the full deck of cards
	private static ArrayList<Card> playerCards = new ArrayList<Card>(); // Stores the cards dealt to the player


	public static void main(String[] args) {

		Scanner input = null;
		try {
			// opens the file containing card datqa
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}
		// Read card data line by line and create card objects
		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			// public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard); // Add card to the deck
		}

		shuffle(); // Shuffles the deck before dealing

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 5; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		
		// Check and display if the player has a pair (two cards with same value)
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c + " (Value: " + c.getValue() + ")");

		System.out.println("pairs is " + checkFor2Kind());
		System.out.println("three of a kind is " + checkFor3Kind());

	}//end main


	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0; // Loops through each pair of cards in the player's hand
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				// compares the value of two cards
				if(current.getValue() == next.getValue()) {
					count++; // found a pair
			}//end of inner for
			if(count == 1)
				return true;
		}

		}//end outer for
		return false;
	}

	//NEW METHOD: Checks if there are 3 cards of the same value
	public static boolean checkFor3Kind() {
		for (int i = 0; i < playerCards.size(); i++) {
			Card current = playerCards.get(i);
			int matchCount = 1; // Starting with 1 current card

			for (int j = 0; j < playerCards.size(); j++) {
				if (i != j) { // Dont compare the card to itelf
					Card other = playerCards.get(j);
					if (current.getValue() == other.getValue()) {
						matchCount++;
					}
				}
			}
			// If we found exactly 3 cards with the same value, return true
			if (matchCount == 3) {
				return true;
			}
		}
		return false; // No 3 of a kind
	}
}//end class